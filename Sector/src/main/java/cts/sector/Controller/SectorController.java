package cts.sector.Controller;

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



import cts.sector.dao.SectorRepository;
import cts.sector.pojo.Sector;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/sectors")
public class SectorController {
	
	@Autowired
	private SectorRepository sectorRepository;
	
	@RequestMapping("/getAllSectors")
	public Iterable<Sector> getAllSectors(){
		return sectorRepository.findAll();
	}
	
	@PostMapping("/saveSector")
	public  Sector saveCompany(@RequestBody Sector sector) {
		System.out.println(sector);
		sectorRepository.save(sector);
		return sector;
	}
	
	@PutMapping("/updateSector/{sectorid}")
	public Sector updateSector(@RequestBody Sector sector,@PathVariable("sectorid") Integer sectorid) {
		sector.setSectorid(sectorid);
		System.out.println(sector);
		
		sectorRepository.save(sector);
		return sector;
	}
	@DeleteMapping("/deleteSector/{sectorid}")
	public Boolean deleteCompany(@PathVariable("sectorid") Integer sectorid) {
		System.out.println(sectorid);
		Optional<Sector> sector = sectorRepository.findById(sectorid);
		sectorRepository.delete(sector.get());
		return true;
	}
	@GetMapping("/findOneInAll3/{sectorid}")
	public Sector findoneinall(@PathVariable("sectorid") Integer sectorid) {
		Optional<Sector> sector = sectorRepository.findById(sectorid);
		return sector.get();
	}
}

