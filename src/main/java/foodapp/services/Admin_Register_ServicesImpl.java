package foodapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import foodapp.dto.Admin_Login_DTO;
import foodapp.dto.Admin_Register_DTO;
import foodapp.model.Admin_Register;
import foodapp.repo.Admin_Register_Repo;
import foodapp.response.Admin_Login_Message;

import java.util.Optional;
@Service
public class Admin_Register_ServicesImpl implements Admin_Register_services {
    @Autowired
    private Admin_Register_Repo arr;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
	public void addAdmin(Admin_Register_DTO ard) {
		 Admin_Register admin = new Admin_Register(
				 	ard.getAdmin_id(),
				 	ard.getEmail(),
	               this.passwordEncoder.encode(ard.getPassword())
	        );
	     arr.save(admin);
	    }
	@Override
	public Admin_Login_Message loginAdmin(Admin_Login_DTO admin_login_dto) {
		
		Admin_Register admin1 = arr.findByEmail(admin_login_dto.getEmail());
        if (admin1 != null) {
            String password = admin_login_dto.getPassword();
            String encodedPassword = admin1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Admin_Register> admin = arr.findOneByEmailAndPassword(admin_login_dto.getEmail(), encodedPassword);
                if (admin.isPresent()) {
                    return new Admin_Login_Message("Login Success", true);
                } else {
                    return new Admin_Login_Message("Login Failed", false);
                }
            } else {
                return new Admin_Login_Message("password Not Match", false);
            }
        }else {
            return new Admin_Login_Message("Email not exits", false);
        }
	}
}
