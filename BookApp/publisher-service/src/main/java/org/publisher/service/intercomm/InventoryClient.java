package org.publisher.service.intercomm;

import java.util.List;

import org.publisher.service.model.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryClient {

	// @RequestMapping(value="/addBook", method=RequestMethod.POST)
	// public String addBooks(@RequestBody Book book);

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public List<Book> findAll();

	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String addBooks(@RequestBody Book book);
	

	
}


