package server.service;



import common.model.Product;
import server.dao.ProductDAO;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }
    
  //---------------ADD-PRODUCT---------------------//
    
    public String addProduct(Product product) {
        
        if(productDAO.isProductNameExists(product.getProductName()) == true) {
            return "PRODUCT_EXIST";
        } else {
            try {
                productDAO.addProduct(product);
                return "ADD_SUCCESS";
            } catch (Exception e) {
                e.printStackTrace();
                return "ADD_FAILURE";
            }
        }
    }


  //---------------UPDATE-PRODUCT---------------------//
    
    public String updateProduct(Product product) {
        
        if (productDAO.getProductById(product.getProductID()) != null) {
            try {
                productDAO.updateProduct(product);
                return "UPDATE_SUCCESS"; 
            } catch (Exception e) {
                e.printStackTrace();
                return "UPDATE_FAILURE"; 
            }
        } else {
            return "PRODUCT_NOT_EXIST";
        }
    }

  //---------------DELETE-PRODUCT---------------------//
    
    public String deleteProduct(int id) {
        Product product = productDAO.getProductById(id);
        if (product != null) {
            productDAO.deleteProduct(product);
            return "DELETE_SUCCESS";
        }
        return "DELETE_FAILED";
        
    }
    
    //---------------GET-PRODUCT-BY-ID---------------------//

    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    //---------------GET-ALL-PRODUCT---------------------//
    
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
    
    //---------------GET-PRODUCTS-AVAILABLE---------------------//
    
    public boolean isProductNameExists(String name){
    	return productDAO.isProductNameExists(name);
    }
    
    //---------------GET-PRODUCT-BY-KEYWORD---------------------//
    
    public List<Product> getProductsByKeyword(String keyword){
    	return productDAO.getProductsByKeyword(keyword);
    }
    
    
    
}
