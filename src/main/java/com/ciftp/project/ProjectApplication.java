package com.ciftp.project;

import com.ciftp.project.models.Author;
import com.ciftp.project.models.Video;
import com.ciftp.project.repositories.AuthorRepository;
import com.ciftp.project.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			for (int i = 0; i < 20; i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20, 40))
						.email(faker.name().firstName() + faker.name().lastName() + "@gmail.com")
						.build();
				author = repository.save(author);
			}

			var video = Video.builder()
					.name("lesson1")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}
}
