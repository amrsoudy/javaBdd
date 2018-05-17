package control;

import entites.Departments;
import entites.Employees;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        

        Query query = session.createQuery("select r.regionId,r.regionName ,count(*) from countries c inner join c.region r group by r.regionId,r.regionName");
        List <Object []> results =query.list();
        for(Object[] line :results){
        
            System.out.println("le nom de la region : "+line[1]+" - "+line[0]+" - "+line[2]);
        
        }
        
       // query.setParameter(0, "S%");
      //  List<Employees> result = query.list();
//       
//       Criteria criteria = session.createCriteria(Employees.class);
//       criteria.add(Restrictions.like("firstName","S%"));
//         criteria.add(Restrictions.gt("salary", new BigDecimal(6000)));
//      criteria.add(Restrictions.lt("salary", new BigDecimal(10000)));
//       List list = criteria.list();
//       
//      for (Iterator iterator = list.iterator(); iterator.hasNext();){
//            Employees employee = (Employees) iterator.next(); 
//            System.out.print("First Name: " + employee.getFirstName() ); 
//            System.out.print("  Last Name: " + employee.getLastName()); 
//            System.out.print("  Salary:  " + employee.getSalary() ); 
//          System.out.println("   Dept_name    "+employee.getDepartments().getDepartmentName());
//         }
//      
      
      
        
//        for (Employees e : result) {
//           
//            if(e.getDepartments()!=null){
//                System.out.println(e.getEmployeeId() + " " + e.getFirstName() + " " + e.getDepartments().getDepartmentName());
//            }else {
//             System.out.println(e.getEmployeeId() + " " + e.getFirstName() + " " + null);
//            
//            }
          
           
        
       // }
        if (!session.isConnected()){
        session.close();
        }
        if (!sessionFactory.isClosed()){
        sessionFactory.close();
        }
    }

}
