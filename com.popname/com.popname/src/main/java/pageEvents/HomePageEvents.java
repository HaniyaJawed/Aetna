package pageEvents;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import pageObjects.HomePageElements;
import rapNameTests.BaseTest;
import utilities.ElementFetch;
import utilities.Properties;

public class HomePageEvents extends BaseTest {

    public void webPageAvailable(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getWebElement("NAME", HomePageElements.rapMap).isDisplayed());
    }

    public void inputFieldExist(){
        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getWebElement("NAME", HomePageElements.firstName).isDisplayed());
    }

    public void inputFieldNegativeScenario(){
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).clear();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).sendKeys(Properties.specialCharacter);
        elementFetch.getWebElement("NAME", HomePageElements.submitMaleButton).click();
        Assert.assertEquals(elementFetch.getWebElement("XPATH", HomePageElements.errorMessage).getText(), "You must enter your first name."); ;

    }
    public void submitMale() {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).clear();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).sendKeys(Properties.maleFirstName);
        elementFetch.getWebElement("NAME", HomePageElements.submitMaleButton).click();
        String RapNameGenerated = elementFetch.getListWebElement("XPATH", HomePageElements.TableEntry).getText();
        Assert.assertTrue(RapNameGenerated.length()>0 );
        logger.log(Status.PASS,"Male Rap Name Generated is " + RapNameGenerated );
    }

    public void submitFemaleOne() {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).clear();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).sendKeys(Properties.firstFemaleFirstName);
        elementFetch.getWebElement("NAME", HomePageElements.lastinitial).sendKeys(Properties.firstFemaleLastInitial);
        elementFetch.getWebElement("NAME", HomePageElements.submitFemaleButton).click();
        String RapNameGenerated = elementFetch.getListWebElement("XPATH", HomePageElements.TableEntry).getText();
        Assert.assertTrue(RapNameGenerated.length()>0 );
        logger.log(Status.PASS,"First Female Rap Name Generated is " +RapNameGenerated );

    }

    public void submitFemaleTwo() {
        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).clear();
        elementFetch.getWebElement("NAME", HomePageElements.firstName).sendKeys(Properties.secondFemaleFirstName);
        elementFetch.getWebElement("NAME", HomePageElements.lastinitial).sendKeys(Properties.secondFemaleLastInitial);
        elementFetch.getWebElement("NAME", HomePageElements.submitFemaleButton).click();
        String RapNameGenerated = elementFetch.getListWebElement("XPATH", HomePageElements.TableEntry).getText();
        Assert.assertTrue(RapNameGenerated.length()>0 );
        logger.log(Status.PASS, "Second Female Rap Name Generated is " +RapNameGenerated );

    }
}
