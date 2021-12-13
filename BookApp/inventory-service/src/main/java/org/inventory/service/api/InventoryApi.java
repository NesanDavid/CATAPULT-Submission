package org.inventory.service.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.inventory.service.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryApi {
    private List<Book> books;
	
	
	
	public InventoryApi() {
		books = new ArrayList<>();
		books.add(new Book(1,"Book1", "author1", 111111));
		books.add(new Book(2,"Book2", "author2", 222222));
		books.add(new Book(3,"Book3", "author3", 333333));
		books.add(new Book(4,"Book4", "author4", 444444));
		books.add(new Book(5,"Book5", "author1", 555555));
		books.add(new Book(6,"Book6", "author2", 666666));
		books.add(new Book(7,"Book7", "author2", 777777));
	}
	
	@GetMapping("/books/{id}")
	public Book findById(@PathVariable("id") String id) {
		
		return books.stream().filter(it -> it.getId().toString().equals(id)).findFirst().get();
	}
	
	@GetMapping("/books/author/{author}")
	public List<Book> findByAuthorId(@PathVariable("author") String author) {
		
		return books.stream().filter(it -> it.getAuthor().equals(author)).collect(Collectors.toList()) ;
	}
	
	@RequestMapping("/books")
	public List<Book> findAll() {
		return books;
	}

	@PostMapping("/addBook")
	public String addBooks(@RequestBody Book book)
	{
		System.out.println("ADDED: "+book);
		books.add(book);
		return "Book has been added";
	}
    
}
