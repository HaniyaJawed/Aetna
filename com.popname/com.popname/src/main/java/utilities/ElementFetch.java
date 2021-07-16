package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import rapNameTests.BaseTest;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue){
        switch(identifierType){
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "NAME":
                return BaseTest.driver.findElement(By.name(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            default:
                return null;

        }
    }

    public WebElement getListWebElement(String identifierType, String identifierValue){
        switch(identifierType){
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "NAME":
                return BaseTest.driver.findElement(By.name(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            default:
                return null;

        }
    }
}
