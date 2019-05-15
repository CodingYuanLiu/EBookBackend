package com.Ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class EbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner demo(BookinfoRepository repository) {
		return(args) -> {
			repository.save(new Bookinfo("深入理解计算机基础","Bryant,Hallaron",
					"/static/images/icsimage.jpg","128￥","details/book1",10,1));
			repository.save(new Bookinfo("明朝那些事儿","当年明月",
					"/static/images/mingdynasty.jpg","68￥","details/book2",11,4));
			repository.save(new Bookinfo("book3","author3",
					"/static/images/book.jpg","78￥","",41,2));
		};
	}
	*/
	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/scanning").allowedOrigins("http://localhost:8081");
				registry.addMapping("/checkdupusername").allowedOrigins("http://localhost:8081");
			}
		};
	}
*/
}
