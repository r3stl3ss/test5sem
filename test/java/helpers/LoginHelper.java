package helpers;

import dtos.AccountData;
import managers.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;


public class LoginHelper extends HelperBase {

    Actions actions = new Actions(driver);

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void LogIn(AccountData user) {
        driver.findElement(By.xpath("//input[@type='email']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).clear();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(user.getUsername());
        driver.findElement(By.xpath("//input[@type='password']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//div[@id='login']/section/div/div/form/div[2]/button")).click();
    }

    public byte findOptionsButton() {
        List<WebElement> buttons = driver.findElements(cssSelector(".options-button-wrapper.is-medium.is-clickable"));
        return (byte) buttons.size();
    }


    public void logOut() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//div[@id='header']/nav/div[3]/div[2]/div/a/span"))).perform();
        driver.findElement(By.xpath("//div[@id='header']/nav/div[3]/div[2]/div/div/a[3]")).click();
    }

}
