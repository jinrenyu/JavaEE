package com.hibernate.other;

import org.apache.log4j.Logger;

public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        logger.debug("我是一条调试信息");
        logger.info("我是一条普通信息");
        logger.warn("我是一条警告信息");
        logger.error("我是一条错误信息");
    }

}
