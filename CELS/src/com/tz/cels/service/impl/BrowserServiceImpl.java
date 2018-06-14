package com.tz.cels.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.entity.PageBean;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.service.IBrowserService;

public class BrowserServiceImpl implements IBrowserService
{

	@Override
	public Map<Character, Set<Word>> getFirstMap()
	{
		IBaseTermDao baseTermDao = new BaseTermDaoImpl();
		Map<Character, Set<Word>> datas = new TreeMap<Character, Set<Word>>();
		Set<Word> words = baseTermDao.getAllWords();
		Set<Word> sfwords = new TreeSet<>();

		for (char c = 'a'; c <= 'z'; c++)
		{
			for (Word word : words)
			{
				if (c == word.getEn().toLowerCase().charAt(0))
				{
					sfwords.add(word);
					datas.put(c, sfwords);
				}
			}
			sfwords = new TreeSet<>();
		}
		return datas;
	}

	@Override
	public PageBean getPageVocabularies(int pageTo)
	{
		/*
		 * IBaseTermDao dao = new BaseTermDaoImpl(); Set<Vocabulary> set =
		 * dao.getAllVocabularies(); int size =PAGE_SIZE; List<Vocabulary> list
		 * = new ArrayList<>(); list.addAll(set);
		 * 
		 * //List<Vocabulary> pagelist = new ArrayList<>();
		 * 
		 * PageBean p = new PageBean(list,size); return p;
		 */
		int pageSize = PAGE_SIZE;
		PageBean pageBean = new PageBean();
		IBaseTermDao dao = new BaseTermDaoImpl();
		Set<Vocabulary> vocabularies = dao.getAllVocabularies();
		List<Vocabulary> lists = new ArrayList<>();
		lists.addAll(vocabularies);
		int size = vocabularies.size();
		List<Vocabulary> subVocabularies = new ArrayList<>();
		for (int i = pageSize * (pageTo - 1); i < ((pageSize * pageTo  > size) ? size : pageSize * pageTo ); i++)
		{
			subVocabularies.add(lists.get(i));
		}
		pageBean.setVdatas(subVocabularies);
		pageBean.setTotal(vocabularies.size());
		pageBean.setPageSize(pageSize);
		pageBean.setPages(size % pageSize == 0 ? size / pageSize : (size / pageSize + 1));
		return pageBean;
	}

	@Override
	public PageBean getPageWords(int pageTo,Set<Word> words)
	{
		int pageSize = PAGE_SIZE;
		PageBean pageBean = new PageBean();
		//IBaseTermDao dao = new BaseTermDaoImpl();
		//Set<Word> words = dao.getAllWords();
		List<Word> lists = new ArrayList<>();
		lists.addAll(words);
		int size = words.size();
		List<Word> subWords = new ArrayList<>();
		for (int i = pageSize * (pageTo - 1); i < ((pageSize * pageTo  > size) ? size : pageSize * pageTo ); i++)
		{
			subWords.add(lists.get(i));
		}
		pageBean.setWdatas(subWords);
		pageBean.setTotal(words.size());
		pageBean.setPageSize(pageSize);
		pageBean.setPages(size % pageSize == 0 ? size / pageSize : (size / pageSize + 1));
		return pageBean;
	}

}
