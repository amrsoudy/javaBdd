/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.Main.sessionFactory;
import entity.Editeur;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 1795162
 */
public class DAO_Editeur {

    static Session session = null;

    public static void insert(Editeur e) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(e);

            session.getTransaction().commit();
            session.close();
            
            System.out.println("Editeur inserté");

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }

    }
        
      public static void update(Editeur e) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(e);

            session.getTransaction().commit();
            session.close();
            
            System.out.println("Editeur updated");

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }

    }
    
      public static void delete(Editeur e) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(e);

            session.getTransaction().commit();
            session.close();
            
            System.out.println("Editeur supermé");

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }

    }
      
      
      
         public static void afficher() {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
           //session.beginTransaction();

           Query query = session.createQuery("from Editeur");
           List<Editeur> list =  query.list();
           
           
           for(Editeur ed :list){
           
               System.out.println(ed.getIdEditeur()+ "  -  "+ed.getNomEditeur()+"   - "+ed.getTypeEditeur()+"   - "+ ed.getPaysEditeur() );
           
           }
           
           

           // session.getTransaction().commit();
            session.close();
            
        

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }

    }

}
