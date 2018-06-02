/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import control.HibernateUtil;
import entity.Vendeur;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class DAO_Vendeur {
     public static void insert(Vendeur v) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(v);

        tx.commit();
        session.close();
        System.out.println("Vendeur insere");

    }

    public static void delete(Vendeur v) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(v);

        tx.commit();
        session.close();
        System.out.println("Vendeur deleted ");

    }
     public static void update(Vendeur v) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.update(v);

        tx.commit();
        session.close();
        System.out.println("Vendeur updated ");

    }

    public static void afficher() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        // Transaction tx = session.getTransaction();
        session.beginTransaction();

        Query q = session.createQuery("from Vendeur");

        List<Vendeur> list = q.list();

        for (Vendeur  v : list) {

            System.out.println(v.getNumvendeur()+"-"+v.getNom()+"-"+v.getPrenom()+"-"+v.getVille()+"-"+v.getNumsuccursale()+"-"+v.getType()+"-"+v.getSalairefixe());

        }

        // tx.commit();
        session.close();

    }
    
    
    
}
