package co.com.cleanarchitecture.movie.usecase;

import java.util.List;
import java.util.Optional;

import co.com.cleanarchitecture.movie.Movie;
import co.com.cleanarchitecture.movie.MovieGateway;

public class MovieUsecase {
	private MovieGateway movieGateway;
	
	public MovieUsecase(MovieGateway movieGateway) {
		this.movieGateway = movieGateway;
	}
	
	public Movie save(Movie movie) throws Exception {
	    Optional<Movie> movieRS = movieGateway.save(movie);
	    if (movieRS.isPresent()) {
	    	return movieRS.get();
	    }
	    throw new Exception("Ocurrio un error al intentar registrar la pelicula");
	}
	
	public List<Movie> gets() {
		return movieGateway.gets();
	}
	
	public Movie get(String titulo) throws Exception {
		Optional<Movie> movieRS = movieGateway.get(titulo);
		if (movieRS.isPresent()) {
			return movieRS.get();
		}
		throw new Exception("No se encontro peliculas con el titulo "+ titulo);
		
	}
}
