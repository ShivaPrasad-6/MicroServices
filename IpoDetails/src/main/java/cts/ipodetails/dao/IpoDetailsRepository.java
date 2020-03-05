package cts.ipodetails.dao;

import org.springframework.data.repository.CrudRepository;

import cts.ipodetails.pojo.IpoDetails;



public interface IpoDetailsRepository extends CrudRepository<IpoDetails,Integer> {
	
	Iterable<IpoDetails> findAll();

}
