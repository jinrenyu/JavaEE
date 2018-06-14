package com.tz.day14;

//季节游戏
public class SeasonGame
{
	private int year;
	private Season current; //当前季节
	
	public SeasonGame()
	{
		this.year = 2016; //默认年份
		this.current = Season.SPRING; //默认季节
	}
	//带参的
	public SeasonGame(int year, Season current)
	{
		super();
		this.year = year;
		this.current = current;
	}
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public Season getCurrent()
	{
		return current;
	}
	public void setCurrent(Season current)
	{
		this.current = current;
	}
	
	//启动
	public void start() {
		Season temp = this.current;
		int tyear = this.year;
		//
		while(true) {
			//打印输出当前的季节
			System.out.printf("\n年份：%d, 季节：%s\n", tyear, temp);
			//让线程休眠
			try
			{
				for(int i=10;i>=1;i--) {
					System.out.printf("%-3d 秒\r",i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			//判断年份是否要增1
			if(temp.equals(Season.WINTER)) {
				tyear++; //年份增1
			}
			//跳到下一个季节
			temp = temp.next();
		}
	}
}
