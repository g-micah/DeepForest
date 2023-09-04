package dev.micah.deepforest.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.micah.deepforest.entity.Posting;

@Repository
public interface PostingRepository extends CrudRepository<Posting, Long> {
	
}
