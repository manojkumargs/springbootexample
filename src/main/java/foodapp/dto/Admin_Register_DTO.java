package foodapp.dto;

public class Admin_Register_DTO {
	private int admin_id;
	private String email;
	private String password;
	
	public Admin_Register_DTO(int admin_id, String email, String password) {
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
		return "Admin_Register_DTO [admin_id=" + admin_id + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}
