package control;

import entity.Piece;
import entity.Projet;
import entity.Succursale;
import entity.Vendeur;
import entity.Vente;
import entity.VenteId;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    public static void main(String[] args) throws ParseException {
        //    public Succursale(int numsuccursale, String designation, String ville, Double surface, String capitale) {

        Succursale s1 = new Succursale(1, "normal", "montreal", 1000.55, "Mont");
        Succursale s2 = new Succursale(2, "general", "montreal", 2000.55, "Mont");
        Succursale s3 = new Succursale(3, "normal", "montreal", 3000.55, "Mont");
        Succursale s4 = new Succursale(4, "normal", "montreal", 4000.55, "Mont");

        DAO.DAO_SUCCURSALE.insert(s1);
        DAO.DAO_SUCCURSALE.insert(s2);
        DAO.DAO_SUCCURSALE.insert(s3);
        DAO.DAO_SUCCURSALE.insert(s4);

        s1.setDesignation("general");
        s1.setVille("laval");

        DAO.DAO_SUCCURSALE.update(s1);
        //DAO.DAO_SUCCURSALE.afficher();
////----------------------------------------------------------
////(int numprojet, String titre, Integer numsuccursale, Double budjet
//
        Projet p1 = new Projet(1, "nasa", 1, 100000.55);
//
        DAO.DAO_PROJECT.insert(p1);

        p1.setBudjet(200000.55);

        //DAO.DAO_PROJECT.afficher();
////----------------------------------------------------------
////    public Piece(int numpiece, String designation, Double poids, String couleur, String description, Integer numsuccursale, Double prixunitaire, Integer quantitestock, Integer seuilstock) {

        Piece pi1 = new Piece(1, "normal", 500.55, "Red", "piece of machines ", 1, 10.9, 1000, 50);

        DAO.DAO_Piece.insert(pi1);

        pi1.setCouleur("Green");
        DAO.DAO_Piece.update(pi1);
////--------------------------------------------------------
//
        Vendeur v1 = new Vendeur(101, "Amr", "Seoudy", "permanent", "montreal", 1, 5000.55, 10.5);
        DAO.DAO_Vendeur.insert(v1);
       
       v1.setSalairefixe(6000.66);
        DAO.DAO_Vendeur.update(v1);

//--------------------------------------------------------------
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        VenteId id1 = new VenteId(101,1,1);
        Vente vi1 = new Vente(id1, 600, sdf.parse("2017-05-09"));
        
        DAO.DAO_Vente.insert(vi1);
        vi1.setQuantite(4000);
        
        Query.Q_SUCCURSALE.select();
        Query.Q_PIECES.select();
        
        
//        DAO.DAO_Vente.delete(vi1);
//        DAO.DAO_Vendeur.delete(v1);
//        DAO.DAO_Piece.delete(pi1);
//        DAO.DAO_PROJECT.delete(p1);
//        DAO.DAO_SUCCURSALE.delete(s1);
//        DAO.DAO_SUCCURSALE.delete(s2);
//        DAO.DAO_SUCCURSALE.delete(s3);
//        DAO.DAO_SUCCURSALE.delete(s4);
        
    }
    
}
