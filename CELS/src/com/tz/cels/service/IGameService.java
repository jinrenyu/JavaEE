package com.tz.cels.service;

import java.util.Map;

import com.tz.cels.exceptions.NohistoryException;

public interface IGameService
{
	String HISTORY_DIR = "data/history";
	
	String EN_TO_CN_FILE = "data/history/en2cn.his";
	
	String CN_TO_EN_FILE = "data/history/cn2en.his";
	
	
	
	
	
	Map<String,String> en2cn(boolean isNew) throws NohistoryException;
	
	
	Map<String, String> cn2en(boolean isNew) throws NohistoryException;
	
	void saveGameHistory(Map<String,String>map,boolean en2cn);
	
}
