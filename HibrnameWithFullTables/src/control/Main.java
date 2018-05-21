package control;

import entitie.Article;
import entitie.Client;
import entitie.Commande;
import entitie.DetaillivraisonId;
import entitie.Lignecommande;
import entitie.LignecommandeId;
import entitie.Livraison;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AMR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");

        Client client1 = new Client(new BigDecimal(1919), "Amr", "5555555555");
        utils.insertClient(client1);

        Commande commande1 = new Commande(new BigDecimal(2929), client1, dt.parse("2011-08-09"));
       utils.insertCommande(commande1);

        Commande commande2 = new Commande(new BigDecimal(2828), client1, dt.parse("2015-08-09"));
       utils.insertCommande(commande2);

        Commande commande3 = new Commande(new BigDecimal(2727), client1, dt.parse("2017-08-09"));
        utils.insertCommande(commande3);

        LignecommandeId id1 = new LignecommandeId(new BigDecimal(2929), new BigDecimal(10));
        Article Article1 = new Article(new BigDecimal(10), "Cahier", new BigDecimal(5), new BigDecimal(10));
        Lignecommande Lignecommande1 = new Lignecommande(id1, commande1, Article1, new BigDecimal(5));
        utils.insertLignecommande(Lignecommande1);

        LignecommandeId id2 = new LignecommandeId(new BigDecimal(2929), new BigDecimal(20));
        Article Article2 = new Article(new BigDecimal(20), "Book", new BigDecimal(5), new BigDecimal(10));
        Lignecommande Lignecommande2 = new Lignecommande(id2, commande1, Article2, new BigDecimal(5));
       utils.insertLignecommande(Lignecommande2);

        LignecommandeId id3 = new LignecommandeId(new BigDecimal(2828), new BigDecimal(10));
        Lignecommande Lignecommande3 = new Lignecommande(id3, commande2, Article1, new BigDecimal(2));
       utils.insertLignecommande(Lignecommande3);

        LignecommandeId id4 = new LignecommandeId(new BigDecimal(2727), new BigDecimal(10));
        Lignecommande Lignecommande4 = new Lignecommande(id4, commande3, Article1, new BigDecimal(3));
       utils.insertLignecommande(Lignecommande4);

        LignecommandeId id5 = new LignecommandeId(new BigDecimal(2727), new BigDecimal(20));
        Lignecommande Lignecommande5 = new Lignecommande(id5, commande3, Article2, new BigDecimal(1));
        utils.insertLignecommande(Lignecommande5);

   

        Set commandsHS = new HashSet();
        commandsHS.add(commande1);
        commandsHS.add(commande2);
        commandsHS.add(commande3);
        System.out.println("Add the HS of all commandes that's include  client 1 ");

        Set HSLigneCommandeForCommande1 = new HashSet();
        HSLigneCommandeForCommande1.add(Lignecommande1);
        HSLigneCommandeForCommande1.add(Lignecommande2);
        commande1.setLignecommandes(HSLigneCommandeForCommande1);
        System.out.println("Add the HS of all lignesCommande that's include  commande 1 ");

        Set HSLigneCommandeForCommande2 = new HashSet();
        HSLigneCommandeForCommande2.add(Lignecommande3);
        commande2.setLignecommandes(HSLigneCommandeForCommande2);
        System.out.println("Add the HS of all lignesCommande that's include  commande 2");

        Set HSLigneCommandeForCommande3 = new HashSet();
        HSLigneCommandeForCommande3.add(Lignecommande4);
        HSLigneCommandeForCommande3.add(Lignecommande5);
        commande3.setLignecommandes(HSLigneCommandeForCommande3);
        System.out.println("Add the HS of all lignesCommande that's include  commande 3 ");

        Set HSLigneCommandeForArticle1 = new HashSet();
        HSLigneCommandeForArticle1.add(Lignecommande1);
        HSLigneCommandeForArticle1.add(Lignecommande3);
        HSLigneCommandeForArticle1.add(Lignecommande4);
        Article1.setLignecommandes(HSLigneCommandeForArticle1);
        System.out.println("Add the HS of all lignesCommande that's include  Article 1 ");

        Set HSLigneCommandeForArticle2 = new HashSet();
        HSLigneCommandeForArticle2.add(Lignecommande2);
        HSLigneCommandeForArticle2.add(Lignecommande5);
        Article2.setLignecommandes(HSLigneCommandeForArticle2);
        System.out.println("Add the HS of all lignesCommande that's include  Article 2 ");

        client1.setCommandes(commandsHS);
        
        utils.updateClient(client1);

        utils.updateCommande(commande1);
        utils.updateCommande(commande2);
        utils.updateCommande(commande3);



        utils.deleteLignecommande(Lignecommande1);
        utils.deleteLignecommande(Lignecommande2);
        utils.deleteLignecommande(Lignecommande3);
        utils.deleteLignecommande(Lignecommande4);
        utils.deleteLignecommande(Lignecommande5);
        utils.deleteCommande(commande1);
        utils.deleteCommande(commande2);
        utils.deleteCommande(commande3);
        utils.delectClient(client1);
        System.out.println("**********************************now Creating the part of Livrison and the DetailLivrision and update the ligne commande with HS of the DetaileLivrison");

        Livraison Livraison1 = new Livraison(new BigDecimal(3131), dt.parse("2016-06-19"));
        utils.insertLivraison(Livraison1);

        DetaillivraisonId DetaillivraisonId1 = new DetaillivraisonId();
        
        
        utils.deleteLivraison(Livraison1);

    }

}
