package foodapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodapp.model.Dish;
import foodapp.model.Order;
import foodapp.services.Order_ServicesImpl;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1/admin/login/restaurant/dish/order")
public class Order_Controller {
	@Autowired 
	private Order_ServicesImpl os;
	
	@Transactional
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody Order o){
		List<Order> o1=os.get();
		Order o2=os.post(o);
		if(o1.contains(o2)) {
			return new ResponseEntity<String>("same order id exists already",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Order>(os.post(o),HttpStatus.CREATED);

	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getall(){
		return new ResponseEntity<List<Order>>(os.get(),HttpStatus.OK);
	}
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody Order o){
		return new ResponseEntity<Order>(os.put(o),HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") int id){
		Optional<Order> o=os.getbyid(id);
		if(o==null) {
			return new ResponseEntity<String>("no such order id to get",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Order>>(o,HttpStatus.OK);
	}
}
