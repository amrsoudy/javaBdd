/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.HibernateUtil;
import entity.Detaillivraison;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class ListDetailLivraison {

    public static void afficher() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        Query query = session.createQuery("from Detaillivraison");

        List<Detaillivraison> list = query.list();

        for (Detaillivraison l : list) {

            System.out.println(l.getId().getNoarticle() + "--" + l.getId().getNocommande() + "--" + l.getId().getNolivraison() + "--" + l.getQuantitylivree());

        }
tx.commit();
        session.close();

    }

}
