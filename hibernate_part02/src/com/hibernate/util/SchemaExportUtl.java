package com.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * ����������ʾHibernate��SchemaExport��ʹ��
 * SchemaExport��Hibernate�������н����Զ������Լ��ű������Ĺ�����
 * �������Ļ��������Ŀ������ʼ�׶λ��ߺںв��Խ׶�ʹ��,������һ�㲻����ʹ��
 * @author Chris
 *
 * 2017��3��7������8:51:24
 */
public class SchemaExportUtl {

    public static void main(String[] args) {
        // ��һ��, �����������ļ���Ĭ��·������һ�����ö���
        Configuration cfg = new Configuration().configure();
        // �ڶ���, ���ݴ��������ö��󴴽�һ��hbm2ddl.auto���ߵ�ִ�ж���ʵ��
        SchemaExport se = new SchemaExport(cfg);
        // ������, ����create����, ִ�нű��������
        // ����һ: ��ʾ�Ƿ��ӡִ�е�SQL���, true/false
        // ������: ��ʾ�Ƿ�ִ�ж�Ӧ��SQL���, true/false
//        se.setFormat(true).setOutputFile("d:/init.sql").create(true , true);
        se.create(true , true);
    }
    
}
