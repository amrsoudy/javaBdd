/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import control.HibernateUtil;
import entity.Piece;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class DAO_Piece {
    
          public static void insert(Piece pi) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(pi);

        tx.commit();
        session.close();
        System.out.println("piece insere");

    }

    public static void delete(Piece pi) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(pi);

        tx.commit();
        session.close();
        System.out.println("piece deleted ");

    }
     public static void update(Piece pi) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.update(pi);

        tx.commit();
        session.close();
        System.out.println("Piece updated ");

    }

    public static void afficher() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transaction tx = session.getTransaction();
        session.beginTransaction();

        Query q = session.createQuery("from Piece");

        List<Piece> list = q.list();

        for (Piece  pi : list) {

            System.out.println(pi.getNumpiece()+"-"+pi.getNumpiece()+"-"+pi.getDesignation()+"-"+pi.getCouleur()+"-"+pi.getQuantitestock()+"-"+pi.getPoids()
                    +""+pi.getPrixunitaire()+"-"+pi.getSeuilstock());

        }

        // tx.commit();
        session.close();

    }
    
}
