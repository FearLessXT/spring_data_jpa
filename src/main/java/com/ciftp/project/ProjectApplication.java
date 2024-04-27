package com.ciftp.project;

import com.ciftp.project.models.Author;
import com.ciftp.project.models.Video;
import com.ciftp.project.repositories.AuthorRepository;
import com.ciftp.project.repositories.VideoRepository;
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
//			var author = Author.builder()
//					.firstName("Jame")
//					.lastName("Doe")
//					.age(24)
//					.email("jame@doe.com")
//					.build();
//			author = repository.save(author);

			var video = Video.builder()
					.name("lesson1")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}
}
