package com.exam.service;

import java.util.List;

import com.exam.entity.Record;

public interface RecordService {

    List<Record> getAllRecords();
    
    List<Record> searchByCondition(String sCode, String sType, 
            String ssDate, String seDate, String esDate, String eeDate);
    
    String searchByConJsonStr(String sCode, String sType, 
            String ssDate, String seDate, String esDate, String eeDate);
    
    String addRecord(String roomId, String startDate);
    
    String updateRecord(String recordId);
    
    Record getRecordById(String id);
}
