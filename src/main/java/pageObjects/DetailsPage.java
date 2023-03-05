package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class DetailsPage{

	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	public DetailsPage(AndroidDriver<MobileElement> driver,WebDriverWait wait){
		this.driver=driver;
		this.wait=wait;
	}
	// it appears only on the details page
	private By toast = By.xpath("//android.widget.Toast[1]");
	
	private By favButton = MobileBy
			.AndroidUIAutomator("new UiSelector().resourceId(\"id.ihwan.jetpackpro.debug:id/favorite_button\")");
	
	public void clickOnFavButton(){
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(favButton)));
		driver.findElement(favButton).click();	
	}
	
	public void verifyAddedToFavToast(){
		// Verify toast text and the item has been added to favorites
		Assert.assertEquals(driver.findElement(this.toast).getText(), "Added To Favorite!");
		
	}
	
	public void verifyDeletedFromFavToast(){
		// Verify toast text and the item has been deleted from favorites
		Assert.assertEquals(driver.findElement(this.toast).getText(), "Deleted From Favorite!");
	}

	
}
