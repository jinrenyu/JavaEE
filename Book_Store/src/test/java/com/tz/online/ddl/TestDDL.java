package com.tz.online.ddl;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.testng.annotations.Test;

public class TestDDL {
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
