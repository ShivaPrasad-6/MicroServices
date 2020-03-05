package com.cts.project.dao;
import org.springframework.data.repository.CrudRepository;

import com.cts.project.pojos.Sector;

public interface SectorRepository extends CrudRepository<Sector,Integer> {
	
	Iterable<Sector> findAll();

}
