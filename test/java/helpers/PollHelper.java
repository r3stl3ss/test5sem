package helpers;

import dtos.ThreeElementalPollData;
import managers.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PollHelper extends HelperBase {

    public PollHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createThreeElementsPoll(ThreeElementalPollData poll) {
        driver.findElement(By.xpath("//form[@id='create_poll']/div/input")).click();
        driver.findElement(By.xpath("//form[@id='create_poll']/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='create_poll']/div/input")).sendKeys(poll.getPollName());
        driver.findElement(By.xpath("//form[@id='create_poll']/div[2]/textarea")).click();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[2]/textarea")).clear();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[2]/textarea")).sendKeys(poll.getPollDescription());
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div/input")).click();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div/input")).clear();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div/input")).sendKeys(poll.getFirstOption());
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div[2]/input")).click();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div[2]/input")).clear();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div[2]/input")).sendKeys(poll.getSecondOption());
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div[3]/input")).click();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div[3]/input")).clear();
        driver.findElement(By.xpath("//form[@id='create_poll']/div[3]/div[2]/div[3]/input")).sendKeys(poll.getThirdOption());
        driver.findElement(By.id("create-poll")).click();
    }

    public ThreeElementalPollData getPollData() {
        String pollName = driver.findElement(By.cssSelector(".title.is-size-3-desktop.is-size-3-tablet.is-size-4-mobile.has-text-centered-tablet")).getText();
        String pollDesc = driver.findElement(By.className("pd")).getText();
        List<WebElement> elements = driver.findElements(By.className("control-label"));
        ThreeElementalPollData testData = new ThreeElementalPollData(pollName, pollDesc, elements.get(0).getText(), elements.get(1).getText(), elements.get(2).getText());
        return testData;
    }
}
