package cts.stockexchange.dao;

import org.springframework.data.repository.CrudRepository;

import cts.stockexchange.pojo.StockExchange;



public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer> {

}
