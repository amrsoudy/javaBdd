/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.Main.sessionFactory;
import entity.Livre;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 1795162
 */
public class DAO_Livre {

    static Session session = null;

    public static void insert(Livre l) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(l);

            session.getTransaction().commit();
            session.close();

            System.out.println("Livre inserté");

        } catch (Exception ex) {
            System.out.println("problem avec insertation ");

        }

    }

    public static void update(Livre l) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(l);

            session.getTransaction().commit();
            session.close();

            System.out.println("Livre updated");

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }

    }

    public static void delete(Livre l) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(l);

            session.getTransaction().commit();
            session.close();

            System.out.println("Livre supermé");

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());

        }

    }

    public static void afficher() {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            Query query = session.createQuery("from Livre");
            List<Livre> list = query.list();

            for (Livre li : list) {

                System.out.println(li.getIdLivre() + "   -  " + li.getCategorieLivre() + " -  " + li.getTitreLivre() + "  - "
                        + li.getAnneeParution() + "  - " + li.getNbrpages() + "  - " +
                        li.getNbrauteurs()+"   -  "+li.getEditeur().getIdEditeur()+" - "+li.getEditeur().getNomEditeur());

            }

            session.close();

        } catch (Exception ex) {
            System.out.println("problem avec Affichage le  Livres");

        }

    }

}
