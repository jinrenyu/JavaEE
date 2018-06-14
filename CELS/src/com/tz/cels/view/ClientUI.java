package com.tz.cels.view;

public class ClientUI
{
	/***
	 * 编写欢迎界面的方法
	 */
	public void welcome()
	{
		System.out.println("*********************************************");
		System.out.println("*项目代号：CELS                               *");
		System.out.println("*Computer English Learning Software          *");
		System.out.println("*版本V0.1                                   *");
		System.out.println("*作者：天智教育                                                                       *");
		System.out.println("*描述：");
		System.out.println("*      本软件是为让使用者充分利用零星时间来*");
		System.out.println("*      学习计算机英语单词和词汇，它采用一种*");
		System.out.println("*      基于全命令行式的方式学习，即可以浏览*");
		System.out.println("*      来学习，也可以做游戏的方式学习，还提*");
		System.out.println("*      供测试自己水平的功能，这个软件可以成*");
		System.out.println("*      为我们学习编程的一个小工具；本产品*");
		System.out.println("*      不做任何的商业用途，欢迎交流使用     *");
		System.out.println("*Mailto: xxxx@163.com                   *");
		System.out.println("*如在使用中发现任何的Bug，请邮件给作者*");
		System.out.println("***************************************\n");
	}

	/**
	 * 主菜单
	 */

	public void mainMenu()
	{
		System.out.println("______________________________");
		System.out.println("# 1.\t浏览基库【单词与词汇】");
		System.out.println("# 2.\t做游戏学习单词【随机性】");
		System.out.println("# 3.\t测试自己的水平【随机性】");
		System.out.println("# 4.\t查询单词");
		System.out.println("# 0.\t退出");
		System.out.println("-------------------------------");
	}

	/**
	 * 浏览基库子菜单
	 */
	public void showBrowserSubMenu()
	{
		System.out.println("  -> 1.浏览单词");
		System.out.println("  -> 2.浏览词汇");
		System.out.println("  -> 0.返回上一级");
		System.out.println("------------------------------");
	}

	/**
	 * 游戏子菜单
	 */
	public void showGameSubMenu()
	{
		System.out.println("  -> 1.提示英文，回答中文");
		System.out.println("  -> 2.提示中文，回答英文");
		System.out.println("  -> 0.返回上一级");
		System.out.println("----------------------------------");
	}

	/**
	 * 测试子菜单
	 */

	public void showTestingSubMenu()
	{
		System.out.println("  -> 1.开始测试");
		System.out.println("  -> 2.我的测试记录");
		System.out.println("  -> 0.返回上一级");
		System.out.println("------------------------------------");
	}
	
	/**
	 * 查询子菜单
	 */
	public void showQuerySubMenu(){
		System.out.println("  -> 1.英文查询中文");
		System.out.println("  -> 2.中文查询英文");
		System.out.println("  -> 0.返回上一级");
		System.out.println("------------------------------------");
	}

}
