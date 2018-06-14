package com.tz.cels.exceptions;

public class NoTestRecordException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2842467365216692851L;
	public NoTestRecordException()
	{
		super();
	}

	public NoTestRecordException(String msg)
	{
		super(msg);
	}

	public NoTestRecordException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public NoTestRecordException(Throwable cause)
	{
		super(cause);
	}

}
