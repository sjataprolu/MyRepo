package Function_library;
/**
 * Created by srinivas on 29/09/2017.
 * This is pageFactory where we store all elements
 */
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by srinivas on 28/09/2017.
 * Elements of the home page that you get when you launch www.mendeley.com
 */

public class HomePage {

    WebDriver driver;

    @FindBy(xpath="//li[@class='with-divider']/a")
    private WebElement CreateFreeAccountButton;
    @FindBy(id = "email")
    private WebElement Email_textbox;
    @FindBy(id = "els-continue")
    private WebElement Continue_button;
    @FindBy(id="givenName")
    private WebElement GivenName;
    @FindBy(id="familyName")
    private WebElement FamilyName;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(xpath = "//button[@class='els-primaryBtn']")
    private WebElement RegisterButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void Click_CreateAccount() throws Throwable{
//        List<WebElement> button=driver.findElements(By.xpath("//div[contains(@id, 'slick-slide0')]//a[contains(text(), 'Create a free account')]"));
//        Actions builder=new Actions(driver);
//        builder.moveToElement(button.get(1)).build().perform();
//        button.get(0).click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(CreateFreeAccountButton));
        CreateFreeAccountButton.click();
    }

    public void EnterEmail(String emaild) throws Throwable{
        try{
            if(Email_textbox.isDisplayed()){
                Email_textbox.sendKeys(emaild);
            }
        }catch (NoSuchElementException e) {
            System.out.println("Email text box is not displayed");
        }
    }

    public void clickContinue() throws Throwable{
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(Continue_button));
        Continue_button.click();
    }

    public void EnterGivenName(String Gname) throws Throwable{
        GivenName.sendKeys(Gname);
    }

    public void EnterFamilyName(String FName) throws Throwable{
        FamilyName.sendKeys(FName);
    }

    public void EnterPassword(String PWD) throws Throwable{
        password.sendKeys(PWD);
    }

    public void ClickRegister() throws Throwable{
        RegisterButton.click();
    }
}
