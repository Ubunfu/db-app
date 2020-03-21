package ninja.ryanallen.dbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class DbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbAppApplication.class, args);
	}

}
