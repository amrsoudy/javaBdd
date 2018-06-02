/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import entity.Detaillivraison;
import entity.DetaillivraisonId;
import entity.Livraison;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;

/**
 *
 * @author AMR
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    static SessionFactory sessionFactory = null;

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Livraison liv1 = new Livraison(1, sdf.parse("2017-05-09"));
        // Control.DAO_Livraison.insert(liv1);

        liv1.setDatelivraison(sdf.parse("2018-12-01"));
        // Control.DAO_Livraison.update(liv1);

        DetaillivraisonId id1 = new DetaillivraisonId(101, 1, 10);

        Detaillivraison detaillivraison = new Detaillivraison(id1, 1000);

        // Control.DAO_DetaillLivraison.insert(detaillivraison);
        System.out.println(id1.getNoarticle());
        detaillivraison.getId().setNoarticle(20);

        System.out.println(id1.getNoarticle() + "--" + id1.getNocommande() + "--" + id1.getNolivraison());
        DetaillivraisonId id2 = new DetaillivraisonId(106, 5, 600);
        detaillivraison.setId(id2);
        DAO_DetaillLivraison.insert(detaillivraison);
        id2.setNoarticle(50);
        detaillivraison.setId(id2);

        DAO_DetaillLivraison.update(detaillivraison);
        
        
        
        
        
        
        
        
        
        
        
        
        

        DetaillivraisonId id3 = new DetaillivraisonId(101, 1, 10);

        Detaillivraison detaillivraison3 = new Detaillivraison(id3, 1000);

        DAO_DetaillLivraison.insert(detaillivraison3);
// jusque ici  correct  

//Apres Ca  marche  pas 
        id3.setNoarticle(500);

        detaillivraison3.setId(id3);
        DAO_DetaillLivraison.update(detaillivraison3);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        DAO_DetaillLivraison.update(detaillivraison3);

        // DAO_DetaillLivraison.delete(detaillivraison);
        //DAO_Livraison.delete(liv1);
        if (!sessionFactory.isClosed()) {

            sessionFactory.close();
        }
    }

}
