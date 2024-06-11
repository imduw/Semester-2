package client.controller;

import common.model.Order;
import common.model.Product;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import client.SocketManager;
import client.view.ui.LoginUI;
import client.view.ui.ShopUI;

public class OrderController {
        
	private static final Socket socket = SocketManager.getSocket();
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private LoginUI lui;
    private ShopUI sui;
	private JLabel total ;
	private JTextField IPreceive ;
	private JLabel nameuser ;
	private JLabel warning_invoice ;
	private JLabel LBrefund ;
	private JTextField IPday;
	private JTextField IPmonth;
	private JTextField IPyear;
	private JLabel notificate_order;
	 private JTable table_order ;
	
    

    public OrderController( LoginUI lui, ShopUI sui) {
        this.lui = lui;
        this.sui = sui;
        
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        initializeFields();
        addListener();
 
    }
    
    private void addListener() {
    	sui.getBpayment().addActionListener(e -> addOrder());
    	sui.getBsalesOrder().addActionListener(e -> {
    		refreshOrderPanel();
    		sui.getCardPanel().removeAll();
            sui.getCardPanel().add(sui.getSalesOrderPanel());
            sui.getCardPanel().repaint();
            sui.getCardPanel().revalidate();
    	});
    	sui.getIPsearch_order().addActionListener(e -> searchOrders());
    	sui.getBsearch_order().addActionListener(e -> searchOrdersByDate());
    	sui.getBrefreshOrder().addActionListener(e -> refreshOrderPanel());
    }
    
    private void initializeFields() {
    	  total = sui.getLBtotal();
    	  IPreceive = sui.getIPreceive();
    	  nameuser = sui.getLBnameuser();
    	  warning_invoice = sui.getLBwarning_invoice();
    	  LBrefund = sui.getLBrefund();
    	   table_order = sui.getTable_order();
    	   IPday = sui.getIPday();
    	   IPmonth = sui.getIPmonth();
    	   IPyear = sui.getIPyear();
    	   notificate_order = sui.getLBnotificate_order();
    }
    
    
  //-------------------------------ADD-ORDERS------------------------------------//
    
    private void addOrder() {
		Date date = new Date();
		Order order = new Order();
		String totalText = total.getText();
		String receiveText = IPreceive.getText();

		if (!totalText.isEmpty()) {		    
		    int total = Integer.parseInt(totalText);
		    int receive;

		    try {
		        receive = Integer.parseInt(receiveText);
		    } catch (NumberFormatException e) {
		        warning_invoice.setText("Invalid receive amount");
		        return;
		    }		    
		    if (receive < total) {
		        warning_invoice.setText("The receive amount is not enough");
		    } else {
		    	order.setCreator(nameuser.getText());
			    order.setDate(date);
			    order.setTotal(total);
			    
		        int refund = receive - total;
		        String result = sendAddOrder(order);
		        if(result != null && result.equals("ADD_SUCCESS")) {
		        	LBrefund .setText(String.valueOf(refund));
			        warning_invoice.setText("Complete payment");
		        }else if(result != null && result.equals("ADD_FAILLURE")){
		        	warning_invoice.setText("Add order failure");
		        }else {
		        	warning_invoice.setText("............");
		        }
		    }
		} else {
		    warning_invoice.setText("No product is selected");
		}
	}
    
    private String sendAddOrder(Order order) {
        try {
            out.writeObject("ADD_ORDER");
            out.writeObject(order);
            out.flush();
            return  (String) in.readObject();
        } catch (IOException |ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
  //-------------------------------SEARCH-ORDER------------------------------------//
    
    private void searchOrders() {
        	String keyword = sui.getIPsearch_order().getText();
        	List<Order> orderList = sendGetOrderByKeyword(keyword);
        	tableSearch_Order(orderList);
       
    }
    
    private void searchOrdersByDate() {
    	try {
			int year = Integer.parseInt(IPyear.getText());
			int month = Integer.parseInt(IPmonth.getText());
			int day = Integer.parseInt(IPday.getText());
			if(IPday.getText().isEmpty() || IPmonth.getText().isEmpty() ||IPyear.getText().isEmpty()) {
				notificate_order.setText("Fill in the date");
			}else if(year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
				notificate_order.setText("Invalid date");
			}else {
				String date = day + "_" + month + "_"+ year;
				List<Order> orders = sendGetOrderByDate(date);
				tableSearch_Order(orders);
			}
		} catch (NumberFormatException e1) {
			notificate_order.setText("Invalid date");
			
		}
    }
    
    private void tableSearch_Order(List<Order> orderList) {
    	DefaultTableModel model = (DefaultTableModel) table_order.getModel();        
        model.setRowCount(0);
        for (Order order : orderList) {       	
            model.addRow(new Object[]{order.getID(),
            						  order.getCreator(),
            						  order.getTotal(),
            						  order.getDate()
        							  });
        }    
        table_order.setModel(model);
    }
    
  //-------------------------------REFRESH-ORDER-PANEL------------------------------------//
    private void refreshOrderPanel() {
    	refreshOrderTable();
    	IPday.setText("");
		IPmonth.setText("");
		IPyear.setText("");
		notificate_order.setText("");
    }
    
  //-------------------------------REFRESH-ORDER-TABLE------------------------------------//
    private void refreshOrderTable() {
    	  
		
		List<Order> orderList = sendGetAllOrders();
	    if (orderList != null) {
	        DefaultTableModel model = (DefaultTableModel) table_order.getModel();        
	        model.setRowCount(0);

	        for (Order order : orderList) {
	            model.addRow(new Object[]{order.getID(),
	                                       order.getCreator(),
	                                       order.getTotal(),
	                                       order.getDate()
	            });
	        }    
	        table_order.setModel(model);
	    } else {
	        System.out.println("OrderList Null");
	    }  
		
    }
    
  //-------------------------------GET-ORDERS-BY-DATE------------------------------------//
    public List<Order> sendGetOrderByDate(String date) {
        try {
            out.writeObject("GET_ORDER_BY_DATE");
            out.writeObject(date);
            out.flush();
            return (List<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    //-------------------------------GET-ORDERS-BY-KEYWORD------------------------------------//
    public List<Order> sendGetOrderByKeyword(String keyword) {
        try {
            out.writeObject("GET_ORDER_BY_KEYWORD");
            out.writeObject(keyword);
            out.flush();
            return (List<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
  //-------------------------------GET-ALL-ORDERS------------------------------------//

    private List<Order> sendGetAllOrders() {
        try {
            out.writeObject("GET_ALL_ORDERS");
            out.flush();
            return (List<Order>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
  
    
    
}
