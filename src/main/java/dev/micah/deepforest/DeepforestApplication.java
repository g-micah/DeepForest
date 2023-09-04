package dev.micah.deepforest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class DeepforestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DeepforestApplication.class, args);
		System.out.println("DeepForest Application Started.");
	}

//	@GetMapping("/*")
//	public String defaultGet() {
//		return "index.html";
//	}
	
//    @Bean
//    CommandLineRunner init(PostingRepository postingRepository) {
//        return args -> {
//            Stream.of("Post 1", "Post 2", "Post 3", "Post 4", "Post 5").forEach(title -> {
//                Posting posting = new Posting(title, "The content goes here.", true);
//                postingRepository.save(posting);
//            });
//        };
//    }
}
