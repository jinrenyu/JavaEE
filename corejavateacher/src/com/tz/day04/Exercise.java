package com.tz.day04;

/*
 * 打印出[1,100]以内的所有质数
 * 每行打印10个
 */
public class Exercise
{
	public static void main(String[] args)
	{
		int count = 0;
		// System.out.println(isZhiShu(11));
		for (int i = 2; i < 100; i++)
		{
			if (isZhiShu2(i))
			{
				System.out.print(i + " ");
				count++;
				if (count % 10 == 0)
				{
					System.out.println();
				}
			}
		}
	}

	public static boolean isZhiShu(int num)
	{
		int count = 0;
		for (int i = 1; i <= num; i++)
		{
			if (num % i == 0)
			{
				count++;
			}
		}
		if (count == 2)
		{
			return true;
		}
		return false;
	}

	public static boolean isZhiShu2(int num)
	{
		boolean flag = true;
		for (int i = 2; i < num; i++)
		{
			if (num % i == 0)
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
}
