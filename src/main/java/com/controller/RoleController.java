package com.controller;

import java.util.List;

import org.apache.catalina.mbeans.RoleMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.dao.RoleDao;

@RestController
public class RoleController {

	@Autowired
	RoleDao roleDao;

	
	@PostMapping("/login") ///body 
	public ResponseEntity<?> login(){
		//email password 
		//true 
//		return ResponseEntity.ok("Login done");//200 
		
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);//401
	}
	
	@PostMapping("/role")//body 
	public ResponseEntity<?> addRole(RoleBean roleBean) {

		boolean ans = roleDao.addRole(roleBean);

		if (ans == false) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(roleBean);
		}
	}

	
	@PutMapping("/role")//body roleId roleName 
	public ResponseEntity<?> updateRole(RoleBean roleBean) {

		boolean ans = roleDao.updateRole(roleBean);

		if (ans == false) {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return ResponseEntity.ok(roleBean);
		}
	}

	@GetMapping("/role")
	public ResponseEntity<List<RoleBean>> getAllRole() {

		List<RoleBean> roles = roleDao.getAllRole();
		return ResponseEntity.ok(roles);
	}

	
	
	@DeleteMapping("/role/{roleId}") //url 
	public String deleteRole(@PathVariable("roleId") int roleId) {
		roleDao.deleteRole(roleId);
		return "Deleted Role";
	}
}