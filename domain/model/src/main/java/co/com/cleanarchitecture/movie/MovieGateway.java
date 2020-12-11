package co.com.cleanarchitecture.movie;

import java.util.List;
import java.util.Optional;

public interface MovieGateway {
	
	public Optional<Movie> save(Movie movie);
	public Optional<Movie> get(String title);
	public List<Movie> gets();
}
