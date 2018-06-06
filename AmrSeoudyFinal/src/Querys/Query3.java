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
public class Query3 {

    public static void afficherMoyenDePagesParNomEditeur() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("select e.nomEditeur ,avg(l.nbrpages)from  Editeur e ,Livre l where  e.idEditeur = l.editeur.idEditeur  group by e.nomEditeur ");

            List<Object[]> list = query.list();

            for (Object[] o : list) {

                System.out.println("le nom De Editeur  est : " + o[0] + "   Ecrire  le  Moyenne  de pages " + o[1]);

            }

            session.close();
        } catch (Exception ex) {
            System.out.println("Error  avec afficherNBLivreParTypeDeEditeur ");
        }

    }

}
