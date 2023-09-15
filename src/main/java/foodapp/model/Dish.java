package foodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="dish")
public class Dish {
	@Id
	private int dish_id;
	private String dish_name;
	private double dish_price;
	private int dish_rating;
	
	@ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
	
	public Dish(int dish_id, String dish_name, double dish_price, int dish_rating, Restaurant restaurant) {
		super();
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_price = dish_price;
		this.dish_rating = dish_rating;
		this.restaurant = restaurant;
	}

	public Dish() {
	}
	
	public int getDish_id() {
		return dish_id;
	}
	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public double getDish_price() {
		return dish_price;
	}
	public void setDish_price(double dish_price) {
		this.dish_price = dish_price;
	}
	public int getDish_rating() {
		return dish_rating;
	}
	public void setDish_rating(int dish_rating) {
		this.dish_rating = dish_rating;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
