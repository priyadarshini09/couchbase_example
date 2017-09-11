package guru.springframework.couchbasedbexample;

import java.util.UUID;

import guru.springframework.couchbasedbexample.domain.User;
import guru.springframework.couchbasedbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouchbasedbexampleApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CouchbasedbexampleApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		this.userRepository.deleteAll();
		User user = saveUser();
		System.out.println(this.userRepository.findOne(user.getId()));
	}

	private User saveUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setFirstName("Alice");
		user.setLastName("Smith");
		return this.userRepository.save(user);
	}
}
