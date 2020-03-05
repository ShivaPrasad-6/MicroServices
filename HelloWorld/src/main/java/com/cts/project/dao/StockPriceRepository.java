package com.cts.project.dao;

import org.springframework.data.repository.CrudRepository;
import com.cts.project.pojos.StockPrice;

public interface StockPriceRepository extends CrudRepository<StockPrice,String> {
	
	Iterable<StockPrice> findAll();

}
