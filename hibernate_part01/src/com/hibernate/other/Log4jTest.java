package com.hibernate.other;

import org.apache.log4j.Logger;

public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        logger.debug("����һ��������Ϣ");
        logger.info("����һ����ͨ��Ϣ");
        logger.warn("����һ��������Ϣ");
        logger.error("����һ��������Ϣ");
    }

}
