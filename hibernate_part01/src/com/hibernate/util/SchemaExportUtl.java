package com.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 本类用来演示Hibernate中SchemaExport的使用
 * SchemaExport是Hibernate用来进行进行自动建表以及脚本导出的工具类
 * 这个对象的话大多在项目开发初始阶段或者黑盒测试阶段使用,开发中一般不进行使用
 * @author Chris
 *
 * 2017年3月7日上午8:51:24
 */
public class SchemaExportUtl {

    public static void main(String[] args) {
        // 第一步, 根据主配置文件的默认路径创建一个配置对象
        Configuration cfg = new Configuration().configure();
        // 第二步, 根据创建的配置对象创建一个hbm2ddl.auto工具的执行对象实例
        SchemaExport se = new SchemaExport(cfg);
        // 第三步, 调用create方法, 执行脚本重置语句
        // 参数一: 表示是否打印执行的SQL语句, true/false
        // 参数二: 表示是否执行对应的SQL语句, true/false
//        se.setFormat(true).setOutputFile("d:/init.sql").create(true , true);
        se.create(true , true);
    }
    
}
