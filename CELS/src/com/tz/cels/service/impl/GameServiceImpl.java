package com.tz.cels.service.impl;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.dao.impl.BaseTermDaoImpl;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;
import com.tz.cels.exceptions.NohistoryException;
import com.tz.cels.service.IGameService;

public class GameServiceImpl implements IGameService
{

	@Override
	public Map<String, String> en2cn(boolean isNew)
	{
		Map<String, String> map = new TreeMap<>();
		if (isNew)
		{
			IBaseTermDao dao = new BaseTermDaoImpl();
			Set<Word> words = dao.getAllWords();
			for (Word word : words)
			{
				StringBuilder s = new StringBuilder();
				for(int i=0;i<word.getCn().length;i++){
					s=s.append(word.getCn()[i]+",");
				}
				map.put(word.getEn(), s.toString());
			}

			Set<Vocabulary> vocabularies = dao.getAllVocabularies();
			for (Vocabulary v : vocabularies)
			{
				StringBuilder s = new StringBuilder();
				for(int i=0;i<v.getCn().length;i++){
					s=s.append(v.getCn()[i]+",");
				}
				map.put(v.getEn(),s.toString());
			}

		} else
		{
			File file = new File(EN_TO_CN_FILE);
			if (!file.exists())
			{
				try
				{
					throw new NohistoryException("历史文件不存在异常");
				} catch (NohistoryException e)
				{
					e.printStackTrace();
				}
			}
			IBaseTermDao dao = new BaseTermDaoImpl();
			map = dao.readFromFile(EN_TO_CN_FILE);
		}
		return map;
	}

	@Override
	public Map<String, String> cn2en(boolean isNew)
	{

		Map<String, String> map = new TreeMap<>();
		if (isNew)
		{
			IBaseTermDao dao = new BaseTermDaoImpl();
			Set<Word> words = dao.getAllWords();
			for (Word word : words)
			{
				StringBuilder s = new StringBuilder();
				for(int i=0;i<word.getCn().length;i++){
					s=s.append(word.getCn()[i]+",");
				}
				map.put(s.toString(), word.getEn());
			}

			Set<Vocabulary> vocabularies = dao.getAllVocabularies();
			for (Vocabulary v : vocabularies)
			{
				StringBuilder s = new StringBuilder();
				for(int i=0;i<v.getCn().length;i++){
					s=s.append(v.getCn()[i]+",");
				}
				map.put(s.toString(),v.getEn());
			}

		} else
		{
			File file = new File(CN_TO_EN_FILE);
			if (!file.exists())
			{
				try
				{
					throw new NohistoryException("历史文件不存在异常");
				} catch (NohistoryException e)
				{
					e.printStackTrace();
				}
			}
			IBaseTermDao dao = new BaseTermDaoImpl();
			map = dao.readFromFile(CN_TO_EN_FILE);
		}
		return map;
	}

	@Override
	public void saveGameHistory(Map<String, String> map, boolean en2cn)
	{
		File file = new File(HISTORY_DIR);
		if (!file.exists())
		{
			//创建父目录
			file.mkdirs(); 
		}
		
		String path = null;
		if(en2cn){
			path=EN_TO_CN_FILE;
		}else{
			path=CN_TO_EN_FILE;
		}
		
		IBaseTermDao dao = new BaseTermDaoImpl();
		dao.writeToFile(map, path);
	}

}
