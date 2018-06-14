package com.tz.cels.service;

import java.util.List;

import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.exceptions.NoTestRecordException;

public interface ITestingService
{
	String TESTRECORD_DIR = "data/testing";
	
	String TEST_RECORD_FILE = "records.rec";
	
	
	List<BaseTerm> getTestingData(int num);
	
	
	List<TestRecord> reviewTestRecord() throws NoTestRecordException;
	
	
	void saveTestRecord(TestRecord record);
}
