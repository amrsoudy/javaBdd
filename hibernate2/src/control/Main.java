package control;

import entites.Departments;
import entites.Employees;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        

       // Query query = session.createQuery("from Employees where Employee_id = ?");
        
       // query.setParameter(0, 150);
       // List<Employees> result = query.list();
       
       Criteria criteria = session.createCriteria(Employees.class);
       criteria.add(Restrictions.like("firstName","S%"));
         criteria.add(Restrictions.gt("salary", new BigDecimal(6000)));
      criteria.add(Restrictions.lt("salary", new BigDecimal(10000)));
       List list = criteria.list();
       
      for (Iterator iterator = list.iterator(); iterator.hasNext();){
            Employees employee = (Employees) iterator.next(); 
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print("  Last Name: " + employee.getLastName()); 
            System.out.println("  Salary: " + employee.getSalary()); 
         }
        
//        for (Employees e : list) {
//          //  if (e.getEmployeeId() == 150){
//            if(e.getDepartments()!=null){
//                System.out.println(e.getEmployeeId() + " " + e.getFirstName() + " " + e.getDepartments().getDepartmentName());
//            }else {
//             System.out.println(e.getEmployeeId() + " " + e.getFirstName() + " " + null);
//            
//            }
//          }
//            if(e.getDepartments()!=null){
//                Query query2 = session.createQuery("from Departments");
//                List<Departments> list2 = query.list();
//                for(Departments d :list2){
//                
//                if (e.getDepartments().equals(d.getDepartmentId())){
//                    
//                    System.out.print(d.getDepartmentName());
//                
//                
//                }
                //}
                
                
        
         //   }
     //   }

        session.close();

    }

}
