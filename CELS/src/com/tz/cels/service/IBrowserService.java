package com.tz.cels.service;

import java.util.Map;
import java.util.Set;

import com.tz.cels.entity.PageBean;
import com.tz.cels.entity.Word;

public interface IBrowserService
{
	int PAGE_SIZE = 15;
	
	Map<Character,Set<Word>> getFirstMap();
	
	PageBean getPageVocabularies(int pageTo);

	PageBean getPageWords(int pageTo, Set<Word> words);
}
