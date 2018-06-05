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
        Control.DAO_Livraison.insert(liv1);
        
        Livraison liv2 = new Livraison(2, sdf.parse("2019-05-09"));
        Control.DAO_Livraison.insert(liv2);
        
        liv1.setDatelivraison(sdf.parse("2018-12-01"));
        Control.DAO_Livraison.update(liv1);
        
        DetaillivraisonId id1 = new DetaillivraisonId(1, 1, 10);
        
        Detaillivraison detaillivraison = new Detaillivraison(id1, 1000);
        
        Control.DAO_DetaillLivraison.insert(detaillivraison);

        // id1.setNoarticle(50);
        DetaillivraisonId id2 = new DetaillivraisonId(1, 1, 50);
        Detaillivraison detaillivraison2 = new Detaillivraison(id2, 5000);

        // System.out.println(id1.getNoarticle());
        System.out.println("erorrrrrrrrrrrrrrrrrrrrrrrrrrr*************************");

        //detaillivraison.setId(id2);
        DAO_DetaillLivraison.insert(detaillivraison2);

//        DAO.ListLivraison.afficher();
//        DAO.ListDetailLivraison.afficher();
//        DAO.listLivrParNo.afficherparNo(2);
        DAO.updateDetailLivraisonparNO.updateparno(200);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

//        DetaillivraisonId id2 = new DetaillivraisonId(106, 2, 600);
//        Detaillivraison detaillivraison2 = new Detaillivraison(id2,6000);
//        DAO_DetaillLivraison.insert(detaillivraison2);
//
//        //detaillivraison2.setId(id2);
//        detaillivraison2.setQuantitylivree(6000);
//
//        //DAO_DetaillLivraison.insert(detaillivraison);
//        DAO_DetaillLivraison.update(detaillivraison2);
//        
//        
//        DAO_Livraison.afficher();
//        System.out.println("************************************************************************");
//        DAO_DetaillLivraison.afficher();
//        DetaillivraisonId id3 = new DetaillivraisonId(101, 1, 10);
//
//        Detaillivraison detaillivraison3 = new Detaillivraison(id3, 1000);
//
//        DAO_DetaillLivraison.insert(detaillivraison3);
//// jusque ici  correct  
//
////Apres Ca  marche  pas 
//        id3.setNoarticle(500);
//
//        detaillivraison3.setId(id3);
//        DAO_DetaillLivraison.update(detaillivraison3);
        // DAO_DetaillLivraison.delete(detaillivraison);
        //DAO_Livraison.delete(liv1);
        if (!sessionFactory.isClosed()) {
            
            sessionFactory.close();
        }
    }
    
}
