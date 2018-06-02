package Control;

import static Control.Main.sessionFactory;
import entity.Livraison;
import java.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AMR
 */
public class DAO_Livraison {

    static Session session = null;

    public static void insert(Livraison liv1) {

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();

            session.save(liv1);

            tx.commit();
            session.close();
            System.out.println("inserted  Livraison");
        } catch (Exception e) {

            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static void update(Livraison liv1) {

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        session.update(liv1);

        tx.commit();
        session.close();

        System.out.println("updated livraison");

    }

    public static void delete(Livraison liv1) {

        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        session.delete(liv1);

        tx.commit();
        session.close();
        System.out.println("deleted livrison ");
    }

}
