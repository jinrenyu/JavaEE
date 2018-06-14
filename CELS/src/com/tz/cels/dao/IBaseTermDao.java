package com.tz.cels.dao;

import java.io.File;
import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public interface IBaseTermDao
{
	// ָ����ŵ��������ļ���λ��
	String WORD_FILE = "data/dic/w.dic";

	// ָ����Ŵʻ������ļ���λ��
	String VOCABULARY_FILE = "data/dic/v.dic";

	// ���ص��������ļ�����ȡ���еĵ������ݣ���ʹ��Set�洢������
	Set<Word> getAllWords();

	// ���شʻ������ļ�����ȡ���еĴʻ����ݣ���ʹ��Set�洢������
	Set<Vocabulary> getAllVocabularies();

	// �˷�����Ϊ֧�ֵڶ���ҵ��[����Ϸѧϰ���ʺʹʻ�ҵ��]��׼����
	void writeToFile(Map<String, String> map, String fileName);

	// ��ָ���ļ��ж���֮ǰ���־û������ݣ��Ա�����ϴ�û�д���ļ���
	Map<String, String> readFromFile(String fileName);
}
