package managers;

import helpers.LoginHelper;
import helpers.NavigationHelper;
import helpers.PollHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class ApplicationManager {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    private PollHelper poll;
    private NavigationHelper navigator;
    private LoginHelper login;
    private static ThreadLocal<ApplicationManager> manager = new ThreadLocal<>();



    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "F:/chromedrivernew.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        poll = new PollHelper(this);
        navigator = new NavigationHelper(this);
        login = new LoginHelper(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public PollHelper getPoll() {
        return poll;
    }

    public void setPoll(PollHelper poll) {
        this.poll = poll;
    }

    public NavigationHelper getNavigator() {
        return navigator;
    }

    public void setNavigator(NavigationHelper navigator) {
        this.navigator = navigator;
    }

    public LoginHelper getLogin() {
        return login;
    }

    public void setLogin(LoginHelper login) {
        this.login = login;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public static ApplicationManager getInstance() {
        if (manager.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.navigator.OpenTestableSite();
            manager.set(newInstance);
        }
        return manager.get();
    }
}
