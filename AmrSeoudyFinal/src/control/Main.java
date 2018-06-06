package control;

import Querys.Query1;
import Querys.Query2;
import Querys.Query3;
import entity.Editeur;
import entity.Livre;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
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
    static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

//Partie de Editeur insertion et  update  editeur 1  et editeur 2
        Editeur editeur1 = new Editeur(new BigDecimal(3), "joody", "Mondial", "France");
        DAO_Editeur.insert(editeur1);
        editeur1.setNomEditeur("Adel");
        DAO_Editeur.update(editeur1);

        Editeur editeur2 = new Editeur(new BigDecimal(4), "Ahmed", "Local", "USA");
        DAO_Editeur.insert(editeur2);
        editeur2.setNomEditeur("abdoo");
        DAO_Editeur.update(editeur2);
        
// afichage tout les  Editeur 
        DAO_Editeur.afficher();

//partie de livre    insertion et update  livre1  et livre 2
        Livre livre1 = new Livre(new BigDecimal(10), "Roman", "new Life", new BigDecimal(2015));
        DAO_Livre.insert(livre1);
        livre1.setAnneeParution(new BigDecimal(2020));
        livre1.setNbrpages(new BigDecimal(1000));
        livre1.setNbrauteurs(new BigDecimal(1));
        livre1.setEditeur(editeur1);
        DAO_Livre.update(livre1);

        Livre livre2 = new Livre(new BigDecimal(20), "Fable", "easy Going", new BigDecimal(2010));
        DAO_Livre.insert(livre2);
        livre2.setAnneeParution(new BigDecimal(1980));
        livre2.setNbrpages(new BigDecimal(900));
        livre2.setNbrauteurs(new BigDecimal(1));
        livre2.setEditeur(editeur2);
        DAO_Livre.update(livre2);
        
 //Afichade tout le livres 
         DAO_Livre.afficher();

//Affichage Question  c Query 1 et 2 et 3 
       

        Query1.afficherLeNBDeLivreParCategorie();
        Query2.afficherNBLivreParTypeDeEditeur();
        Query3.afficherMoyenDePagesParNomEditeur();

// suppression tout dans le tables 

        DAO_Livre.delete(livre1);
        DAO_Livre.delete(livre2);
        DAO_Editeur.delete(editeur1);
        DAO_Editeur.delete(editeur2);
        
        
        
        if (!sessionFactory.isClosed()) {

            sessionFactory.close();
        }

    }

}
