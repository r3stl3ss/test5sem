package tests;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import dtos.AccountData;
import managers.ApplicationManager;
import org.junit.Before;
import org.openqa.selenium.By;

import java.io.FileReader;

public class AuthBase extends TestBase {
    public static boolean isLogged = false;

    @Before
    public void setUp() throws Exception {
        am = ApplicationManager.getInstance();

        if (!isLogged){
            isLogged = true;
            JsonObject parser = (JsonObject) Jsoner.deserialize(new FileReader("f:\\jsons\\validLoginData.json"));
            AccountData user = new AccountData((String)parser.get("username"), (String)parser.get("password"));
            am.getNavigator().OpenLoginPage();
            am.getDriver().findElement(By.xpath("//input[@type='email']")).click();
            am.getDriver().findElement(By.xpath("//input[@type='email']")).clear();
            am.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(user.getUsername());
            am.getDriver().findElement(By.xpath("//input[@type='password']")).click();
            am.getDriver().findElement(By.xpath("//input[@type='password']")).clear();
            am.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(user.getPassword());
            am.getDriver().findElement(By.xpath("//div[@id='login']/section/div/div/form/div[2]/button")).click();
        }
    }
}
