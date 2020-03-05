package cts.company.dao;
import org.springframework.data.repository.CrudRepository;

import cts.company.pojo.Company;


public interface CompanyRepository extends CrudRepository<Company,String> {
	
	Iterable<Company> findAll();
}
