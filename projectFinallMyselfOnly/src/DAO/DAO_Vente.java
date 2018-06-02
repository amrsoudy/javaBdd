/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import control.HibernateUtil;
import entity.Vente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class DAO_Vente {
       public static void insert(Vente ve ) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(ve);

        tx.commit();
        session.close();
        System.out.println("Vente insere");

    }

    public static void delete(Vente vi) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(vi);

        tx.commit();
        session.close();
        System.out.println("Vente deleted ");

    }
     public static void update(Vente vi) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.update(vi);

        tx.commit();
        session.close();
        System.out.println("Vente updated ");

    }

    public static void afficher() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transaction tx = session.getTransaction();
        session.beginTransaction();

        Query q = session.createQuery("from Vente");

        List<Vente> list = q.list();

        for (Vente  vi : list) {

            System.out.println(vi.getId()+"-"+vi.getQuantite()+"-"+vi.getDatevente());

        }

        // tx.commit();
        session.close();

    }
    
}
