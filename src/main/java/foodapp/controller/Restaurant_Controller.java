package foodapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodapp.model.Restaurant;
import foodapp.repo.Restaurant_Repo;
import foodapp.services.Restaurant_ServicesImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@RestController
@RequestMapping("api/v1/admin/login/restaurant")
public class Restaurant_Controller {
	@Autowired
	private Restaurant_ServicesImpl rs;
	
	@Autowired
	private Restaurant_Repo rr;
	
	@GetMapping("/get")
	public ResponseEntity<?> getall(){
		return new ResponseEntity<List<Restaurant>>(rs.getall(),HttpStatus.OK);
	}
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody Restaurant r){
		List<Restaurant> r1=rs.getall();
		Restaurant r2=rs.post(r);
		if(r1.contains(r2)) {
			return new ResponseEntity<String>("same restaurant id exists already",HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Restaurant>(r2,HttpStatus.CREATED);
	}
	@PutMapping("/put")
	public ResponseEntity<?> put(@RequestBody Restaurant r){
//		List<Restaurant> r1=rs.getall();
//		Restaurant r2=rs.put(r);
//		if(r1.contains(r2)) {
//			return new ResponseEntity<String>("same restaurant details exists already",HttpStatus.OK);
//		}
		return new ResponseEntity<Restaurant>(rs.put(r),HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") int id){
		Optional<Restaurant> r=rs.getbyid(id);
		if(r==null) {
			return new ResponseEntity<String>("no such restaurant id to get",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Restaurant>>(r,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		Optional<Restaurant> r=rs.delete(id);
		if(r==null) {
			return new ResponseEntity<String>("no such restaurant id to delete",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Restaurant>>(r,HttpStatus.OK);
	}
	
	@Autowired
    private EntityManager entityManager; // Inject the entity manager

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<Restaurant>> getByName(@PathVariable("name") String name) {
        // Use a native SQL query to retrieve data based on the name
        String sql = "SELECT * FROM restaurant WHERE restaurant_name = :name";
        Query query = entityManager.createNativeQuery(sql, Restaurant.class);
        query.setParameter("name", name);
        
        @SuppressWarnings("unchecked")
        List<Restaurant> restaurants = query.getResultList();

        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    
    @GetMapping("/getByLocation/{location}")
    public ResponseEntity<List<Restaurant>> getByLocation(@PathVariable("location") String location) {
        String sql = "SELECT * FROM restaurant WHERE restaurant_loc = :location";
        Query query = entityManager.createNativeQuery(sql, Restaurant.class);
        query.setParameter("location", location);

        @SuppressWarnings("unchecked")
        List<Restaurant> restaurants = query.getResultList();

        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }
    
    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<List<Restaurant>> getByCategory(@PathVariable("category") String category) {
        String sql = "SELECT * FROM restaurant WHERE restaurant_cat = :category";
        Query query = entityManager.createNativeQuery(sql, Restaurant.class);
        query.setParameter("category", category);

        @SuppressWarnings("unchecked")
        List<Restaurant> restaurants = query.getResultList();

        if (restaurants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }


}
