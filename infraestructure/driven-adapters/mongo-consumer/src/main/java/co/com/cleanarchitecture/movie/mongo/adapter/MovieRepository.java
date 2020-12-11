package co.com.cleanarchitecture.movie.mongo.adapter;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.cleanarchitecture.movie.mongo.adapter.entity.MovieDB;

@Repository
public interface MovieRepository extends MongoRepository<MovieDB, String>{
	public Optional<MovieDB> findByTitle(String title);
}
