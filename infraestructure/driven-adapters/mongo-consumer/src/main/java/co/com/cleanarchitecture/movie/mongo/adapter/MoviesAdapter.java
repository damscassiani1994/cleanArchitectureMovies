package co.com.cleanarchitecture.movie.mongo.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.com.cleanarchitecture.movie.Movie;
import co.com.cleanarchitecture.movie.MovieGateway;
import co.com.cleanarchitecture.movie.mongo.adapter.entity.MovieDB;

@Component
public class MoviesAdapter implements MovieGateway{
	
	private MovieRepository movieRepository;
	
	public MoviesAdapter(MovieRepository moviRepository) {
		this.movieRepository = moviRepository;
	}

	@Override
	public Optional<Movie> save(Movie movie) {
		MovieDB movieDB = movieRepository.save(new MovieDB(movie.getTitle(), movie.getYear()));
		return Optional.of(new Movie().withTitle(movieDB.getTitle()).withYear(movieDB.getYear()).build());
	}

	@Override
	public Optional<Movie> get(String title) {
		Optional<MovieDB> movieDB = movieRepository.findByTitle(title);
		if (movieDB.isPresent()) return Optional.of(new Movie().withTitle(movieDB.get().getTitle())
				.withYear(movieDB.get().getYear()).build());
		
		return Optional.empty();
	}

	@Override
	public List<Movie> gets() {
		return movieRepository.findAll().stream()
				.map(movie -> new Movie().withTitle(movie.getTitle()).withYear(movie.getYear()).build())
				.collect(Collectors.toList());
	}

}
