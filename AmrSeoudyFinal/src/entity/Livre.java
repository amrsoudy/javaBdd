package entity;
// Generated 2018-06-06 08:39:38 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Livre generated by hbm2java
 */
public class Livre  implements java.io.Serializable {


     private BigDecimal idLivre;
     private Editeur editeur;
     private String categorieLivre;
     private String titreLivre;
     private BigDecimal anneeParution;
     private BigDecimal nbrpages;
     private BigDecimal nbrauteurs;

    public Livre() {
    }

	
    public Livre(BigDecimal idLivre, String categorieLivre, String titreLivre, BigDecimal anneeParution) {
        this.idLivre = idLivre;
        this.categorieLivre = categorieLivre;
        this.titreLivre = titreLivre;
        this.anneeParution = anneeParution;
    }
    public Livre(BigDecimal idLivre, Editeur editeur, String categorieLivre, String titreLivre, BigDecimal anneeParution, BigDecimal nbrpages, BigDecimal nbrauteurs) {
       this.idLivre = idLivre;
       this.editeur = editeur;
       this.categorieLivre = categorieLivre;
       this.titreLivre = titreLivre;
       this.anneeParution = anneeParution;
       this.nbrpages = nbrpages;
       this.nbrauteurs = nbrauteurs;
    }
   
    public BigDecimal getIdLivre() {
        return this.idLivre;
    }
    
    public void setIdLivre(BigDecimal idLivre) {
        this.idLivre = idLivre;
    }
    public Editeur getEditeur() {
        return this.editeur;
    }
    
    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }
    public String getCategorieLivre() {
        return this.categorieLivre;
    }
    
    public void setCategorieLivre(String categorieLivre) {
        this.categorieLivre = categorieLivre;
    }
    public String getTitreLivre() {
        return this.titreLivre;
    }
    
    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }
    public BigDecimal getAnneeParution() {
        return this.anneeParution;
    }
    
    public void setAnneeParution(BigDecimal anneeParution) {
        this.anneeParution = anneeParution;
    }
    public BigDecimal getNbrpages() {
        return this.nbrpages;
    }
    
    public void setNbrpages(BigDecimal nbrpages) {
        this.nbrpages = nbrpages;
    }
    public BigDecimal getNbrauteurs() {
        return this.nbrauteurs;
    }
    
    public void setNbrauteurs(BigDecimal nbrauteurs) {
        this.nbrauteurs = nbrauteurs;
    }




}


