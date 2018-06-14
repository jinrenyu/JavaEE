package com.exam.template.interf;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface UpdateExecutor {
    
    void execute(Session session) throws HibernateException;
}
