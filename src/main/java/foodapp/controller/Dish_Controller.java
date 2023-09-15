package foodapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodapp.model.Dish;
import foodapp.model.Restaurant;
import foodapp.repo.Dish_Repo;
import foodapp.services.Dish_ServicesImpl;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1/admin/login/restaurant/dish")
public class Dish_Controller {
	@Autowired
	private Dish_ServicesImpl ds;
	
	@Transactional
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody Dish d){
		List<Dish> d1=ds.get();
		Dish d2=ds.post(d);
		if(d1.contains(d2)) {
			return new ResponseEntity<String>("same dish id exists already",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Dish>(ds.post(d),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getall(){
		return new ResponseEntity<List<Dish>>(ds.get(),HttpStatus.OK);
	}
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody Dish d){
		return new ResponseEntity<Dish>(ds.put(d),HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") int id){
		Optional<Dish> d=ds.getbyid(id);
		if(d==null) {
			return new ResponseEntity<String>("no such dish id to get",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Dish>>(d,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		Optional<Dish> d=ds.delete(id);
		if(d==null) {
			return new ResponseEntity<String>("no such dish id to delete",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Dish>>(d,HttpStatus.OK);
	}
	
}
