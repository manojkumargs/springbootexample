package foodapp.services;

import java.util.*;

import foodapp.model.Dish;

public interface Dish_Services {
	public Dish post(Dish d);
	public Optional<Dish> delete(int id);
	public List<Dish> get();
	public Dish put(Dish d);
	public Optional<Dish> getbyid(int id);
}
