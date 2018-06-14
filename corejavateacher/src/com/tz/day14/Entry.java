/**
 * 
 */
package com.tz.day14;

/**本类用来演示 泛型类
 * @author 吴老师
 *
 * 2017年3月17日上午10:11:50
 */
public class Entry<K, V>
{
	//属性
	private K key;
	private V value;
	public Entry(K key, V value)
	{
		super();
		this.key = key;
		this.value = value;
	}
	public Entry()
	{
		super();
	}
	public K getKey()
	{
		return key;
	}
	public void setKey(K key)
	{
		this.key = key;
	}
	public V getValue()
	{
		return value;
	}
	public void setValue(V value)
	{
		this.value = value;
	}
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Entry [key=").append(key).append(", value=").append(value).append("]");
		return builder.toString();
	}
	
}
