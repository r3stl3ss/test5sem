package tests;

import dtos.AccountData;
import org.junit.*;


public class LogInTest extends TestBase {

    @Test
    public void testLoginWithValidData() throws Exception {
        AccountData user = new AccountData("vagoyed168@otozuz.com", "Marek228");
        am.getNavigator().OpenLoginPage();
        am.getLogin().LogIn(user);
        am.getNavigator().openProfilePage();
        Assert.assertNotNull(am.getLogin().findOptionsButton());
        am.getLogin().logOut();
    }

    @Test
    public void testLoginWithInvalidData() throws Exception {
        AccountData user = new AccountData("ahahahahahaha@ishisebya.com", "Marek371");
        am.getNavigator().OpenLoginPage();
        am.getLogin().LogIn(user);
        am.getNavigator().openProfilePage();
        Assert.assertEquals(0, am.getLogin().findOptionsButton());
    }
}

