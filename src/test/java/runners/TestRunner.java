package runners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.DetailsPage;
import pageObjects.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
public class TestRunner {
    private AndroidDriver<MobileElement> driver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private Properties props = new Properties();

    @BeforeTest
    public void setDriver(){
    	try {
			props.load(new FileInputStream("config.properties"));
		} catch (Exception e) {
			System.out.println("Properties not loaded");
		} 
    	capabilities.setCapability("platformName",props.getProperty("platformName"));
        capabilities.setCapability("platformVersion",props.getProperty("platformVersion"));
        capabilities.setCapability("deviceName",props.getProperty("deviceName"));
        capabilities.setCapability("automationName",props.getProperty("automationName"));
        capabilities.setCapability("appPackage",props.getProperty("appPackage"));
        capabilities.setCapability("appActivity",props.getProperty("appActivity"));
        try {
        	driver = new AndroidDriver<MobileElement>(new URL(props.getProperty("url")), capabilities);
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    public void test() {
    	//MainPage mainPage=new MainPage(driver);
    	//DetailsPage detailsPage=new DetailsPage(driver);
    	//mainPage.clickOnMoviesTab();
    	//mainPage.clickOnSubItem("Puss in Boots: The Last Wish");
    	//detailsPage.verifyOnItemTitle("Puss in Boots: The Last Wish");
    	//detailsPage.clickOnAddToFavButton();
    	//page.clickOnFavButton();
    	//page.clickOnTvShowsTab();
    }
    @AfterTest
    public void tearDown(){
     //   driver.quit();
    }
    
    
}
    
    
