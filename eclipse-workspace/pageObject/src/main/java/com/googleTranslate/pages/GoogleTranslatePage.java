package com.googleTranslate.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.googleTranslate.pageObject.BaseTest;

public class GoogleTranslatePage extends BaseTest {

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[2]/button/div[2]")
	WebElement sourceDropDown;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[3]/c-wiz/div[1]/div/div[2]/input")
	WebElement sourceSearch;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[5]/button/div[2]")
	WebElement translationDropDown;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[3]/c-wiz/div[2]/div/div[2]/input")
	WebElement translationSearch;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[1]/span/span/div/textarea")
	public WebElement sourceTextBox;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[2]/c-wiz[2]/div[5]/div/div[1]")
	public WebElement translateTextBox;

	@FindBy(xpath = "/html/body/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[3]/div/span/button")
	WebElement swapButton;

	@FindBy(xpath = "//*[@id=\"itamenu\"]/span/div/a[1]/span")
	WebElement keyBoardButton;

	@FindBy(xpath = "//*[@id=\"K72\"]")
	WebElement letterH;

	@FindBy(xpath = "//*[@id=\"K73\"]")
	WebElement letterI;

	public GoogleTranslatePage() {
		PageFactory.initElements(driver, this);
	}

	public void setupSourceNTargetLangs(String source, String translation, String initialText)
			throws InterruptedException {

		sourceDropDown.click();
		sourceSearch.sendKeys(source);
		sourceSearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		translationDropDown.click();
		translationSearch.sendKeys(translation);
		Thread.sleep(1000);
		translationSearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		sourceTextBox.sendKeys(initialText);

	}

	public String getTranslatedText() throws InterruptedException {
		Thread.sleep(1000);
		return translateTextBox.getText().trim();
	}
	
	public String getSourceText() throws InterruptedException {
		Thread.sleep(1000);
		return sourceTextBox.getText().trim();
	}

	public void ClickSwap() throws InterruptedException {
		Thread.sleep(1000);
		swapButton.click();
	}

	public void VerifyKeyboardInput() throws InterruptedException {
		sourceTextBox.clear();
		Thread.sleep(1000);
		keyBoardButton.click();
		Thread.sleep(1000);
		letterH.click();
		letterI.click();
	}
}
