package entity;
// Generated 2018-06-02 11:50:04 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Livraison generated by hbm2java
 */
public class Livraison  implements java.io.Serializable {


     private int nolivraison;
     private Date datelivraison;

    public Livraison() {
    }

	
    public Livraison(int nolivraison) {
        this.nolivraison = nolivraison;
    }
    public Livraison(int nolivraison, Date datelivraison) {
       this.nolivraison = nolivraison;
       this.datelivraison = datelivraison;
    }
   
    public int getNolivraison() {
        return this.nolivraison;
    }
    
    public void setNolivraison(int nolivraison) {
        this.nolivraison = nolivraison;
    }
    public Date getDatelivraison() {
        return this.datelivraison;
    }
    
    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }




}

