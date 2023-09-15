package foodapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	private int order_id;
	@Column(nullable=false)
	private LocalDateTime order_date;
	@Column(nullable=false)
	private String order_status;
	
	@ManyToOne
	@JoinColumn(name = "dish_id")
	private Dish dish;

	public Order(){
		
	}
	public Order(int order_id, LocalDateTime order_date, String order_status, Dish dish) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.order_status = order_status;
		this.dish = dish;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", order_status=" + order_status
				+ ", dish=" + dish + "]";
	}
}
