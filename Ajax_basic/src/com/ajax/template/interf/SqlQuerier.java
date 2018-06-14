package com.ajax.template.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlQuerier<E> {

	E execute(Connection con) throws SQLException;
}
