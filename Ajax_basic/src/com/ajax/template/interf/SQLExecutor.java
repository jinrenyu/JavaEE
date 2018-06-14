package com.ajax.template.interf;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface SQLExecutor {

    PreparedStatement execute(Connection conn);
    
}
