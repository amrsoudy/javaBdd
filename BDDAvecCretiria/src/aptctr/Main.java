package aptctr;

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
        
        Customer customer = new Customer();
        
        util.insert(customer);
        
        util.update(customer);
        
        util.delete(customer);
        
        
    }
    
}
