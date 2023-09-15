package foodapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import foodapp.model.Order;
import foodapp.repo.Order_Repo;

@Service
public class Order_ServicesImpl implements Order_Services{
	@Autowired
	private Order_Repo or;
	
	@Override
	public Order post(Order o) {
		return or.save(o);
	}

	@Override
	public List<Order> get() {
		return or.findAll();
	}

	@Override
	public Order put(Order o) {
		return or.save(o);
	}

	@Override
	public Optional<Order> getbyid(int id) {
		if(or.existsById(id)) {
			return or.findById(id);
		}
		return null;
	}

}
