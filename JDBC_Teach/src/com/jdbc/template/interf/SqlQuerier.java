package com.jdbc.template.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlQuerier<E> {

    E execute(Connection conn) throws SQLException;
}
