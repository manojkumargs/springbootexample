package foodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin_Register")
public class Admin_Register {
	@Id
	private int admin_id;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	
	public Admin_Register() {
	}
	public Admin_Register(int admin_id, String email, String password) {
		super();
		this.admin_id = admin_id;
		this.email = email;
		this.password = password;
		
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin_Register [admin_id=" + admin_id + ", email=" + email + ", password=" + password + "]";
	}
	
}
