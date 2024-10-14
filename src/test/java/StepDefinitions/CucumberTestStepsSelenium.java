package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.myorg.SeleniumHelper;
import org.myorg.xpathPackage.GoogleXpaths;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class CucumberTestStepsSelenium {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private SeleniumHelper seleniumHelper;


    @Before("@seleniumFeature")
    public void testStart(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        seleniumHelper = new SeleniumHelper(webDriver, 5);
    }

    @After("@seleniumFeature")
    public void testQuit(){
        webDriver.quit();
    }

    @Given("^Go to (.*) website$")
    public void goToWebsite(String url) {
        webDriver.get(url);
    }

    @When("^Search for (.*) in google$")
    public void searchForTextInGoogle(String text) {
        WebElement disagreeEl = seleniumHelper.waitForElementToBeClickable(GoogleXpaths.disagreeGoogleXpath);
        disagreeEl.click();
        WebElement searchField = seleniumHelper.getElementByXpath(GoogleXpaths.searchFieldXpath);
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
    }

    @Then("^Check if first result is page (.*)$")
    public void checkFirstResult(String expectedPage) {
        seleniumHelper.getElementByXpath(GoogleXpaths.firstResultXpath + "//*[contains(text(),'" + expectedPage + "')]");
    }

    @Then("^Click on first result$")
    public void clickFirstResult() {
        WebElement firstElement = seleniumHelper.waitForElementToBeClickable(GoogleXpaths.firstResultXpath);
        firstElement.click();
    }

    @When("^Wait for (.*) seconds$")
    public void waitForSeconds(int seconds) {
        seleniumHelper.waitForMilis(seconds*1000);
    }

    @When("^We search for (.*) on youtube$")
    public void searchOnYoutube(String text) {
        seleniumHelper.waitForElementToBeClickable(GoogleXpaths.disagreeYoutubeXpath).click();
        seleniumHelper.waitForMilis(1500);
        WebElement searchField = seleniumHelper.waitForElementToBeClickable(GoogleXpaths.youtubeSearchFieldXpath);
        searchField.click();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.RETURN);
    }

    @When("^Filter youtube videos by (.*)$")
    public void filterYoutubeVideos(String filterName) {
        seleniumHelper.waitForElementToBeClickable(GoogleXpaths.youtubeSearchFilterXpath).click();
        seleniumHelper.waitForElementToBeClickable(GoogleXpaths.ytSortByXpath(filterName)).click();
        seleniumHelper.waitForMilis(1000);
    }

    @Then("^Check if (.*). result is from (.*)$")
    public void checkResult(int index, String channelName) {
        List<WebElement> videos = webDriver.findElements(By.xpath(GoogleXpaths.videosOnPageXpath));
        if (index<1 || index>(videos.size()+1))
            assertFalse( "first page does not contain " + index + " videos!", true);
        WebElement videoEl = seleniumHelper.getElementByXpath(GoogleXpaths.ytVidChannelXpath(index));
        assertEquals("Incorrect video channel!", channelName, videoEl.getText());
    }

    @Then("^Check if (.*). video title contains (.*)$")
    public void checkTitle(int index, String videoTitle) {
        List<WebElement> videos = webDriver.findElements(By.xpath(GoogleXpaths.videosOnPageXpath));
        if (index<1 || index>(videos.size()+1))
            assertFalse( "first page does not contain " + index + " videos!", true);
        String titleXpath = GoogleXpaths.ytVideoTitleXpath(index);
        WebElement videoEl = seleniumHelper.getElementByXpath(titleXpath);
        String actualTitle = videoEl.getAttribute("title");
        assertTrue(index + ". title xpath: \"" + titleXpath + "\"\nActual title: \"" + actualTitle
                        + "\"\nDoes not contain text: \"" + videoTitle + "\"", actualTitle.contains(videoTitle));
    }
}
