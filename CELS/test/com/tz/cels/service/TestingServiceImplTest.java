package com.tz.cels.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.dao.impl.TestRecordDaoImpl;
import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.service.impl.TestingServiceImpl;

public class TestingServiceImplTest
{
	@Test
	public void test1()
	{

		ITestingService ts = new TestingServiceImpl();
		List<BaseTerm> list = new ArrayList<>();
		list=ts.getTestingData(3);
		for (BaseTerm b : list)
		{
			System.out.println(b);
		}
	}
	
	@Test
	public void test2()
	{

		ITestingService ts = new TestingServiceImpl();
		List<TestRecord> list = new ArrayList<>();
		try
		{
			list=ts.reviewTestRecord();
			for (TestRecord t : list)
			{
				System.out.println(t);
			}
		} catch (NoTestRecordException e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3()
	{

		ITestingService ts = new TestingServiceImpl();
		TestRecord record = new TestRecord();
		Date date = new Date();
		List<BaseTerm> list = new ArrayList<>();
		IBaseTermDao dao = new BaseTermDaoImpl();
		Set<Word> words = new TreeSet<>();
		words=dao.getAllWords();
		for (Word w : words)
		{
			list.add(w);
		}
		
		record.setCount(5);
		record.setDate(date);
		record.setFinishcount(5);
		record.setRightcount(3);
		record.setWrongcount(2);
		record.setTime(546);
		record.setList(list);
		ts.saveTestRecord(record);
	}
	@Test
	public void test4(){
		File dir = new File(ITestingService.TESTRECORD_DIR);
		ITestRecordDao st = new TestRecordDaoImpl();
		List<TestRecord> list = new ArrayList<>();
//		list=st.read("test.txt");
		list=st.read(dir+"/"+ITestingService.TEST_RECORD_FILE);
		
		for (TestRecord T : list)
		{
			System.out.println(T);
		}
		
	}

}
