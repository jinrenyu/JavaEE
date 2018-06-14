package com.tz.day09;

public abstract class LOLGame
{
	//开始匹配
	public abstract void start_match();
	
	//选择hero
	public abstract void choose_hero();
	
	//开始游戏
	public abstract void start_game();
	
	//进行游戏
	public abstract void play_game();
	
	//结束游戏
	public abstract void over_game();
	
	//制定游戏流程
	public void game()
	{
		start_match();
		choose_hero();
		start_game();
		play_game();
		over_game();
	}
}
