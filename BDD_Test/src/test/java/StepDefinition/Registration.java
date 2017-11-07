package StepDefinition;


import Function_library.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by srinivas on 28/09/2017.
 * This Stepdefinition for each steps
 * After this has run please check on target folder to see the report
 */
public class Registration {

    WebDriver driver;
    public String Emailid=null;

@Before
public void Browser(){
        String parentPath=System.getProperty("user.dir");
        String path=parentPath+"\\src\\test\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }


    @Given("^I am on \"(.*?)\" to register new account$")
    public void i_am_on_to_register_new_account(String arg1) throws Throwable {
        driver.get(arg1);
        new HomePage(driver).Click_CreateAccount();
    }

    @Given("^I enter email as \"(.*?)\"$")
    public void i_enter_email_as(String arg1) throws Throwable {
        Emailid=arg1;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterEmail(arg1);

        new HomePage(driver).clickContinue();
    }

    @Given("^I enter \"(.*?)\" as given name,\"(.*?)\" as first name,\"(.*?)\" as password$")
    public void i_enter_as_given_name_as_first_name_as_password(String Gname, String Fname, String pwd) throws Throwable {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement CheckEmail= driver.findElement(By.xpath("//div[@class='form-row']/p"));
        Assert.assertEquals(CheckEmail.getText(), Emailid);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterGivenName(Gname);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterFamilyName(Fname);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterPassword(pwd);

    }

    @When("^I click Register$")
    public void i_click_Register() throws Throwable {
        new HomePage(driver).ClickRegister();
    }

    @Then("^I should see \"(.*?)\" message$")
    public void i_should_see_message(String arg1) throws Throwable {
        WebElement CheckMessage=driver.findElement(By.xpath("//main[@id='maincontent']//h1[@class='els-flow-msg']"));
        Assert.assertEquals(arg1,CheckMessage.getText());
    }

    @After
    public void closeWebdriver(){
    driver.quit();
    }

    @And("^I enter \"([^\"]*)\"$")
    public void iEnter(String arg0) throws Throwable {
        Emailid=arg0;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterEmail(arg0);
        new HomePage(driver).clickContinue();
    }

    @And("^I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void iEnter(String arg0, String arg1, String arg2) throws Throwable {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement CheckEmail= driver.findElement(By.xpath("//div[@class='form-row']/p"));
        Assert.assertEquals(CheckEmail.getText(), Emailid);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterGivenName(arg0);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterFamilyName(arg1);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        new HomePage(driver).EnterPassword(arg2);
    }
}
