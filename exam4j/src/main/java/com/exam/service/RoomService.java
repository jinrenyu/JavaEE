package com.exam.service;

import com.exam.entity.enumeration.Status;

public interface RoomService {

    String getJsonRoomType();
    
    String getJsonRoomCode(Status[] status);
    
    String getTypeByCode(String code);
}
