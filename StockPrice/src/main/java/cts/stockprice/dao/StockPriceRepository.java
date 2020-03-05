package cts.stockprice.dao;
import org.springframework.data.repository.CrudRepository;

import cts.stockprice.pojo.StockPrice;


public interface StockPriceRepository extends CrudRepository<StockPrice,String> {
	
	Iterable<StockPrice> findAll();

}
