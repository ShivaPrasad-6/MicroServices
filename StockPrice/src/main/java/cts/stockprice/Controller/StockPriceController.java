package cts.stockprice.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cts.stockprice.dao.StockPriceRepository;
import cts.stockprice.pojo.StockPrice;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stockprice")
public class StockPriceController {

	@Autowired
	private StockPriceRepository stockpriceRepository;

	@RequestMapping("/getAllStockPrice")
	public Iterable<StockPrice> getAllStockPrice() {
		return stockpriceRepository.findAll();
	}

	@PostMapping("/saveStockPrice")
	public StockPrice saveStockPrice(@RequestBody StockPrice stockprice) {
		System.out.println(stockprice);
		stockpriceRepository.save(stockprice);
		return stockprice;
	}

	@PutMapping("/updateStockPrice/{stockexchange}")
	public StockPrice updateStockPrice(@RequestBody StockPrice stockprice,
			@PathVariable("stockexchange") String stockexchange) {
		stockprice.setCompanyname(stockexchange);
		System.out.println(stockprice);
		stockpriceRepository.save(stockprice);
		return stockprice;
	}

	@DeleteMapping("/deleteStockPrice/{stockexchange}")
	public Boolean deleteStockPrice(@PathVariable("stockexchange") String stockexchange) {
		System.out.println(stockexchange);
		stockpriceRepository.deleteById(stockexchange);
		return true;
	}

	@GetMapping("/findOneInAll5/{stockexchange}")
	public StockPrice findoneinall(@PathVariable("stockexchange") String stockexchange) {
		Optional<StockPrice> stockprice = stockpriceRepository.findById(stockexchange);
		return stockprice.get();
	}

	@GetMapping("/findByCompanyname/{companyname}")
	public List<StockPrice> findByCompanyname(@PathVariable("companyname") String companyname) {
		List<StockPrice> stockprice = stockpriceRepository.findByCompanyname(companyname);
		return stockprice;
	}

	@RequestMapping("/multiplelinechart")

	public ResponseEntity<?> getDataForMultipleLine() {
		Iterable<StockPrice> dataList = stockpriceRepository.findAll();
		Map<String, List<StockPrice>> mappedData = new HashMap<>();
		List<StockPrice> stockPriceList = new ArrayList<StockPrice>();
		dataList.forEach(stockPriceList::add);
		for (StockPrice data : stockPriceList) {
			if (mappedData.containsKey(data.getCompanyname())) {
				mappedData.get(data.getCompanyname()).add(data);
			} else {
				List<StockPrice> tempList = new ArrayList<StockPrice>();
				tempList.add(data);
				mappedData.put(data.getCompanyname(), tempList);
			}
		}
		return new ResponseEntity<>(mappedData, HttpStatus.OK);
	}
	
	@PostMapping("/uploadfile/{stockexchange}")
	public int handleFileUpload(@PathVariable("stockexchange") String stockexchange,
			@RequestParam("file") MultipartFile file, HttpSession session) {
		Path rootLocation = Paths.get("c://temp//" + file.getOriginalFilename());
		try {
			Files.write(rootLocation, file.getBytes());
			try
			{
				FileInputStream fileNew = new FileInputStream(new File("c://temp//" + file.getOriginalFilename()));
				// Create Workbook instance holding reference to .xlsx file
				XSSFWorkbook workbook = new XSSFWorkbook(fileNew);
				// Get first/desired sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);
				// Iterate through each rows one by one
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext())
				{
					Row row = rowIterator.next();
					StockPrice stockPrice = new StockPrice();
					// For each row, iterate through all the columns
					Cell cell0 = row.getCell(0);
					// System.out.println(""+cell0.getStringCellValue());
					stockPrice.setCompanyname(cell0.getStringCellValue());
					Cell cell1 = row.getCell(1);
					// System.out.println(""+cell1.getStringCellValue());
					stockPrice.setStockexchange(cell1.getStringCellValue());
					Cell cell2 = row.getCell(2);
					if (cell2.getCellType() == cell2.CELL_TYPE_STRING) {
						// System.out.println(""+cell2.getStringCellValue());
						stockPrice.setCurrentprice(Integer.parseInt(cell2.getStringCellValue()));
					}
					else if (cell2.getCellType() == cell2.CELL_TYPE_NUMERIC) {
						// System.out.println(""+cell2.getNumericCellValue());
						stockPrice.setCurrentprice((int)cell2.getNumericCellValue());
					}
					Cell cell3 = row.getCell(3);
					// System.out.println(""+cell3.getStringCellValue());
					stockPrice.setDate(cell3.getStringCellValue());
					Cell cell4 = row.getCell(4);
					if (cell4.getCellType() == cell4.CELL_TYPE_STRING) {
						// System.out.println(""+cell4.getStringCellValue());
						stockPrice.setTime(cell4.getStringCellValue());
					}
					else if (cell4.getCellType() == cell4.CELL_TYPE_NUMERIC) {
						// System.out.println(""+cell4.getNumericCellValue());
						stockPrice.setTime("" + cell4.getNumericCellValue());
					}
					System.out.println("----------------------------------------------------------");
					stockPrice.setUploadfile(file.getOriginalFilename());
					stockpriceRepository.save(stockPrice);
				}
				fileNew.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}