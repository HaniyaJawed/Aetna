package rapNameTests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;


public class SampleTest extends BaseTest {

    @Test(description = "This test is to cover scenarios for the coding challenge")
    public void myRapNameTest(){

        HomePageEvents homePageEvents = new HomePageEvents();
        homePageEvents.webPageAvailable();
        logger.log(Status.PASS, "WebPage is Available");

        homePageEvents.inputFieldExist();
        logger.log(Status.PASS, "Input field Exist");

        homePageEvents.inputFieldNegativeScenario();
        logger.log(Status.PASS, "Negative Scenario passing special character --&-- is passed");

        homePageEvents.submitMale();
        logger.log(Status.PASS, "Added Male Rap Name Without Last Initials");

        homePageEvents.submitFemaleOne();
        logger.log(Status.PASS, "Successfully Added First Female Rap Name With Last Initials");

        homePageEvents.submitFemaleTwo();
        logger.log(Status.PASS, "Successfully Added Second Female Rap Name With Last Initials ");
    }

}
