package com.googlemaps.Pages;

import org.openqa.selenium.support.PageFactory;

import com.googlemaps.Objects.SearchObjects;

import com.googlemaps.appframe.CommonMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage  extends CommonMethods{
	public SearchObjects searchObject = new SearchObjects();
	
	public SearchPage(AppiumDriver<MobileElement> driver) {
		
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), searchObject);
	 }
	
	public SearchPage enterText() throws InterruptedException {
		
		waitAndClickOnElement(searchObject.txtbox_searchBox, "Searchbox", 10);
		//waitAndTypeOnTextField(searchObject.txtbox_editBox, "Nikola Bar-buffe","SearchBox", 10);
		typeByCharacter(searchObject.txtbox_editBox, "Nikola Bar-buffe");
		
		
		return this;
		
	}

}
