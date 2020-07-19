package com.hibernate.example.HibernateExample.clauseexamples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class GroupByClause {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT SUM(E.salary), E.firstName FROM Employee E GROUP BY E.firstName");
            List employees = query.list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Object employee = iterator.next();
                System.out.print("First Name: " + employee);
            }
            tx.commit();
        }
        catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
