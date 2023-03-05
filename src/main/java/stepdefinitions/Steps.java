package stepdefinitions;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageobjects.Cards;
import pageobjects.DetailsPage;
import pageobjects.MenuBar;


/**
 * @author Ismail.Sobhy
 *
 */
public class Steps {
	
	private AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private Properties props = new Properties();
	Cards cards;
	MenuBar menuBar;
	DetailsPage detailsPage;
	@Before
	public void setup(){
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
        	this.driver = new AndroidDriver<MobileElement>(new URL(props.getProperty("url")), capabilities);
        	this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
        	System.out.print("problem with loading capabilities to driver");
        }
        this.wait= new WebDriverWait(this.driver, 10);    ;
    	
        
        cards= new Cards(this.driver,this.wait);
        menuBar= new MenuBar(this.driver,this.wait);
        detailsPage = new DetailsPage(this.driver,this.wait);
    }
	
	@Given("^User is on main page$")
	public void verifyMovieCatalogueTitle(){
		menuBar.verifyOnPageTitle("Movie Catalogue");
	}
	
	@When("^User wants to see \"(.*)\" list$")
	public void showMoviesList(String type){
		if(type.toLowerCase().equals("movies"))
			menuBar.clickOnMoviesTab();
		else if(type.toLowerCase().equals("tv"))
			menuBar.clickOnTvShowsTab();
	}
	
	@When("^User wants to see tv shows list$")
	public void showTvShowsList(){
		menuBar.clickOnTvShowsTab();
	}
	
	@And("^User selects card with \"(.*)\" title$")
	public void userSelectSubItem(String title){
		cards.clickOnSubItem(title);
	}
	
	@And("^User sees page \"(.*)\" title$")
	public void userGoesToPage(String title){
		menuBar.verifyOnPageTitle(title);
	}
	
	@And("^User adds item to favorites$")
	public void addToFav(){ 
		detailsPage.clickOnFavButton();
	}
	
	@And("^User removes item from favorites$")
	public void removeFromFav(){
		detailsPage.clickOnFavButton();
	}
	
	@When("^User clicks back$")
	public void clickBack() {
		menuBar.clickOnbackButton();
	}
	
	@Then("^User finds added to favorite confirmation")
	public void favoriteToast(){
		detailsPage.verifyAddedToFavToast();
	}
	
	@Then("^User finds removed from favorite confirmation")
	public void favoriteRemovedToast(){
		detailsPage.verifyDeletedFromFavToast();
	}
	
	@Then("^User find \"(.*)\" items$")
	public void checkCount(int count){
		cards.checkCardQuantity(count);
	}
	
	@When("^User go to favorites page$")
	public void goToFavs() {
		menuBar.clickOnShowFavButton();
	}
	
	@After
	public void tearDown(){
		this.driver.quit();
	}
	
}