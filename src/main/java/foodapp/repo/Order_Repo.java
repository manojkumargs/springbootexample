package foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodapp.model.Order;

@Repository
public interface Order_Repo extends JpaRepository<Order, Integer>{

}
