/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entitie.Article;
import entitie.Client;
import entitie.Commande;
import entitie.Detaillivraison;
import entitie.Lignecommande;
import entitie.Livraison;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class utils {

    static Session session = null;

    public static void insertClient(Client client) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(client);

        tx.commit();
        session.close();
        System.out.println("client Added");

    }

    public static void insertArticle(Article article) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(article);

        tx.commit();
        session.close();
        System.out.println("Article Added");

    }

    public static void insertCommande(Commande commande) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(commande);

        tx.commit();
        session.close();
        System.out.println("Commande Added");

    }

    public static void insertDetailLivrison(Detaillivraison detaillivraison) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(detaillivraison);

        tx.commit();
        session.close();
        System.out.println("Detaillivraison Added");

    }

    public static void insertLignecommande(Lignecommande lignecommande) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(lignecommande);

        tx.commit();
        session.close();
        System.out.println("Lignecommande Added");

    }

    public static void insertLivraison(Livraison livraison) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(livraison);

        tx.commit();
        session.close();
        System.out.println("Livraison Added");

    }

    static void delectClient(Client client) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(client);
        tx.commit();
        session.close();

        System.out.println("Client Deleted ");

    }

    static void deleteCommande(Commande commande) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(commande);
        tx.commit();
        session.close();
        System.out.println("Commande Deleted");

    }

    static void deleteLignecommande(Lignecommande Lignecommande) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(Lignecommande);
        tx.commit();
        session.close();
        System.out.println("Lignecommande1 Deleted");

    }
      static void deleteLivraison(Livraison Livraison) {

        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(Livraison);
        
        tx.commit();
        session.close();
    }

    static void updateClient(Client client) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(client);
        tx.commit();
        session.close();
        System.out.println("Client Updated");

    }

    static void updateCommande(Commande commande) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(commande);
        tx.commit();
        session.close();
        System.out.println("commande Updated");

    }

    static void updateArticle(Article Article) {
          session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(Article);
        tx.commit();
        session.close();
        System.out.println("Article Updated");
    }

  
}
