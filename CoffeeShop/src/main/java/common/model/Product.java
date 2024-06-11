package common.model;


import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 2L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer productID;
    
    
    
    @Column(name = "Name")    
    private String productName;
    
    @Column(name = "Category")
    private Boolean productCategory;
    
    @Column(name = "Price")
    private Integer productPrice;
    
    @Column(name = "Status")
    private Boolean productStatus;

    public Product() {
    }

    public Product(Integer productID, String productName, Boolean productCategory, Integer productPrice,
                        Boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }
    

    

	public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Boolean isProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Boolean productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }
}