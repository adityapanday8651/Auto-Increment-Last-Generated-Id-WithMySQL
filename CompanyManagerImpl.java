package com.comp.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.manager.CompanyManager;
import com.comp.model.Company;
import com.comp.repository.CompanyRepository;

@Service
public class CompanyManagerImpl implements CompanyManager{
	
	@Autowired CompanyRepository companyRepository;

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public int saveComapany(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company).getId();
	}

	@Override
	public Company findByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		return companyRepository.findByCompanyId(companyId);
	}

}
