/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Querys;

import control.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 1795162
 */
public class Query1 {

    public static void afficherLeNBDeLivreParCategorie() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("select categorieLivre ,count(idLivre) from  Livre group by categorieLivre ");
            List<Object[]> list = query.list();

            for (Object[] o : list) {

                System.out.println("Pour Category :  " + o[0] + "  il ya   " + o[1] + "  Livre  ");

            }

            session.close();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }

    }

}
