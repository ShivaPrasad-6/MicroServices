package cts.stockprice.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cts.stockprice.pojo.StockPrice;


public interface StockPriceRepository extends CrudRepository<StockPrice,String> {
	
	Iterable<StockPrice> findAll();

	List<StockPrice> findByCompanyname(String companyname);
	

}
