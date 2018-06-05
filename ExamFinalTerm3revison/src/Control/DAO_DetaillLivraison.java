/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Main.sessionFactory;
import entity.Detaillivraison;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class DAO_DetaillLivraison {

    static Session session = null;

    static void insert(Detaillivraison detaillivraison) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();

            session.save(detaillivraison);

            tx.commit();
            session.close();
            System.out.println("Detaill Livraison inserted ");

        } catch (Exception e) {

            System.out.println("problem avec le insertiation de detaille Livraison ");
        }

    }

    static void update(Detaillivraison detaillivraison) {
      
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();

            session.update(detaillivraison);

            tx.commit();
            session.close();

            System.out.println("Detaill Livraison updated ");
       

    }

    static void delete(Detaillivraison detaillivraison) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();

            session.delete(detaillivraison);

            tx.commit();
            session.close();
            System.out.println("Detaill Livraison deleted ");

        } catch (Exception e) {

            System.out.println("problem avec le delete de detaille Livraison ");
        }

    }
    
    public static void afficher() {

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Detaillivraison");
        
        List<Detaillivraison> list  = q.list();
        
        
        for (Detaillivraison l : list ){
            System.out.println(l.getId().getNolivraison()+"--"+l.getId().getNocommande()+"----"+l.getId().getNoarticle()+"---"+l.getQuantitylivree());
        
        }


        session.close();


    }

}
