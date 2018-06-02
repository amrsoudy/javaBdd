/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import control.HibernateUtil;
import entity.Projet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class DAO_PROJECT {
    
        public static void insert(Projet p) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(p);

        tx.commit();
        session.close();
        System.out.println("project insere");

    }

    public static void delete(Projet p) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(p);

        tx.commit();
        session.close();
        System.out.println("project deleted ");

    }
     public static void update(Projet p) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.update(p);

        tx.commit();
        session.close();
        System.out.println("Project updated ");

    }

    public static void afficher() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transaction tx = session.getTransaction();
        session.beginTransaction();

        Query q = session.createQuery("from Project");

        List<Projet> list = q.list();

        for (Projet  p : list) {

            System.out.println(p.getNumprojet()+"-"+p.getNumsuccursale()+"-"+p.getBudjet()+"-"+p.getTitre());

        }

        // tx.commit();
        session.close();

    }
    
    
}
