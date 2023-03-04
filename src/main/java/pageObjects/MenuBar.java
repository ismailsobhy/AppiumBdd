package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MenuBar {

	AndroidDriver<MobileElement> driver;
	
	public MenuBar(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	// Both movies and tv shows tab are common between favorites page and main page
	private By moviesTab = By.cssSelector("[content-desc='MOVIES']");
	private By tvShowsTab = By.cssSelector("[content-desc='TV SHOW']");
	protected By pageTitle = By.className("android.widget.TextView");
	// Back button appears only on the details page, but it is a menu bar item none
	// the less.
	private By backButton = By.cssSelector("[content-desc='Navigate up']");

	public void clickOnMoviesTab() {
		driver.findElement(moviesTab).click();
	}

	public void clickOnTvShowsTab() {
		driver.findElement(tvShowsTab).click();
	}

	public void verifyOnPageTitle(String title) {
		Assert.assertEquals(driver.findElements(this.pageTitle).get(0).getText(), title);
	}

	public void clickOnbackButton() {
		driver.findElement(backButton).click();
	}

}
