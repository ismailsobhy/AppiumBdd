package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MenuBar {

	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	public MenuBar(AndroidDriver<MobileElement> driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait=wait;
	}

	// Both movies and tv shows tab are common between favorites page and main page
	private By moviesTab = By.cssSelector("[content-desc='MOVIES']");
	private By tvShowsTab = By.cssSelector("[content-desc='TV SHOW']");
	private By pageTitle = By.className("android.widget.TextView");
	// Back button appears only when on the details page, but it is a menu bar item none
	// the less.
	private By backButton = By.cssSelector("[content-desc='Navigate up']");
	private By showFavoriteButton = By.cssSelector("[content-desc='Favorite']");

	public void clickOnMoviesTab() {
		driver.findElement(moviesTab).click();
	}

	public void clickOnTvShowsTab() {
		driver.findElement(tvShowsTab).click();
	}

	public void verifyOnPageTitle(String title) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(driver.findElement(this.pageTitle))));
		Assert.assertEquals(driver.findElements(this.pageTitle).get(0).getText(), title);
	}

	public void clickOnbackButton() {
		driver.findElement(backButton).click();
		
	}
	
	public void clickOnShowFavButton() {
		MobileElement element=driver.findElement(showFavoriteButton);
		element.click();
	}
}
