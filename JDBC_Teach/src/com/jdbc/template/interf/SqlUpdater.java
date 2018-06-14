package com.jdbc.template.interf;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlUpdater {

    void execute(Connection conn) throws SQLException;
    
}
