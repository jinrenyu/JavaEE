package com.jdbc.template.interf;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface SQLExecutor {

    // ����һ���ӿ���Ϊģ��Ĳ���
    PreparedStatement execute(Connection conn);
    
}
