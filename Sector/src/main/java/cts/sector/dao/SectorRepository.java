package cts.sector.dao;
import org.springframework.data.repository.CrudRepository;

import cts.sector.pojo.Sector;



public interface SectorRepository extends CrudRepository<Sector,Integer> {
	
	Iterable<Sector> findAll();

}