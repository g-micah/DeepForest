package dev.micah.deepforest.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.micah.deepforest.entity.Posting;
import dev.micah.deepforest.repository.PostingRepository;

@RestController
@ApiPrefixController
@CrossOrigin
public class PostingController {
	
	private final PostingRepository postingRepository;
	
	PostingController(PostingRepository repository) {
		this.postingRepository = repository;
	}
	
	@GetMapping("/postings")
	public List<Posting> getAllPostings() {
		List<Posting> postings = (List<Posting>) postingRepository.findAll();
		return postings;
	}
	
	@GetMapping("/postings/{id}")
	public Posting getPosting(@PathVariable("id") long id) throws Exception {
		return postingRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/postings")
	void addPosting(@RequestBody Posting posting) {
		posting.setLastModified(LocalDateTime.now());
		postingRepository.save(posting);
	}
	
	@PutMapping("/postings/{id}")
	void editPosting(@RequestBody Posting posting, @PathVariable("id") long id) {
		if(!postingRepository.existsById(id)) {
			return;
		}
		posting.setId(id);
		posting.setLastModified(LocalDateTime.now());
		postingRepository.save(posting);
	}
	
	@DeleteMapping("/postings/{id}")
	void deletePosting(@PathVariable("id") long id) {
		System.out.println("delete"+id);
		postingRepository.deleteById(id);
	}
}
