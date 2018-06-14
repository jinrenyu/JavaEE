package com.tz.day09;

public class Player extends LOLGame
{

	@Override
	public void start_match()
	{
		System.out.println("开始匹配");
	}

	@Override
	public void choose_hero()
	{
		System.out.println("选择hero");
	}

	@Override
	public void start_game()
	{
		System.out.println("开始游戏");
	}

	@Override
	public void play_game()
	{
		System.out.println("进行游戏");
	}

	@Override
	public void over_game()
	{
		System.out.println("结束游戏");
	}
	
}
