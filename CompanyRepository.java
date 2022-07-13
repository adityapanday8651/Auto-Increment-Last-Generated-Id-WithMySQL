package com.comp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	Company findByCompanyId(int companyId);

}
