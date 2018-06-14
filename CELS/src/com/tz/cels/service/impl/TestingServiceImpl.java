package com.tz.cels.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.dao.impl.TestRecordDaoImpl;
import com.tz.cels.entity.BaseTerm;
import com.tz.cels.entity.TestRecord;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NoTestRecordException;
import com.tz.cels.service.ITestingService;

public class TestingServiceImpl implements ITestingService
{
	private ITestRecordDao testRecordDao = new TestRecordDaoImpl();
	private IBaseTermDao baseTermDao = new BaseTermDaoImpl();

	@Override
	public List<BaseTerm> getTestingData(int num)
	{
		List<BaseTerm> list = new ArrayList<>();
		Set<Word> words = baseTermDao.getAllWords();
		for (Word w : words)
		{
			list.add(w);
		}

		Set<Vocabulary> voca = baseTermDao.getAllVocabularies();
		for (Vocabulary v : voca)
		{
			list.add(v);
		}
		// 打乱LIst
		Collections.shuffle(list);

		// list.get(0);
		int n = num;

		List<BaseTerm> retlist = new ArrayList<>();
		for (int i = 0; i < list.size(); i++)
		{
			if (i == n)
			{
				break;
			}
			retlist.add(list.get(i));
		}
		return retlist;
	}

	@Override
	public List<TestRecord> reviewTestRecord() throws NoTestRecordException
	{
		List<TestRecord> list = new ArrayList<>();
		File dir = new File(TESTRECORD_DIR);
		if (!dir.exists())
		{
			dir.mkdirs();
		}

		File file = new File(dir+"/"+TEST_RECORD_FILE);
		if (!file.exists())
		{
			try
			{
				throw new NoTestRecordException("测试记录文件不存在异常");
			} catch (NoTestRecordException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(file.length());
		// 如果没有抛出异常，则调用dao来读取数据
		list = testRecordDao.read(dir+"/"+TEST_RECORD_FILE);

		return list;
	}

	@Override
	public void saveTestRecord(TestRecord record)
	{
		File dir = new File(TESTRECORD_DIR);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		List<TestRecord> newRecords =new ArrayList<>();
		File file = new File(dir+"/"+TEST_RECORD_FILE);
		if (file.exists())
		{
			newRecords=testRecordDao.read(dir+"/"+TEST_RECORD_FILE);
			//System.out.println(newRecords==null);
			if(newRecords==null){
				List<TestRecord> nrecords = new ArrayList<>();
				nrecords.add(record);
				Collections.sort(nrecords);
				testRecordDao.write(nrecords, dir+"/"+TEST_RECORD_FILE);
			}else{
			
			newRecords.add(record);
			Collections.sort(newRecords);
			testRecordDao.write(newRecords, dir+"/"+TEST_RECORD_FILE);}
		} else
		{
			
			List<TestRecord> nrecords = new ArrayList<>();
			nrecords.add(record);
			newRecords=nrecords;
		}
		
		//testRecordDao.write(newRecords, dir+"/"+TEST_RECORD_FILE);

	}

}
