package com.tz.cels.dao;

import java.util.List;

import com.tz.cels.entity.TestRecord;

//测试记录的数据访问对象，为支撑第三个业务【测试业务】而设计的数据
public interface ITestRecordDao
{
	// 持久化测试记录，每次都要先读取已经存在的历史记录，并把此record
	void write(List<TestRecord> records, String fileName);

	/***
	 * 加载所有的已保存的测试记录，并返回整个List
	 * 
	 * @return
	 */
	List<TestRecord> read(String fileName);
}
