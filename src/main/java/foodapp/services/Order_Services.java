package foodapp.services;

import java.util.List;
import java.util.Optional;

import foodapp.model.Order;

public interface Order_Services {
	
	public Order post(Order o);
	public List<Order> get();
	public Order put(Order o);
	public Optional<Order> getbyid(int id); 
}
