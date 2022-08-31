package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class MovieInfoPage extends BaseClass {

	public MovieInfoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[contains(text(),'Wikipedia')]")
	private WebElement wikipediaLink;

	@FindBy(xpath = "//div[text()='Release date']//following::div[@class='plainlist']")
	private WebElement wikiReleaseDate;

	@FindBy(xpath = "//th[text()='Country']//following-sibling::td[@class='infobox-data']")
	private WebElement wikiOriginCountry;

	@FindBy(xpath = "//span[text()=' › title']//ancestor::a/h3")
	private WebElement imdpLink;

	@FindBy(xpath = "(//a[text()='Release date']//following::a[contains(@class,'ipc-metadata-list-item')])[1]")
	private WebElement imdpReleaseDate;

	@FindBy(xpath = "//li[@data-testid='title-details-origin']//following-sibling::div//a")
	private WebElement imdpOriginCountry;
	

	public WebElement getWikipediaLink() {
		return wikipediaLink;
	}

	public WebElement getImdpLink() {
		return imdpLink;
	}

	public WebElement getWikiReleaseDate() {
		return wikiReleaseDate;
	}

	public WebElement getWikiOriginCountry() {
		return wikiOriginCountry;
	}

	public WebElement getImdpReleaseDate() {
		return imdpReleaseDate;
	}
	

	public WebElement getImdpOriginCountry() {
		return imdpOriginCountry;
	}


}
