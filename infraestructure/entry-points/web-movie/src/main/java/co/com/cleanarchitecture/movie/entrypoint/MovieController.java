package co.com.cleanarchitecture.movie.entrypoint;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cleanarchitecture.movie.Movie;
import co.com.cleanarchitecture.movie.usecase.MovieUsecase;

@RestController
@RequestMapping("/movies")
public class MovieController {
	private MovieUsecase movieUsecase;
	
	public MovieController(MovieUsecase movieUsecase) {
		this.movieUsecase = movieUsecase;
	}
	@GetMapping("/")
	public ResponseEntity<List<Movie>> movies() {
		return ResponseEntity.ok(movieUsecase.gets());
	}
	
	@PostMapping("/movie")
	public ResponseEntity<Movie> save(@RequestBody Movie movie) throws Exception {
		return ResponseEntity.ok(movieUsecase.save(movie));
	}
	
	@PostMapping("/")
	public ResponseEntity<Movie> get(@RequestBody Movie movie) throws Exception {
		return ResponseEntity.ok(movieUsecase.get(movie.getTitle()));
	}
}
