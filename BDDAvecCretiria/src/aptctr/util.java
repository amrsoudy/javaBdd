/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptctr;

import org.hibernate.Session;
import org.hibernate.Transaction;
import persistance.Customer;

/**
 *
 * @author 1795162
 */
class util {

    static void insert(Customer customer) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(customer);
        
        tx.commit();
        session.close();
        
    }

    static void delete(Customer customer) {
        
           Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        session.delete(customer);
        
        tx.commit();
        session.close();
        
    }

    static void update(Customer customer) {
        
              Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        
        session.update(customer);
        
        tx.commit();
        session.close();
        
    }
    
}
