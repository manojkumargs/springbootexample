package foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foodapp.dto.Admin_Login_DTO;
import foodapp.dto.Admin_Register_DTO;
import foodapp.response.Admin_Login_Message;
import foodapp.services.Admin_Register_ServicesImpl;
import foodapp.services.Admin_Register_services;

@RestController
@RequestMapping("api/v1/admin")
public class Admin_Register_Controller {
	@Autowired
	private Admin_Register_ServicesImpl ars;
	
	@PostMapping(path = "/register")
    public void addAdmin(@RequestBody Admin_Register_DTO ard)
    {
        ars.addAdmin(ard);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin_Login_DTO ald)
    {
    	Admin_Login_Message alm = ars.loginAdmin(ald);
        return ResponseEntity.ok(alm);
    }
}
