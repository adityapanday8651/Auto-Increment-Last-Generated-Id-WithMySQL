package com.comp.manager;

import java.util.List;

import com.comp.model.IdConfig;


public interface IdConfigManager {
	List<IdConfig> findAll();
	IdConfig findByName(String name);
	void saveIdConfig(IdConfig config);
}
