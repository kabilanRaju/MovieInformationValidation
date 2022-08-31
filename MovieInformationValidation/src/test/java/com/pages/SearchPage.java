package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchPage extends BaseClass {

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath = "	//div[@class='FPdoLc lJ9FBc']//child::input[@value='Google Search']\r\n")
	private WebElement googleSearchBtn;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getGoogleSearchBtn() {
		return googleSearchBtn;
	}

//	public void search() throws IOException {
//
//		Type(getSearchBox(), getPropertyFile("moviename"));
//		clickjavascriptexecutor(getGoogleSearchBtn());
//
//	}

}
