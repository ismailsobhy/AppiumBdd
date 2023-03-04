package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainPage {

	AndroidDriver<MobileElement> driver;

	public MainPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	private By movieCard = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\")");
	private By showFavoriteButton = By.cssSelector("[content-desc='Favorite']");

	// Clicks on Movie or TV show
	public void clickOnSubItem(String title) {
		WebElement element = driver.findElement(movieCard);
		element.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + title + "\")")).click();
	}

	public void clickOnShowFavButton() {
		driver.findElement(showFavoriteButton).click();
	}

}
