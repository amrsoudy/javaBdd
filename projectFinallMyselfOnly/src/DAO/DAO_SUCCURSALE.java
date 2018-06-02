/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import control.HibernateUtil;
import entity.Succursale;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class DAO_SUCCURSALE {

    public static void insert(Succursale s) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(s);

        tx.commit();
        session.close();
        System.out.println("Succursale insere");

    }

    public static void delete(Succursale s) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(s);

        tx.commit();
        session.close();
        System.out.println("Succursale deleted ");

    }

    public static void update(Succursale s) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.update(s);

        tx.commit();
        session.close();
        System.out.println("Succursale updated ");

    }

    public static void afficher() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transaction tx = session.getTransaction();
        session.beginTransaction();

        Query q = session.createQuery("from Succursale");

        List<Succursale> list = q.list();

        for (Succursale s : list) {

            System.out.println(s.getNumsuccursale() + "-" + s.getDesignation() + "-" + s.getVille() + "-" + s.getSurface() + "-" + s.getCapitale());

        }

        // tx.commit();
        session.close();

    }
}
