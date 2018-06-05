/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class updateDetailLivraisonparNO {
    
    public static void updateparno (int no){
    
    SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
    Session session = sessionfactory.openSession();
    Transaction tx = session.getTransaction();
    session.beginTransaction();
    
    Query q = session.createQuery("update Detaillivraison set DetaillivraisonId.noarticle = "+no+" where "
            + "DetaillivraisonId.nolivraison = 1");
    
    int res = q.executeUpdate();
    
        System.out.println("les  ligne updated  est "+res);
    
    tx.commit();
    session.close();
   
    
    }
}
