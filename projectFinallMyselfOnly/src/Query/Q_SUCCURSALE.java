/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import control.HibernateUtil;
import entity.Succursale;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author AMR
 */
public class Q_SUCCURSALE {
    
    public static void select(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String q = "select numvendeur,nom from Vendeur where numvendeur   not in (select id.numvendeur from Vente ) ";
       
        Query query = session.createQuery(q);
        List<Object[]> list = query.list();
        
        for(Object[] o : list ){
            System.out.println(o[0]+"----"+o[1]);
        
        }
        
        
        
//        Criteria cr = session.createCriteria(Succursale.class);
//        cr.add(Restrictions.eq("numsuccursale", 4));
//        
//        
//        
//        
//        List  list = cr.list();
//        
//        for(Iterator it = list.iterator();it.hasNext();){
//            Succursale s = (Succursale)it.next();
//            
//            System.out.println(s.getNumsuccursale()+"----"+s.getSurface());
//        
//        }
        
        
        session.close();
    
    
    
    }
    
    
}
