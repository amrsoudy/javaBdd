/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AMR
 */
public class Util {

    Connection con = null;
    Statement stm = null;
    ResultSet rs;

    public void OpenConnection(String sql) {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "oop", "ooppw");
            stm = con.createStatement();
            JOptionPane.showMessageDialog(null, "connection opend", "information", JOptionPane.INFORMATION_MESSAGE);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void CloseConnection() {

        try {
            //rs.close();
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null, "connection Closed  ", "information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Object[]> SelectConn(String Sql) {
        
        ArrayList <Object []> arr =new ArrayList();
        String mot = SqlParse(Sql);
        if (mot.equals("select")) {

            try {
                rs = stm.executeQuery(Sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                int noColumn = rsmd.getColumnCount();
                System.out.println("number of cloumns est  : " + noColumn);
                 

                while (rs.next()) {
                    Object[] ob = new Object[noColumn];
                    ob[0] = rs.getObject(1);
                    ob[1] = rs.getObject(2);
                    ob[2] = rs.getObject(3);
                    arr.add(ob);

                }
                
                for(Object [] o:arr){
                
                    System.out.println(o[0] +" "+ o[1] +"  "+  o[2]);
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return arr;
    }

    private String SqlParse(String sql) {
        String[] mots = sql.split(" ");

        return mots[0];

    }

}
