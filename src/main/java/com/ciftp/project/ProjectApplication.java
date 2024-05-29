package com.ciftp.project;

import com.ciftp.project.models.Author;
import com.ciftp.project.models.Video;
import com.ciftp.project.repositories.AuthorRepository;
import com.ciftp.project.repositories.VideoRepository;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	) {
		return args -> {
			// You can command the below code when the first run is done.
//			for (int i = 0; i < 20; i++) {
//				Faker faker = new Faker();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//				var author = Author.builder()
//						.firstName(faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age(faker.number().numberBetween(20, 40))
//						.email(faker.name().firstName() + faker.name().lastName() + "@gmail.com")
//						.createdAt(LocalDateTime.now())
//						.build();
//				author = repository.save(author);
//			}

		};
	}
}
