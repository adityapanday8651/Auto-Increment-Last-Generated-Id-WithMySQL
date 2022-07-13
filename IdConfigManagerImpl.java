package com.comp.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.manager.IdConfigManager;
import com.comp.model.IdConfig;
import com.comp.repository.IdConfigRepository;

@Service
public class IdConfigManagerImpl implements IdConfigManager{
	
	@Autowired IdConfigRepository idConfigRepository;

	@Override
	public List<IdConfig> findAll() {
		// TODO Auto-generated method stub
		return idConfigRepository.findAll();
	}

	@Override
	public IdConfig findByName(String name) {
		// TODO Auto-generated method stub
		return idConfigRepository.findByName(name);
	}

	@Override
	public void saveIdConfig(IdConfig config) {
		// TODO Auto-generated method stub
		idConfigRepository.save(config);
	}

}
