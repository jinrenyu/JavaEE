package com.jdbc.template.interf;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface SQLExecutor {

    // 定义一个接口作为模板的参数
    PreparedStatement execute(Connection conn);
    
}
