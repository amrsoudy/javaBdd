/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import control.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AMR
 */
public class Q_PIECES {
    
    
    public static void select(){
    
    Session session =HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    String q= "select numpiece,designation from Piece";
    Query query=session.createQuery(q);
    List <Object[]> list = query.list();
    
    for(Object[] o : list){
        System.out.println(o[0]+"------"+o[1]);
    
    }
    
    
    
    session.close();
    }
    
}
