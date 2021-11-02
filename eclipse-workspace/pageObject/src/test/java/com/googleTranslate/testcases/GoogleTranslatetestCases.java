package com.googleTranslate.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.googleTranslate.pageObject.BaseTest;
import com.googleTranslate.pageObject.Utils;
import com.googleTranslate.pages.GoogleTranslatePage;

public class GoogleTranslatetestCases extends BaseTest {

	Utils utils;
	String sheetName = "Sheet1";

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		utils = new Utils();
	}

	@DataProvider
	public Object[][] getGoogleTranslateTestData() {
		Object data[][] = Utils.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getGoogleTranslateTestData")
	public void verifyTranslationLanguage(String source, String translation, String initialText, String expected)
			throws InterruptedException {
		GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();
		googleTranslatePage.setupSourceNTargetLangs(source, translation, initialText);
		String actual = googleTranslatePage.getTranslatedText();
		Assert.assertEquals(actual, expected);

	}

	@Test(priority = 2)
	public void verfiySwap() throws InterruptedException {

		GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();
		googleTranslatePage.ClickSwap();
		String actualResult = googleTranslatePage.getTranslatedText();
		Assert.assertEquals(actualResult, "Hello");

	}

	@Test(priority = 3)
	public void verifyKeyBoardInput() throws InterruptedException {
		GoogleTranslatePage googleTranslatePage = new GoogleTranslatePage();
		googleTranslatePage.VerifyKeyboardInput();
		String actual = googleTranslatePage.getTranslatedText();

		Assert.assertEquals(actual, "hi");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
