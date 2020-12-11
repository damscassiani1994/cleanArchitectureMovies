package co.com.cleanarchitecture;	

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.cleanarchitecture.movie.MovieGateway;
import co.com.cleanarchitecture.movie.usecase.MovieUsecase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	public MovieUsecase movieUsecase(MovieGateway movieGateway) {
		return new MovieUsecase(movieGateway);
	}
}
