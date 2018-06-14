package com.exam.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alibaba.fastjson.JSON;
import com.exam.dao.RecordDao;
import com.exam.dao.RoomDao;
import com.exam.dao.impl.RecordDaoImpl;
import com.exam.dao.impl.RoomDaoImpl;
import com.exam.entity.Record;
import com.exam.entity.Room;
import com.exam.entity.enumeration.Status;
import com.exam.service.RecordService;
import com.exam.util.DateUtil;
import com.exam.util.HibernateUtil;

public class RecordServiceImpl implements RecordService {

    private final String DATE_PATTERN = "yyyy-MM-dd";
    private final String DATE_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    private RecordDao recordDao = new RecordDaoImpl();
    private RoomDao roomDao = new RoomDaoImpl();

    public List<Record> getAllRecords() {
        return recordDao.getAllRecords();
    }

    @Override
    public List<Record> searchByCondition(String sCode, String sType, String ssDate, 
            String seDate, String esDate, String eeDate) {
        List<Record> records = getbyCondition(sCode, sType, ssDate, seDate, esDate, eeDate);
        if (records.size() == 0) {
            return null;
        } else {
            return records;
        }
    }

    @Override
    public String searchByConJsonStr(String sCode, String sType, String ssDate, String seDate, String esDate,
            String eeDate) {
        List<Record> records = getbyCondition(sCode, sType, ssDate, seDate, esDate, eeDate);
        return JSON.toJSONString(records);
    }
    
    private List<Record> getbyCondition(String sCode, String sType, String ssDate, 
            String seDate, String esDate, String eeDate) {
        Date ssdate = null;
        Date sedate = null;
        Date esdate = null;
        Date eedate = null;
        try {
            ssdate = DateUtil.parseDate(ssDate, DATE_PATTERN);
            sedate = DateUtil.parseDate(seDate, DATE_PATTERN);
            esdate = DateUtil.parseDate(esDate, DATE_PATTERN);
            eedate = DateUtil.parseDate(eeDate, DATE_PATTERN);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return recordDao.searchByCondition(sCode, sType, ssdate, sedate, esdate, eedate);
    }

    @Override
    public String addRecord(String roomId, String startDate) {
        Integer id = Integer.parseInt(roomId);
        Session ses = null;
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSession();
            tx = ses.beginTransaction();
            roomDao.updateRoomStatus(ses, id, Status.CHECKIN);
            Room room = roomDao.getRoomById(ses, id);
            Record record = new Record();
            record.setStartDate(DateUtil.parseDate(startDate, DATE_MINUTE_PATTERN));
            record.setRoom(room);
            recordDao.addReacord(ses, record);
            tx.commit();
        } catch(HibernateException | ParseException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
            return "failure";
        } finally {
            HibernateUtil.close(ses);
        }
        return "success";
    }

    @Override
    public Record getRecordById(String id) {
        return recordDao.getRecordById(Integer.valueOf(id));
    }

    @Override
    public String updateRecord(String recordId) {
        Integer id = Integer.parseInt(recordId);
        Record record = recordDao.getRecordById(id);
        Integer roomId = record.getRoom().getId();
        Date now = new Date();
        Double total = DateUtil.comPareHours(record.getStartDate(), now) 
                * record.getRoom().getHourPrice();
        Session ses = null;
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSession();
            tx = ses.beginTransaction();
            roomDao.updateRoomStatus(ses, roomId, Status.CHECKOUT);
            recordDao.checkOut(ses, id, now, total);
            tx.commit();
        } catch(HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
            return "failure";
        } finally {
            HibernateUtil.close(ses);
        }
        return "success";
    }

}
