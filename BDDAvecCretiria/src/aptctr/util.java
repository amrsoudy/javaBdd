/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptctr;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import persistance.Customer;
import persistance.PurchaseOrder;

/**
 *
 * @author 1795162
 */
class util {

    static void insert(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(customer);

        tx.commit();
        session.close();

    }

    static void delete(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(customer);

        tx.commit();
        session.close();

    }

    static void update(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(customer);

        tx.commit();
        session.close();

    }

    static void listCustomer_idCGT(int number) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = session.createCriteria(Customer.class);
        cr.add(Restrictions.gt("customerId", number));
        List customers = cr.list();

        for (Iterator iterator = customers.iterator(); iterator.hasNext();) {

            Customer customer = (Customer) iterator.next();

            System.out.println("Name is   " + customer.getName() + " Customer_id  = " + customer.getCustomerId());


        }
    }

    static void listCustomerNamesStartWith(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = session.createCriteria(Customer.class);
        
        //ilike   not case sensitive   but like is case sestive 
        
        cr.add(Restrictions.ilike("name", name + "%"));
        List customers = cr.list();

        for (Iterator it = customers.iterator(); it.hasNext();) {

            Customer customer = (Customer) it.next();

            System.out.println("Name is   " + customer.getName());
            

        }

    }

    static void ListPOForCustomer_id(int i) {
            Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = session.createCriteria(PurchaseOrder.class);
        
        //ilike   not case sensitive   but like is case sestive 
        
        cr.add(Restrictions.eq("customerId", i));
        cr.addOrder(Order.asc("quantity"));
        
        List pos = cr.list();

        for (Iterator it = pos.iterator(); it.hasNext();) {

            PurchaseOrder po = (PurchaseOrder) it.next();

            System.out.println(po.getCustomerId()+"-"+po.getQuantity());
    }

}

    static void selectQuery(String x,int num) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        
        
        Query q = session.createQuery(x);
        
        // si on metter  Question mark on va metter le number de cette question mark pas le num de attribute  mais si on metter  name comme <
        // where customerId = :customerId   on va metter q.setparameter("customerId",36);
        
       q.setParameter("x",num);
        List<Customer> customers = q.list();
        
        
        for (Customer c :customers){
            
            System.out.println("name is "+c.getName()+"customer id "+c.getCustomerId());
        
        
        }
        
        
        
        tx.commit();
        session.close();
        
    }

    static void selectPoWithCustomer(String x2) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction tx  =  session.getTransaction();
        session.beginTransaction();
        
        Query q = session.createQuery(x2);
        List<Object[]> list = q.list();
        
        for (Object[] o : list){
        
            System.out.println(o[0]+" ---"+o[1]+"-----"+o[2]+"----"+o[3]+"----"+o[4]+"----"+o[5]+"----"+o[6]);
        }
        
        
        
        
        
        tx.commit();
        session.close();
        
        
        
    }

    static void listPoWithproductId(int i) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(PurchaseOrder.class);
        
        cr.add(Restrictions.eq("productId", i));
        
        List pos = cr.list();
        
        for(Iterator iterator = pos.iterator();iterator.hasNext();){
            
            PurchaseOrder po = (PurchaseOrder)iterator.next();
            
            System.out.println(po.getCustomerId()+" "+po.getProductId()+"  "+po.getQuantity());
        
        
        
        }
        
        session.close();
        
    }
}
