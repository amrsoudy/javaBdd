package entite;
// Generated 2018-05-14 13:54:00 by Hibernate Tools 4.3.1



/**
 * Countries generated by hbm2java
 */
public class   Countries  implements java.io.Serializable {


     private String countryId;
     private Regions regions;
     private String countryName;

    public Countries() {
    }

	
    public Countries(String countryId) {
        this.countryId = countryId;
    }
    public Countries(String countryId, Regions regions, String countryName) {
       this.countryId = countryId;
       this.regions = regions;
       this.countryName = countryName;
    }
   
    public String getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    public Regions getRegions() {
        return this.regions;
    }
    
    public void setRegions(Regions regions) {
        this.regions = regions;
    }
    public String getCountryName() {
        return this.countryName;
    }
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }




}

