package tests;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import dtos.ThreeElementalPollData;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;


public class CreatePollTest extends AuthBase {

    
    @Test
    public void testPollCreation() throws Exception {
        JsonObject parser = (JsonObject) Jsoner.deserialize(new FileReader("f:\\jsons\\polls.json"));
        ThreeElementalPollData poll = new ThreeElementalPollData((String)parser.get("pollName"), (String)parser.get("pollDescription"), (String)parser.get("firstOption"), (String)parser.get("secondOption"), (String)parser.get("thirdOption"));        am.getNavigator().openPollCreatePage();
        am.getPoll().createThreeElementsPoll(poll);
        am.getNavigator().openPollPage();
        Assert.assertEquals(poll, am.getPoll().getPollData());
        am.getLogin().logOut();
    }

/*    @Test
    public void testPollDeleting() throws Exception {
        ThreeElementalPollData deletablePoll = new ThreeElementalPollData("this", "will", "be", "deleted", "now");
        am.getNavigator().openPollCreatePage();
        am.getPoll().createThreeElementsPoll(deletablePoll);
        am.getNavigator().openPollPage();
        am.getNavigator().deletePoll();
        am.getNavigator().openProfilePage();
        am.getNavigator().openPollPage();
        Assert.assertNotEquals(am.getPoll().getPollData(), deletablePoll);
    }*/
}