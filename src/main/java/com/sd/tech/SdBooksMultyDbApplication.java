package com.sd.tech;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.tech.dao.BookMysqlRepo;
import com.sd.tech.model.Book;

@SpringBootApplication
@RestController
@RequestMapping("book")
public class SdBooksMultyDbApplication {
	
	/*
	 * @Autowired private BookRepo bookRepo;
	 */
	
	@Autowired
	private BookMysqlRepo bookMysqlRepo;
	
	/*
	 * @PostMapping public Books saveBook(@RequestBody Books book) { return
	 * bookRepo.save(book); }
	 */

	@PostMapping("mysql")
	public Book  saveBookInMysql(@RequestBody Book book)
	{
		return bookMysqlRepo.saveAndFlush(book);
	}
	
	/*
	 * @GetMapping public List<Books> getBooks() { return bookRepo.findAll(); }
	 */
	
	@GetMapping("mysql")
	public List<Book>  getBooksMysql()
	{
		return bookMysqlRepo.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SdBooksMultyDbApplication.class, args);
		System.out.println("sample url: http://localhost:9009/book/mysql");
		System.out.println("sample url for mongo db : http://localhost:9009/book");

	}

}
