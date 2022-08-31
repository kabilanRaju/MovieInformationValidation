package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MovieInformationStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	String wikipediaReleaseDate;
	String wikipediaOriginCountry;

	@Given("User should enter the movie name in google search page")
	public void userShouldEnterTheMovieNameInGoogleSearchPage() throws IOException {

		Type(pom.getSearchpage().getSearchBox(), getPropertyFile("moviename"));
		clickJavascriptExecutor(pom.getSearchpage().getGoogleSearchBtn());
	}

	@When("User should click on wikipedia and imdp links then fetch date and country")
	public void userShouldClickOnWikipediaAndImdpLinksThenFetchDateAndCountry() throws IOException {

		click(pom.getMovieInfoPage().getWikipediaLink());

		wikipediaReleaseDate = getText(pom.getMovieInfoPage().getWikiReleaseDate());
		System.out.println("WikipediaMovieInformation");
		System.out.println("Release date " + wikipediaReleaseDate);
		wikipediaOriginCountry = getText(pom.getMovieInfoPage().getWikiOriginCountry());
		System.out.println("Country " + wikipediaOriginCountry);
		scrollDownJs(pom.getMovieInfoPage().getWikiReleaseDate());
		screenshot(getPropertyFile("website1"));

	}

	@Then("User should compare the data using Assert.")
	public void userShouldCompareTheDataUsingAssert() throws IOException {

		back();
		click(pom.getMovieInfoPage().getImdpLink());
		String imdpReleaseDate = getText(pom.getMovieInfoPage().getImdpReleaseDate());
		System.out.println("ImdpMovieInformation");
		System.out.println("Release date " + imdpReleaseDate);
		String imdpOriginCountry = getText(pom.getMovieInfoPage().getImdpOriginCountry());
		System.out.println("Country of origin " + imdpOriginCountry);
		scrollDownJs(pom.getMovieInfoPage().getImdpReleaseDate());
		screenshot(getPropertyFile("website2"));

		String imdpMovieReleaseDate = simpleDateFormat(imdpReleaseDate);
		String wikipediaMovieReleaseDate = simpleDateFormat(wikipediaReleaseDate);

		 boolean releaseDate = imdpMovieReleaseDate.contains(wikipediaMovieReleaseDate);
		boolean releaseCountry = wikipediaOriginCountry.equals(imdpOriginCountry);

		 Assert.assertTrue("movieReleaseDate", releaseDate);
		Assert.assertTrue("movieReleaseCountry", releaseCountry);

	}

}













