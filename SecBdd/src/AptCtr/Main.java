package AptCtr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection con = null;
        Statement stm = null;

        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "oop", "ooppw");
        stm = con.createStatement();
        String sql = null;
        sql = "select * from article where prixunitaire >= 4";
        ResultSet rs2 = stm.executeQuery(sql);

        int noarticle;
        String desc;
        double prix;
        int qs;

        while (rs2.next()) {

            noarticle = rs2.getInt("noarticle");
            desc = rs2.getString("DESCRIPTION");
            prix = rs2.getDouble("PRIXUNITAIRE");
            qs = rs2.getInt("QUANTITEENSTOCK");

            System.out.print(noarticle + "   ");
            System.out.print(desc + "    ");
            System.out.print(prix + "   ");
            System.out.print(qs);
            System.out.println("");

        }

        rs2.close();
        stm.close();
        con.close();

        // sql = "insert into client values(5,'amr','5144582728)";
        //int number = stm.executeUpdate(sql);
        //System.out.println("the changes 1 : " + number);
    }

}
