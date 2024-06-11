package client.controller;



import common.model.Product;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import client.SocketManager;
import client.view.ui.LoginUI;
import client.view.ui.ShopUI;

public class ProductController {
	private static final Socket socket = SocketManager.getSocket();
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private LoginUI lui;
    private ShopUI sui;
    JLabel id ;
    JTextField productName ;
    JTextField productPrice;
    JRadioButton RBdrink; 
    JRadioButton RBfood;   
    JRadioButton RBavailable;
    JRadioButton RBnotAvailable;
    ButtonGroup group_category;
	ButtonGroup group_status ;
    JLabel warning ;
    JLabel notificate ;
    JTable tableProduct ;
    JTable tableDashboard ;
    JTable tableInvoice ;
    JLabel warning_dashboard;
    JLabel warning_invoice ;
    JLabel showProduct ;
    JLabel showPrice ;
    JTextField quantity ;
     

    public ProductController(ShopUI sui,LoginUI lui) {
    	this.lui=lui;
        this.sui=sui;        
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();      
        }           
        initializeFields();
        addListener();
    }	
  //-------------------------------ADD-LISTENER------------------------------------//
    
    
    private void addListener() {
    	//---------------------------PRODUCT------------------------------------//
    	sui.getBadd().addActionListener(e -> addProduct());
    	sui.getBdelete().addActionListener(e -> deleteProduct());
    	sui.getBupdate().addActionListener(e -> updateProduct());
    	sui.getBrefresh().addActionListener(e -> refreshProductPanel());
    	sui.getIPsearch_product().addActionListener(e -> searchProducts());
    	sui.getBproductForm().addActionListener(e -> {
    		refreshProductPanel();
    		sui.getCardPanel().removeAll();
            sui.getCardPanel().add(sui.getProductPanel());
            sui.getCardPanel().repaint();
            sui.getCardPanel().revalidate();
    		});
    	sui.getTable_product().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleTableProductClick();
    	    }
    	});
    	
    	//--------------------------DASHBOARD-------------------------------------//
    	sui.getBdashboardForm().addActionListener(e -> {
    		refreshDashboardPanel();
    		sui.getCardPanel().removeAll();
            sui.getCardPanel().add(sui.getDashboardPanel());
            sui.getCardPanel().repaint();
            sui.getCardPanel().revalidate();
    		});
    	sui.getBadd_invoice().addActionListener(e -> addInvoice());
    	sui.getBremove_invoice().addActionListener(e -> deleteInvoice());
    	sui.getBrefresh_invoice().addActionListener(e -> refreshDashboardPanel());
    	sui.getIPsearch_dashboard().addActionListener(e -> searchProductsInDashboard());
    	sui.getTable_dasboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleTableDashboardClick();
    	    }
    	});
    	
    }
    
  //--------------------------------INITIALIZE-FIELDS------------------------------------//
    
    private void initializeFields() {
    	 id = sui.getLBidProduct();
         productName = sui.getIPproduct();
         productPrice = sui.getIPprice();
         RBdrink = sui.getRBdrink(); 
         RBfood = sui.getRBfood();   
         RBavailable = sui.getRBavailable();
         RBnotAvailable = sui.getRBnotAvailable();
         group_category = sui.getGroup_category();
    	 group_status = sui.getGroup_status();
         warning = sui.getLBwarning();
         notificate = sui.getLBnotificate();
         tableProduct = sui.getTable_product();
         tableDashboard = sui.getTable_dasboard();
         tableInvoice = sui.getTable_invoice();
         warning_dashboard = sui.getLBwarning_dashboard();
         warning_invoice = sui.getLBwarning_invoice();
         showProduct = sui.getLBshowProduct();
         showPrice = sui.getLBshowPrice();
         quantity = sui.getIPquantity();
    }
    
  
  //-------------------------------ADD-PRODUCT------------------------------------//
    
    private void addProduct () {
    	if (sui.getIPproduct().getText().isEmpty()) {
	        warning.setText("Please enter product name");
	        return;
	    }

	    if (productPrice.getText().isEmpty()) {
	        warning.setText("Please enter product price");
	        return;
	    }

	    int price;
	    try {
	        price = Integer.parseInt(productPrice.getText());
	        if (price <= 0) {
	            warning.setText("Product price must be greater than 0");
	            return;
	        }
	    } catch (NumberFormatException e) {
	        warning.setText("Invalid product price");
	        return;
	    }

	    if (!RBdrink.isSelected() && !RBfood.isSelected()) {
	        warning.setText("Please select product category");
	        return;
	    }

	    if (!RBavailable.isSelected() && !RBnotAvailable.isSelected()) {
	        warning.setText("Please select product status");
	        return;
	    }

	    boolean selectDrink = RBdrink.isSelected();
	    boolean selectAvailable = RBavailable.isSelected();

	    Product product = new Product();
	    product.setProductName(productName.getText());
	    product.setProductPrice(price);
	    product.setProductCategory(selectDrink);
	    product.setProductStatus(selectAvailable);
	    String result =  sendAddProduct(product);
	    
	    if(result != null && result.equals("ADD_SUCCESS")) {
	    	sui.getBrefresh().doClick();
	    	notificate.setText("Add " + productName.getText()+" successlly");
	    }else if(result != null && result.equals("ADD_FAILURE")){
	    	notificate.setText("Add " + productName.getText()+" failure");
	    }else if(result != null && result.equals("PRODUCT_EXIST")){
	    	notificate.setText(" " + productName.getText()+" existeds");
	    }
    }
    
    public String sendAddProduct(Product product) {
        try {
            out.writeObject("ADD_PRODUCT");
            out.writeObject(product);
            out.flush();
            String response = (String) in.readObject();
            return response ;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
  //-------------------------------UPDATE-PRODUCT------------------------------------//
    public void updateProduct() {
    	if (productName.getText().isEmpty()) {
	        warning.setText("Please enter product name");
	        return;
	    }

	    if (productPrice.getText().isEmpty()) {
	        warning.setText("Please enter product price");
	        return;
	    }

	    if (group_category.getSelection() == null) {
	        warning.setText("Please select product category");
	        return;
	    }

	    if (group_status.getSelection() == null) {
	        warning.setText("Please select product status");
	        return;
	    }

	    
	    int price;
	    try {
	        price = Integer.parseInt(productPrice.getText());
	        if (price <= 0) {
	            warning.setText("Product price must be greater than 0");
	            return;
	        }
	    } catch (NumberFormatException e) {
	        warning.setText("Invalid product price");
	        return;
	    }
	     
	    boolean selectDrink = RBdrink.isSelected();
	    boolean selectAvailable = RBavailable.isSelected();

	    Product product = new Product();
	    product.setProductID(Integer.parseInt(id.getText()));
	    product.setProductName(productName.getText());
	    product.setProductPrice(Integer.parseInt(productPrice.getText()));
	    product.setProductCategory(selectDrink);
	    product.setProductStatus(selectAvailable);
	    
	    String result1 = sendUpdateProduct(product);
	    if(result1.equals("UPDATE_SUCCESS")) {
	    	sui.getBrefresh().doClick();
	    	notificate.setText("Product "+ id.getText() + " update successlly");
	    }
	    else if(result1.equals("PRODUCT_NOT_EXIST")) {
	    	notificate.setText("ID product not exist");
	    }else {
	    	notificate.setText("Product "+ id.getText() +" update failure");
	    }
    }
    public String sendUpdateProduct(Product product) {
        try {
            out.writeObject("UPDATE_PRODUCT");
            out.writeObject(product);
            out.flush();
            String response = (String) in.readObject();  
            return response;  
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
  //-------------------------------DELETE-PRODUCT------------------------------------//
    
    private void deleteProduct() {
    	if(id.getText().isEmpty()) {
    		 warning.setText("Please select product");
    		 return;
    	}
    	int id1 = Integer.parseInt(id.getText());
    	String result = sendDeleteProduct(id1);
    	if(result != null && result.equals("DELETE_SUCCESS")) {
    		sui.getBrefresh().doClick();
    		notificate.setText("Product "+ id.getText() + " is deleted");
    	}else {
    		notificate.setText("Delete product "+ id.getText() +" failure");
    	}
    }
    public String sendDeleteProduct(int id) {
        try {
            out.writeObject("DELETE_PRODUCT");
            out.writeObject(id);
            out.flush();
            String response = (String) in.readObject();
            return response;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    } 
  //-------------------------------SEARCH-PRODUCT------------------------------------//
    
    		//------------------PRODUCT------------------------//	
    
    private void searchProducts() {
    	String keyword = sui.getIPsearch_product().getText();
    	List<Product> productList = sendGetProductByKeyword(keyword);
    	tableSearch(productList);

    }
    
    
    private void tableSearch(List<Product> productList) {
    	DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();        
        model.setRowCount(0);
        for (Product product : productList) {
        	String category = product.isProductCategory() ? "Drink" : "Food";
            String status = product.isProductStatus() ? "Available" : "Not Available";
        	
            model.addRow(new Object[]{product.getProductID(),
            						  product.getProductName(),
            						  category,
        							  product.getProductPrice(),
        							  status
        							  });
        }    
        tableProduct.setModel(model);
    }
    
    
    		//------------------DASHBOARD------------------------//	
    
    
    private void searchProductsInDashboard() {
    	String keyword = sui.getIPsearch_dashboard().getText();
    	List<Product> productList = sendGetProductByKeyword(keyword);
    	tableSearch_Dashboard(productList);
    }
    
    private void tableSearch_Dashboard(List<Product> productList) {
    	DefaultTableModel model = (DefaultTableModel) tableDashboard.getModel();
        model.setRowCount(0);        
        for (Product product : productList) {
        	if (!product.isProductStatus()) {
                
                continue;
            }
        	String category = product.isProductCategory() ? "Drink" : "Food";         
            model.addRow(new Object[]{product.getProductID(),
        						      product.getProductName(),
        						      category,
                                      product.getProductPrice(),
                                      "Available"
                                   	 });
        }
        tableDashboard.setModel(model);
    }
    
    
  //-------------------------------REFRESH-PANEL------------------------------------//
    
    private void refreshProductPanel() {
    	refreshTableProduct();
    	sui.getLBidProduct().setText("");
    	sui.getIPproduct().setText("");
    	sui.getIPprice().setText("");
    	RBavailable.setSelected(false);
    	RBnotAvailable.setSelected(false);
    	RBfood.setSelected(false);
    	RBdrink.setSelected(false);
    	warning.setText("");
    	notificate.setText("");
    }
    
    private void refreshDashboardPanel() {
    	DefaultTableModel model = (DefaultTableModel) tableInvoice.getModel();
    	model.setRowCount(0);
    	refreshTableDashboard();
    	showProduct.setText("");
    	showPrice.setText("");
    	quantity.setText("");
    	warning_dashboard.setText("");
    	warning_invoice.setText("");
    	sui.getLBtotal().setText("");
    	sui.getLBrefund().setText("");
    	sui.getIPreceive().setText("");
    }
    
    
  //-------------------------------REFRESH-TABLE------------------------------------//
    
    private void refreshTableDashboard() {
    	List<Product> productList = sendGetAllProducts();
    	DefaultTableModel model = (DefaultTableModel) tableDashboard.getModel();
        model.setRowCount(0);        
        for (Product product : productList) {
        	if (!product.isProductStatus()) {
                
                continue;
            }
        	String category = product.isProductCategory() ? "Drink" : "Food";         
            model.addRow(new Object[]{product.getProductID(),
        						      product.getProductName(),
        						      category,
                                      product.getProductPrice(),
                                      "Available"
                                   	 });
        }
        tableDashboard.setModel(model);
    }
    
    
    private void refreshTableProduct() {
    	List<Product> productList = sendGetAllProducts();
    	
    	DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();        
        model.setRowCount(0);
        for (Product product : productList) {
        	String category = product.isProductCategory() ? "Drink" : "Food";
            String status = product.isProductStatus() ? "Available" : "Not Available";
        	
            model.addRow(new Object[]{product.getProductID(),
            						  product.getProductName(),
            						  category,
        							  product.getProductPrice(),
        							  status
        							  });
        }    
        tableProduct.setModel(model);
    }
    
  //-------------------------------ADD-INVOICE------------------------------------//
    
    private void addInvoice() {
    	String quantityText = quantity.getText();
        String priceText = showPrice.getText();
        String productText = showProduct.getText();

        if (productText.isEmpty()) {
            warning_dashboard.setText("Please select a product");
            return;
        }
        
        if (quantityText.isEmpty()) {
            warning_dashboard.setText("Please enter quantity");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
            if (quantity <= 0) {
                warning_dashboard.setText("Quantity must be greater than 0");
                return;
            }
        } catch (NumberFormatException e) {
            warning_dashboard.setText("Invalid quantity");
            return;
        }

        

        int price;
        try {
            price = Integer.parseInt(priceText);
        } catch (NumberFormatException e) {
            warning_dashboard.setText("Invalid price");
            return;
        }

        int total = price * quantity;
        DefaultTableModel model = (DefaultTableModel) tableInvoice.getModel();
        model.addRow(new Object[]{productText, quantity, total});
        warning_dashboard.setText("");
        refreshInvoice();
    }
    
  //-------------------------------DELETE-INVOICE------------------------------------//
    
    private void deleteInvoice() {
    	try {
			int myindex = tableInvoice.getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) tableInvoice.getModel();
			model.removeRow(myindex);
			refreshInvoice();
		} catch (Exception e1) {
			warning_dashboard.setText("please select product to delete");
			
		}
    }
  //-------------------------------REFRESH-INVOICE------------------------------------//
    private void refreshInvoice() {
    	int sum = 0;
		for (int row = 0; row <tableInvoice.getRowCount(); row++) {
			int value = (int) tableInvoice.getValueAt(row, 2);
			sum += value;
		}
		sui.getLBtotal().setText(sum + "");
    }
    
    
  //-------------------------------HANDLE-TABLE-CLICK------------------------------------//
    
    public void handleTableProductClick() {
        DefaultTableModel model = (DefaultTableModel) tableProduct.getModel();
        int myIndex = tableProduct.getSelectedRow(); 
        int productID = Integer.parseInt(model.getValueAt(myIndex, 0).toString());
        sui.getLBidProduct().setText(model.getValueAt(myIndex, 0).toString());
        sui.getIPproduct().setText(model.getValueAt(myIndex, 1).toString()); 
        sui.getIPprice().setText(model.getValueAt(myIndex, 3).toString());
        model.getValueAt(myIndex, 2).toString();
        
        if(model.getValueAt(myIndex, 2).toString().equals("Drink")) {
            RBdrink.setSelected(true);
        } else {
            RBfood.setSelected(true);
        }
        if(model.getValueAt(myIndex, 4).toString().equals("Available")) {
            RBavailable.setSelected(true);
        } else {
            RBnotAvailable.setSelected(true);
        }
    }
    
    public void handleTableDashboardClick() {
        DefaultTableModel model = (DefaultTableModel) tableDashboard.getModel();
        int myIndex = tableDashboard.getSelectedRow(); 
        int productID = Integer.parseInt(model.getValueAt(myIndex, 0).toString());
        sui.getLBshowProduct().setText(model.getValueAt(myIndex, 1).toString()); 
        sui.getLBshowPrice().setText(model.getValueAt(myIndex, 3).toString());
    
    }
    
    
    
  //-------------------------------GET-PRODUCTS-BY-KEYWORD------------------------------------//
    
    public List<Product> sendGetProductByKeyword(String keyword) {
        try {
            out.writeObject("GET_PRODUCT_BY_KEYWORD");
            out.writeObject(keyword);
            out.flush();
            return (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
  //-------------------------------GET-ALL-PRODUCTS------------------------------------//
    public List<Product> sendGetAllProducts() {
        try {
            out.writeObject("GET_ALL_PRODUCTS");
            out.flush();	
            return (List<Product>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
  //-------------------------------GET-PRODUCT------------------------------------//
    public Product sendGetProduct(int id) {
        try {
            out.writeObject("GET_PRODUCT");
            out.writeInt(id);
            out.flush();
            return (Product) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
