package co.com.cleanarchitecture.movie.mongo.adapter.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class MovieDB {
	
	@Id
	private String id;
	private String title;
	private String year;

	public MovieDB() {
		
	}
	
	public MovieDB(String title, String year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}
	
	
}
