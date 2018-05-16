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
import org.hibernate.SessionFactory;

/**
 *
 * @author 1795162
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
           SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        

        Query query = session.createQuery("select r.regionId,r.regionName ,count(*) from countries c inner join c.region r group by r.regionId,r.regionName");
        List <Object []> results =query.list();
        for(Object[] line :results){
        
            System.out.println("le nom de la region : "+line[1]+" - "+line[0]+" - "+line[2]);
        
        }
      //  Session session = NewHibernateUtil.getSessionFactory().openSession();
      //  session.beginTransaction();
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
//        Query query = session.createQuery("from Regions");
//        List<Regions> result = query.list();
//        for (Regions r : result) {
//
//            System.out.println(r.getRegionId() + " " + r.getRegionName() + " " + r.getCountrieses());
//            
//
//        }
//        // Query query2 = session.createQuery("from Countries");
//        Query query2 = session.createQuery("from Countries ");
//        List<Countries> result2 = query2.list();
//
//        for (Countries c : result2) {
//            System.out.println(c.getCountryId() + "  " + c.getCountryName() + " " + c.getRegions());
//            Regions myregion = c.getRegions();
//           
//
//        }
//
//        //session.getTransaction().commit();
//        session.close();

    if (!session.isConnected()){
        session.close();
        }
        if (!sessionFactory.isClosed()){
        sessionFactory.close();
        }

    }

}
