package entity;
// Generated 2018-05-28 19:53:34 by Hibernate Tools 4.3.1



/**
 * VenteId generated by hbm2java
 */
public class VenteId  implements java.io.Serializable {


     private int numvendeur;
     private int numpiece;
     private int numprojet;

    public VenteId() {
    }

    public VenteId(int numvendeur, int numpiece, int numprojet) {
       this.numvendeur = numvendeur;
       this.numpiece = numpiece;
       this.numprojet = numprojet;
    }
   
    public int getNumvendeur() {
        return this.numvendeur;
    }
    
    public void setNumvendeur(int numvendeur) {
        this.numvendeur = numvendeur;
    }
    public int getNumpiece() {
        return this.numpiece;
    }
    
    public void setNumpiece(int numpiece) {
        this.numpiece = numpiece;
    }
    public int getNumprojet() {
        return this.numprojet;
    }
    
    public void setNumprojet(int numprojet) {
        this.numprojet = numprojet;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VenteId) ) return false;
		 VenteId castOther = ( VenteId ) other; 
         
		 return (this.getNumvendeur()==castOther.getNumvendeur())
 && (this.getNumpiece()==castOther.getNumpiece())
 && (this.getNumprojet()==castOther.getNumprojet());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNumvendeur();
         result = 37 * result + this.getNumpiece();
         result = 37 * result + this.getNumprojet();
         return result;
   }   


}


