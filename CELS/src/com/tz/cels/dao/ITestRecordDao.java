package com.tz.cels.dao;

import java.util.List;

import com.tz.cels.entity.TestRecord;

//���Լ�¼�����ݷ��ʶ���Ϊ֧�ŵ�����ҵ�񡾲���ҵ�񡿶���Ƶ�����
public interface ITestRecordDao
{
	// �־û����Լ�¼��ÿ�ζ�Ҫ�ȶ�ȡ�Ѿ����ڵ���ʷ��¼�����Ѵ�record
	void write(List<TestRecord> records, String fileName);

	/***
	 * �������е��ѱ���Ĳ��Լ�¼������������List
	 * 
	 * @return
	 */
	List<TestRecord> read(String fileName);
}
