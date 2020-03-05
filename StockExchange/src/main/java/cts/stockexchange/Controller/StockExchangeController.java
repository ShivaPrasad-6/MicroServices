package cts.stockexchange.Controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cts.stockexchange.dao.StockExchangeRepository;
import cts.stockexchange.pojo.StockExchange;






@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/StockExchange")
public class StockExchangeController {
	
	@Autowired
	private StockExchangeRepository stockexchangeRepository;

	@RequestMapping("/getAllStockExchange")
	public Iterable<StockExchange> getAllStockExchange(){
		return stockexchangeRepository.findAll();
	}
	
	@PostMapping("/saveStockExchange")
	public  StockExchange saveStockExchange(@RequestBody StockExchange stockexchange) {
		System.out.println(stockexchange);
		stockexchangeRepository.save(stockexchange);
		return stockexchange;
	}
	
	@PutMapping("/updateStockExchange/{seid}")
	public StockExchange updateStockExchange(@RequestBody StockExchange stockexchange,@PathVariable("seid") Integer seid) {
		stockexchange.setSeid(seid);
		System.out.println(stockexchange);
		
		stockexchangeRepository.save(stockexchange);
		return stockexchange;
	}
	@DeleteMapping("/deleteStockExchange/{seid}")
	public Boolean deleteStockExchange(@PathVariable("seid") Integer seid) {
		System.out.println(seid);
		Optional<StockExchange> stockexchange = stockexchangeRepository.findById(seid);
		stockexchangeRepository.delete(stockexchange.get());
		return true;
	}
	@GetMapping("/findOneInAll4/{seid}")
	public StockExchange findoneinall(@PathVariable("seid") Integer seid) {
		Optional<StockExchange> stockexchange = stockexchangeRepository.findById(seid);
		return stockexchange.get();
	}
}
