package cts.stockprice.Controller;
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

import cts.stockprice.dao.StockPriceRepository;
import cts.stockprice.pojo.StockPrice;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	
	@Autowired
	private StockPriceRepository stockpriceRepository;
	
	@RequestMapping("/getAllStockPrice")
	public Iterable<StockPrice> getAllStockPrice(){
		return stockpriceRepository.findAll();
	}
	
	@PostMapping("/saveStockPrice")
	public  StockPrice saveStockPrice(@RequestBody StockPrice stockprice) {
		System.out.println(stockprice);
		stockpriceRepository.save(stockprice);
		return stockprice;
	}
	
	@PutMapping("/updateStockPrice/{companyname}")
	public StockPrice updateStockPrice(@RequestBody StockPrice stockprice,@PathVariable("companyname") String companyname) {
		stockprice.setCompanyname(companyname);
		System.out.println(stockprice);
		
		stockpriceRepository.save(stockprice);
		return stockprice;
	}
	@DeleteMapping("/deleteStockPrice/{companyname}")
	public Boolean deleteStockPrice(@PathVariable("companyname") String companyname) {
		System.out.println(companyname);
		stockpriceRepository.deleteById(companyname);
		return true;
	}

	@GetMapping("/findOneInAll5/{companyname}")
	public StockPrice findoneinall(@PathVariable("companyname") String companyname) {
		Optional<StockPrice> stockprice = stockpriceRepository.findById(companyname);
		return stockprice.get();
	}
	
}
