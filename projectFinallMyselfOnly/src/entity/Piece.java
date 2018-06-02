package entity;
// Generated 2018-05-28 19:53:34 by Hibernate Tools 4.3.1



/**
 * Piece generated by hbm2java
 */
public class Piece  implements java.io.Serializable {


     private int numpiece;
     private String designation;
     private Double poids;
     private String couleur;
     private String description;
     private Integer numsuccursale;
     private Double prixunitaire;
     private Integer quantitestock;
     private Integer seuilstock;

    public Piece() {
    }

	
    public Piece(int numpiece, String couleur, String description) {
        this.numpiece = numpiece;
        this.couleur = couleur;
        this.description = description;
    }
    public Piece(int numpiece, String designation, Double poids, String couleur, String description, Integer numsuccursale, Double prixunitaire, Integer quantitestock, Integer seuilstock) {
       this.numpiece = numpiece;
       this.designation = designation;
       this.poids = poids;
       this.couleur = couleur;
       this.description = description;
       this.numsuccursale = numsuccursale;
       this.prixunitaire = prixunitaire;
       this.quantitestock = quantitestock;
       this.seuilstock = seuilstock;
    }
   
    public int getNumpiece() {
        return this.numpiece;
    }
    
    public void setNumpiece(int numpiece) {
        this.numpiece = numpiece;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Double getPoids() {
        return this.poids;
    }
    
    public void setPoids(Double poids) {
        this.poids = poids;
    }
    public String getCouleur() {
        return this.couleur;
    }
    
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getNumsuccursale() {
        return this.numsuccursale;
    }
    
    public void setNumsuccursale(Integer numsuccursale) {
        this.numsuccursale = numsuccursale;
    }
    public Double getPrixunitaire() {
        return this.prixunitaire;
    }
    
    public void setPrixunitaire(Double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }
    public Integer getQuantitestock() {
        return this.quantitestock;
    }
    
    public void setQuantitestock(Integer quantitestock) {
        this.quantitestock = quantitestock;
    }
    public Integer getSeuilstock() {
        return this.seuilstock;
    }
    
    public void setSeuilstock(Integer seuilstock) {
        this.seuilstock = seuilstock;
    }




}


