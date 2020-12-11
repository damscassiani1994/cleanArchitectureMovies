package co.com.cleanarchitecture.movie;

public class Movie {
	
	private String title;
	private String year;
	
	public Movie() {
		
	}
	
	public Movie withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Movie withYear(String year) {
		this.year = year;
		return this;
	}
	
	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public Movie build() {
		return this;
	}
}
