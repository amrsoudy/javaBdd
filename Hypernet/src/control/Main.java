/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entite.Countries;
import entite.Regions;
import java.math.BigDecimal;
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
        Regions myRegion = new Regions(new BigDecimal(23232323));
        myRegion.setRegionName("Amr");
        Countries country = new Countries("hp",myRegion,"AmrC");
        country.setCountryName("AmrCountry");
       // country.setCountryName("omDarmanaaa");
       
      // Countries country = new Countries("XZ");
        
       session.update(country);

     //  session.save(country);
        session.getTransaction().commit();
        session.close();

    }

}
