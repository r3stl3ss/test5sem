package tests;

import dtos.ThreeElementalPollData;
import org.junit.Assert;
import org.junit.Test;

public class DeletePollTest extends AuthBase {

    @Test
    public void testPollDeleting() throws Exception {
        // JsonObject parser = (JsonObject)Jsoner.deserialize(new FileReader("f:\\jsons\\polls.json"));
        // ThreeElementalPollData deletablePoll = new ThreeElementalPollData((String)parser.get("pollName"), (String)parser.get("pollDescription"), (String)parser.get("firstOption"), (String)parser.get("secondOption"), (String)parser.get("thirdOption"));
        ThreeElementalPollData deletablePoll = new ThreeElementalPollData("this", "will", "be", "deleted", "now");
        am.getNavigator().openPollCreatePage();
        am.getPoll().createThreeElementsPoll(deletablePoll);
        am.getNavigator().openPollPage();
        am.getNavigator().deletePoll();
        am.getNavigator().openProfilePage();
        am.getNavigator().openPollPage();
        Assert.assertNotEquals(am.getPoll().getPollData(), deletablePoll);
        am.getLogin().logOut();
    }
}
