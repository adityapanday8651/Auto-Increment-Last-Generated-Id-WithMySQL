package com.comp.manager;

import java.util.List;

import com.comp.model.Company;

public interface CompanyManager {
	List<Company> findAll();
	int saveComapany(Company company);
	Company findByCompanyId(int companyId);
}
