package foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import foodapp.model.Dish;

@Repository
public interface Dish_Repo extends JpaRepository<Dish, Integer>{

}
