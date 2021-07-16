package rapNameTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Properties;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reports"+ File.separator + "AutomationReportsAetna.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("AutomationReport Aetna");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Automation Tester for Project" ,"Hanyia Jawed");
    }

    @BeforeMethod
    public void beforeMethodMethod( Method testMethod){
        logger = extentReports.createTest(testMethod.getName());
        setUpDriver(Properties.browserName);
        driver.get(Properties.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result){
        if(result.getStatus()== ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed ";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        } else if (result.getStatus()== ITestResult.FAILURE){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed ";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.PASS,m);
        }
        driver.quit();

    }

    @AfterTest
    public void afterTestMethod(){
        extentReports.flush();
    }

    public void setUpDriver(String browserName){
    	
    	if (System.getProperty("os.name").toLowerCase().equalsIgnoreCase("Windows 10")) {
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"+ File.separator + "/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "/geckodriver.exe");
                driver = new FirefoxDriver();
            }
    	} else {
            if(browserName.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"+ File.separator + "/chromedriver");
                driver = new ChromeDriver();
            }
            else if(browserName.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "/geckodriver");
                driver = new FirefoxDriver();
            }
    	}   

    }
}
