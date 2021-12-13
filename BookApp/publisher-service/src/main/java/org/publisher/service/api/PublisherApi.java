package org.publisher.service.api;

import java.util.ArrayList;
import java.util.List;

import org.publisher.service.intercomm.InventoryClient;
import org.publisher.service.model.Book;
import org.publisher.service.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherApi {
     @Autowired
	 private InventoryClient inventoryClient;

    private List<Publisher> publishers;
	
	public PublisherApi() {
		publishers = new ArrayList<>();
        List<Book> pubs=new ArrayList<Book>();
        pubs.add(new Book(22, "Alex Rider 1", "AH", 900));
        pubs.add(new Book(23, "Alex Rider 2", "AH", 900));
        List<Book> pubs2=new ArrayList<Book>();
        pubs2.add(new Book(33, "Harry Potter 1", "JKRowling", 900));
        pubs2.add(new Book(34, "Harry Potter 2", "JKRowling", 900));
		publishers.add(new Publisher("Penguine",pubs));
		publishers.add(new Publisher("Lucas",pubs2 ));
	   
	}

    @GetMapping("/publishers")
	public List<Publisher> findAll() {
		
		System.out.println("0=================================" +publishers);
		return publishers;
	}
	
	@RequestMapping("/publisheradd/{publishername}")
	public String addBooksOfPublisherToInventory(@PathVariable String publishername) {
		
		System.out.println("1=================================" + publishername);
		 Publisher p = publishers.stream().filter(it -> it.getName().equals(publishername)).findFirst().get();
		System.out.println("2=================================" + p);
		List<Book> books=p.getB();
		System.out.println("3=================================" + books);
         for(Book b: books)
         {
			 System.out.println("SENT: "+b);
	        inventoryClient.addBooks(b);
         }
		return "Books of publisher  "+publishername+" have been added to the book inventory service";
		//List<Book> l=inventoryClient.findAll();
	}
    
}
