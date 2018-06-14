package com.hibernate.template.interf;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface QueryExecutor<E> {

    E execute(Session session) throws HibernateException;
}
