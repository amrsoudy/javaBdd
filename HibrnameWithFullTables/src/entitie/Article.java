package entitie;
// Generated 2018-05-21 10:17:33 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Article generated by hbm2java
 */
public class Article  implements java.io.Serializable {


     private BigDecimal noarticle;
     private String description;
     private BigDecimal prixunitaire;
     private BigDecimal quantiteenstock;
     private Set lignecommandes = new HashSet(0);

    public Article() {
    }

	
    public Article(BigDecimal noarticle,String description, BigDecimal prixunitaire, BigDecimal quantiteenstock) {
        this.noarticle = noarticle;
        this.prixunitaire = prixunitaire;
        this.quantiteenstock = quantiteenstock;
        this.description =description;
    }
    public Article(BigDecimal noarticle, String description, BigDecimal prixunitaire, BigDecimal quantiteenstock, Set lignecommandes) {
       this.noarticle = noarticle;
       this.description = description;
       this.prixunitaire = prixunitaire;
       this.quantiteenstock = quantiteenstock;
       this.lignecommandes = lignecommandes;
    }
   
    public BigDecimal getNoarticle() {
        return this.noarticle;
    }
    
    public void setNoarticle(BigDecimal noarticle) {
        this.noarticle = noarticle;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrixunitaire() {
        return this.prixunitaire;
    }
    
    public void setPrixunitaire(BigDecimal prixunitaire) {
        this.prixunitaire = prixunitaire;
    }
    public BigDecimal getQuantiteenstock() {
        return this.quantiteenstock;
    }
    
    public void setQuantiteenstock(BigDecimal quantiteenstock) {
        this.quantiteenstock = quantiteenstock;
    }
    public Set getLignecommandes() {
        return this.lignecommandes;
    }
    
    public void setLignecommandes(Set lignecommandes) {
        this.lignecommandes = lignecommandes;
    }




}

