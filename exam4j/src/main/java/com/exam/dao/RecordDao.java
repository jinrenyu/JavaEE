package com.exam.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.exam.entity.Record;

public interface RecordDao {

    List<Record> getAllRecords();
    
    List<Record> searchByCondition(String sCode, String sType, 
            Date ssDate, Date seDate, Date esDate, Date eeDate);
    
    void addReacord(Session session, Record record);
    
    void checkOut(Session session, Integer recordId, Date endDate, Double total);
    
    Record getRecordById(Integer id);
}
