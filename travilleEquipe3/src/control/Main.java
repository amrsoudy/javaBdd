package control;

import Dao.util;
import entite.Detaillivraison;
import entite.DetaillivraisonId;
import entite.Livraison;
import static java.lang.reflect.Array.set;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1795162
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Livraison livraison = new Livraison(new BigDecimal(2685), dt.parse("2017-05-05"));
        
        util.insert(livraison);
        livraison.setDatelivraison(dt.parse("2018-06-06"));
        util.update(livraison);

        DetaillivraisonId id = new DetaillivraisonId(new BigDecimal(240), new BigDecimal(8), new BigDecimal(10));//(BigDecimal nolivraison, BigDecimal nocommande, BigDecimal noarticle)
        Detaillivraison dl = new Detaillivraison(id, livraison, new BigDecimal(1000));  //(DetaillivraisonId id, Livraison livraison, BigDecimal quantitelivree)
       
        DetaillivraisonId id2 = new DetaillivraisonId(new BigDecimal(244), new BigDecimal(4), new BigDecimal(20));//(BigDecimal nolivraison, BigDecimal nocommande, BigDecimal noarticle)
        Detaillivraison dl2 = new Detaillivraison(id, livraison, new BigDecimal(1000));

        Set Detaillivraisons = new HashSet();
        Detaillivraisons.add(dl);
        Detaillivraisons.add(dl2);

        livraison.setDetaillivraisons(Detaillivraisons);
        
        util.update(livraison);
        

        util.delete(livraison);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query q = session.createQuery("from Livraison");
        List<Livraison> list = q.list();

        for (Livraison l : list) {
            System.out.println(l.getNolivraison() + "    " + l.getDatelivraison());

        }
        System.out.println("*********************************************************************************************");
        
        Query q2 = session.createQuery("select l.nolivraison, l.datelivraison, sum(d.quantitelivree) from Livraison l, Detaillivraison d where l.nolivraison=d.id.nolivraison "
                + "group by l.nolivraison,l.datelivraison");
        List<Object[]> results =  q2.list();
        
        for(Object[] line : results){
            System.out.println("NoArticle       "+line[0]+"  datelivraison   "+line[1]+"   quantitelivree"+line[2]);
        
        }

        session.getTransaction().commit();
        if (!session.isConnected()) {
            session.close();
        }
        if (!sessionFactory.isClosed()) {
            sessionFactory.close();
        }

    }

}
