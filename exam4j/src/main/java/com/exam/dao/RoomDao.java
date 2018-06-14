package com.exam.dao;

import java.util.List;

import org.hibernate.Session;

import com.exam.entity.Room;
import com.exam.entity.enumeration.Status;
import com.exam.vo.Option;

public interface RoomDao {

    /**
     * 返回房间信息所组成的选项信息
     * @return
     */
    List<Option> getRoomOption(String code, String value);

    List<Option> getRoomOption(String code, String value, Status[] status);
    
    Room getRoomByCode(String code);
    
    void updateRoomStatus(Session session, Integer id, Status status);
    
    Room getRoomById(Session session, Integer id);
}
