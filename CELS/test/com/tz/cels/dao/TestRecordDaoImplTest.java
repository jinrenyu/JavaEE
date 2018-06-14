package com.tz.cels.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.dao.impl.TestRecordDaoImpl;
import com.tz.cels.entity.TestRecord;

public class TestRecordDaoImplTest
{
	@Test
	public void test1(){
	ITestRecordDao tr = new TestRecordDaoImpl();
	Date date = new Date();
	TestRecord record = new TestRecord();
	TestRecord record2 = new TestRecord();
	List<TestRecord> list = new ArrayList<>();
	record.setCount(5);
	record.setDate(date);
	record.setFinishcount(5);
	record.setRightcount(3);
	record.setWrongcount(2);
	record.setTime(546);
	list.add(record);
	tr.write(list, "data/testing/records.rec");
	}
	
	@Test
	public void test2(){
		
	}
	
}
