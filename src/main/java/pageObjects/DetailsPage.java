package pageObjects;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class DetailsPage{

	AndroidDriver<MobileElement> driver;
	
	public DetailsPage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
	}

	private By toast = By.xpath("//android.widget.Toast[1]");
	
	private By addToFavButton = MobileBy
			.AndroidUIAutomator("new UiSelector().resourceId(\"id.ihwan.jetpackpro.debug:id/favorite_button\")");
	
	public void clickOnAddToFavButton() {
		driver.findElement(addToFavButton).click();
		// Verify toast text and the item has been added to favorites
		Assert.assertEquals(driver.findElement(this.toast).getText(), "Added To Favorite!");
		
	}

	
}
