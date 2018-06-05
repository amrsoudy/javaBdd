/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.HibernateUtil;
import entity.Livraison;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class ListLivraison {

    public static void afficher() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();

        session.beginTransaction();

        Query query = session.createQuery("from Livraison");
        List<Livraison> list = query.list();

        for (Livraison l : list) {

            System.out.println(l.getNolivraison() + "---" + l.getDatelivraison());

        }

        tx.commit();
        session.close();

    }

}
