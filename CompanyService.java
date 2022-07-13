package com.comp.ws;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.manager.CompanyManager;
import com.comp.manager.IdConfigManager;
import com.comp.model.Company;
import com.comp.model.IdConfig;
import com.comp.view.ListResponseView;
import com.comp.view.ResponseView;


@RestController
@RequestMapping(path="/company")
public class CompanyService extends GenericService{

	@Autowired CompanyManager companyManager;
	@Autowired IdConfigManager idConfigManager;

	@PostMapping(value="/save")
	public ResponseEntity<Object> saveCompany(@RequestBody Company company){
		ResponseView res= new ResponseView();
		IdConfig config = idConfigManager.findByName("company");
		
		if(config==null) {
			config=new IdConfig();
			config.setLastGeneratedId(2000);
			company.setCompanyId(config.getLastGeneratedId());
		}else {
			company.setCompanyId(config.getLastGeneratedId()+1);
			config.setLastGeneratedId(config.getLastGeneratedId()+1);
		}
		idConfigManager.saveIdConfig(config);
		companyManager.saveComapany(company);
		res.setMessage("Company Saved Successfully");
		res.setStatus(true);
		return toSuccess(res);
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<Object> listCompany(){
		List<Company> list =companyManager.findAll();
		return toSuccess(new ListResponseView(list.size(), list));
	}	
}
