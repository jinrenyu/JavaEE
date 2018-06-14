/**
 * 
 */
package com.tz.day14;

/**本类用来演示
 * @author 吴老师
 *
 * 2017年3月17日下午3:41:33
 */
public enum Season
{
	SPRING("春季"){
		//匿名内部类，并重写 抽象next方法
		@Override
		public Season next()
		{
			return SUMMER;
		}
	},
	//public static final Season SRPING = new Season("春天");
	
	SUMMER("夏季"){
		@Override
		public Season next()
		{
			return AUTUMN;
		}
	},
	
	AUTUMN("秋季") {
		
		@Override
		public Season next()
		{
			return WINTER;
		}
	},
	
	WINTER("冬季") {
		
		@Override
		public Season next()
		{
			return SPRING;
		}
	};
	
	//属性
	private String value;
	
	//带参构造
	private Season(String value) {
		this.value = value;
	}

	//重写父类的toString方法
	@Override
	public String toString()
	{
		return this.value;
	}
	
	//抽象方法
	public abstract Season next();
	
}
