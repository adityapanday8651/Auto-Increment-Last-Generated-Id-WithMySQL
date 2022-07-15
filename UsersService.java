package com.comp.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.manager.IdConfigManager;
import com.comp.manager.UsersManager;
import com.comp.model.IdConfig;
import com.comp.model.Users;
import com.comp.view.ListResponseView;
import com.comp.view.ResponseView;

@RestController
@RequestMapping(path="/users")
public class UsersService extends GenericService{
	@Autowired UsersManager usersManager;
	@Autowired IdConfigManager idConfigManager;
	
	@PostMapping(value="/save")
	public ResponseEntity<Object> saveUsers(@RequestBody Users users){
		ResponseView res=new ResponseView();
		
		IdConfig config = idConfigManager.findByName("users");
		
		if(config==null) {
			config = new IdConfig();
			config.setLastGeneratedId(3000);
			users.setUserId(config.getLastGeneratedId());
		}else {
			users.setUserId(config.getLastGeneratedId()+1);
			config.setLastGeneratedId(config.getLastGeneratedId()+1);
		}
		idConfigManager.saveIdConfig(config);
		usersManager.saveUsers(users);
		res.setMessage("Users Saved Successfully");
		res.setStatus(true);
		return toSuccess(res);		
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<Object> listUsers(){
		List<Users> list=usersManager.findAll();
		return toSuccess(new ListResponseView(list.size(), list));
	}
}
