package com.tz.cels.exceptions;

public class NohistoryException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7651325180368069442L;

	public NohistoryException()
	{
		super();
	}

	public NohistoryException(String msg)
	{
		super(msg);
	}

	public NohistoryException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

	public NohistoryException(Throwable cause)
	{
		super(cause);
	}

}
