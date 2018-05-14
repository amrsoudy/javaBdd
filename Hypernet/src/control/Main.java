/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entite.Countries;
import entite.Regions;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 1795162
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        
//        Regions myRegion = new Regions(new BigDecimal(23232323));
//        Regions myRegion2 = new Regions(new BigDecimal(6000000));
//
//        myRegion.setRegionName("Amr");
//        Countries country = new Countries("hp",myRegion2,"AmrC");
//        country.setCountryName("AmrCountry");
//       country.setRegions(myRegion2);
//        country.setCountryName("omDarmanaaa");
//       
//       Countries country = new Countries("XZ");
//        
//       session.update(country);
//
//       session.save(country);
//      

        ///////////////////////////////////////////////////////
        Query query = session.createQuery("from Regions");
        List<Regions> result = query.list();
        for (Regions r : result) {

            System.out.println(r.getRegionId() + " " + r.getRegionName() + " " + r.getCountrieses());
            

        }
        // Query query2 = session.createQuery("from Countries");
        Query query2 = session.createQuery("from Countries ");
        List<Countries> result2 = query2.list();

        for (Countries c : result2) {
            System.out.println(c.getCountryId() + "  " + c.getCountryName() + " " + c.getRegions());
            Regions myregion = c.getRegions();
           

        }

        //session.getTransaction().commit();
        session.close();

    }

}
