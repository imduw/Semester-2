package server.service;

import server.dao.OrderDAO;

import java.util.List;

import common.model.Order;

public class OrderService {
	private OrderDAO orderDAO;

	public OrderService() {
		this.orderDAO = new OrderDAO();
		
	}
	//---------------ADD-ORDER---------------------//
	
	public String addOrder(Order order) {
		try {
			orderDAO.addOrder(order);
		} catch (Exception e) {			
			e.printStackTrace();
			return "ADD_FAILURE";
		}
		return "ADD_SUCCESS";
	}
	
	
	//---------------GET-ALL-ORDER---------------------//
	
	public List<Order> getAllOrder(){
		return orderDAO.getAllOrders();
	}
	//---------------GET-ORDER-BY-KEYWORD---------------------//
	
	public List<Order> getOrderByKeyword(String keyword){
		return orderDAO.getOrderByKeyword(keyword);
	}
	
	//---------------GET-ORDER-BY-DATE---------------------//
	
	public List<Order> getOrderByDate(String date){
		String[] splitDate = date.split("_");
		int day = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]);
		int year = Integer.parseInt(splitDate[2]);
		return orderDAO.getByDateOrder(day,month,year);
	}
	
}
