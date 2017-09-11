package guru.springframework.couchbasedbexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "guru.springframework.couchbasedbexample")
public class CouchbasedbexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchbasedbexampleApplication.class, args);
	}

}
