package com.example.microbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/books")
public class MicroBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroBookServiceApplication.class, args);
	}

	private List<Book> bookList = Arrays.asList(
			new Book(1L, "Baeldung goes to the market","Tim schimandle"),
			new Book(2L, "Baeldung goes to the park","Slavisa")
	);

	@GetMapping("")
	public List<Book> findAllBooks() {
		return bookList;
	}

	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable(value = "bookId") Long bookId){
		return bookList.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
	}

}
