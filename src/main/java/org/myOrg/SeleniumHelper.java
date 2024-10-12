package org.myorg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    WebDriver webDriver;
    WebDriverWait wait;
    public SeleniumHelper(WebDriver webDriver, int waitSeconds) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(waitSeconds));
    }
    public void waitForMilis(int miliseconds)
    {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement waitForElementToBeClickable(String xpath)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public WebElement waitForElementToBeClickable(String xpath, int waitTime)
    {
        WebDriverWait tempWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(waitTime));
        return tempWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public WebElement getElementByXpath(String xpath)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getElementByXpath(String xpath, int waitTime)
    {
        WebDriverWait tempWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(waitTime));
        return tempWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
