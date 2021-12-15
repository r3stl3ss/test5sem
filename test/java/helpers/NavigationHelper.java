package helpers;

import managers.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager applicationManager)  {
        super(applicationManager);
    }

    public void OpenLoginPage() {
        driver.findElement(By.xpath("//div[@id='header']/nav/div[3]/div[2]/div/div/a")).click();
    }

    public void OpenTestableSite() {
        driver.get("https://strawpoll.com/en/");
    }

    public void openPollCreatePage() {
        driver.get("https://strawpoll.com/account/dashboard");
        driver.findElement(By.xpath("//div[@id='header']/nav/div[3]/div/a")).click();
    }


    public void openPollPage() {
        driver.get("https://strawpoll.com/account/dashboard");
        List<WebElement> polls = driver.findElements(By.className("break-word"));
        polls.get(0).click();
    }

    public void openProfilePage() {
        driver.get("https://strawpoll.com/account/dashboard");
    }

    public void deletePoll() {
        driver.findElement(By.cssSelector(".options-button.is-clickable")).click();
        List<WebElement> elements = driver.findElements(By.className("media-content"));
        elements.get(4).click();
        driver.findElement(By.cssSelector(".button.is-danger")).click();
    }
}
