package com.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.exam.dao.RoomDao;
import com.exam.dao.impl.RoomDaoImpl;
import com.exam.entity.enumeration.Status;
import com.exam.service.RoomService;

public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao = new RoomDaoImpl();
    
    @Override
    public String getJsonRoomType() {
        return JSON.toJSONString(roomDao.getRoomOption("roomType", "roomType"));
    }

    @Override
    public String getJsonRoomCode(Status[] status) {
        return JSON.toJSONString(roomDao.getRoomOption("code", "id", status));
    }

    @Override
    public String getTypeByCode(String code) {
        return roomDao.getRoomByCode(code).getRoomType();
    }

}
