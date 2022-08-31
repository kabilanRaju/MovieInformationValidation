package com.pagemanager;

import com.pages.MovieInfoPage;
import com.pages.SearchPage;

public class PageObjectManager {

	private  SearchPage searchpage;
	private MovieInfoPage movieInfoPage;
	
	public SearchPage getSearchpage() {
		return (searchpage==null)?searchpage=new SearchPage():searchpage;
	}
	public MovieInfoPage getMovieInfoPage() {
		return (movieInfoPage==null)?movieInfoPage=new MovieInfoPage():movieInfoPage;
	}
	
	
}
