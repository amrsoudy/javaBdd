package aptctr;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import persistance.Customer;

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

//        Customer customer = new Customer();
//
//        util.insert(customer);
//         
//
//        util.update(customer);
//        String query = null;
//        String x = "from Customer where customerId = :x";
//        util.selectQuery(x,36);
//        util.selectQuery(x,106);
        String x2 = "select p.orderNum,p.quantity,p.shippingCost,p.shippingDate,p.customerId,c.name,count(*) from PurchaseOrder p ,Customer c where p.customerId=c.customerId "
                + " group by p.orderNum,p.quantity,p.shippingCost,p.shippingDate,p.customerId,c.name";
        util.selectPoWithCustomer(x2);


        //util.listCustomer_idCGT(3);
        //util.listCustomerNamesStartWith("b");
        // util.ListPOForCustomer_id(36);
//
//        util.delete(customer);
    }

}
