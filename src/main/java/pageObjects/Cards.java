package pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Cards {

	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	public Cards(AndroidDriver<MobileElement> driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait=wait;
	}

	private By movieCards = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\")");
	private String movieCardByText="new UiSelector().textContains(\"_title_\")";
	// Clicks on Movie or TV show
	public void clickOnSubItem(String title) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.AndroidUIAutomator(movieCardByText.replace("_title_",title)))));
		driver.findElement(MobileBy.AndroidUIAutomator(movieCardByText.replace("_title_",title))).click();
	}
	
	public void checkCardQuantity(int size) {
		// Before count, wait
		List<MobileElement> elems=driver.findElements(movieCards);
	 	Assert.assertEquals(elems.size(),size);
	}
	
	public void checkCardPresence(String title,boolean expected) {
		boolean actual=false;
		try {
			 driver.findElement(MobileBy.AndroidUIAutomator(movieCardByText.replace("_title_",title)));
			 actual=true;
		 }catch(Exception e){
		 }
		assertEquals(actual, expected);
		 
	}

	

}