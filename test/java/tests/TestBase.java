package tests;

import managers.ApplicationManager;
import org.junit.Before;

public class TestBase {
    protected ApplicationManager am;
    @Before
    public void setUp() throws Exception {
        am = ApplicationManager.getInstance();
        am.getNavigator().OpenTestableSite();
    }


/*    @After
    public void tearDown() throws Exception {
        am.stop();
    }
*/
}
