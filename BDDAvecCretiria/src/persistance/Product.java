package persistance;
// Generated 2018-05-28 09:46:05 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private int productId;
     private int manufacturerId;
     private String productCode;
     private BigDecimal purchaseCost;
     private Integer quantityOnHand;
     private BigDecimal markup;
     private String available;
     private String description;

    public Product() {
    }

	
    public Product(int productId, int manufacturerId, String productCode) {
        this.productId = productId;
        this.manufacturerId = manufacturerId;
        this.productCode = productCode;
    }
    public Product(int productId, int manufacturerId, String productCode, BigDecimal purchaseCost, Integer quantityOnHand, BigDecimal markup, String available, String description) {
       this.productId = productId;
       this.manufacturerId = manufacturerId;
       this.productCode = productCode;
       this.purchaseCost = purchaseCost;
       this.quantityOnHand = quantityOnHand;
       this.markup = markup;
       this.available = available;
       this.description = description;
    }
   
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getManufacturerId() {
        return this.manufacturerId;
    }
    
    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public BigDecimal getPurchaseCost() {
        return this.purchaseCost;
    }
    
    public void setPurchaseCost(BigDecimal purchaseCost) {
        this.purchaseCost = purchaseCost;
    }
    public Integer getQuantityOnHand() {
        return this.quantityOnHand;
    }
    
    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
    public BigDecimal getMarkup() {
        return this.markup;
    }
    
    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }
    public String getAvailable() {
        return this.available;
    }
    
    public void setAvailable(String available) {
        this.available = available;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


