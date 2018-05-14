package aptCtr;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import vue.fen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Utils.Util util = new Utils.Util();
        
       
   
                fen fen1 =new fen(util);
                fen1.setVisible(true);
                fen1.setLocationRelativeTo(null);
                fen1.setDefaultCloseOperation(0);
                fen1.setSize(900, 500);
                fen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
       
    }
        

    }



    

