/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import control.HibernateUtil;
import entite.Detaillivraison;
import entite.Livraison;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 1795162
 */
public class util {

    static Session session = null;

    public static void insert(Livraison li) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(li);
        tx.commit();
        session.close();

    }

    public static void update(Livraison li) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       
        session.update(li);
        tx.commit();
        session.close();

    }
 

    public static void delete(Livraison li) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(li);
        tx.commit();
        session.close();

    }

 

    

   

}
