package generators;

import dtos.AccountData;
import dtos.ThreeElementalPollData;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class JsonGenerator {

    public static void main(String[] args) {
        ThreeElementalPollData testPollThird = new ThreeElementalPollData(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
        JSONObject pollThree = new JSONObject(testPollThird);
        AccountData validAccount = new AccountData("vagoyed168@otozuz.com", "Marek228");
        JSONObject validAccountData = new JSONObject(validAccount);
        try {

            // Writing to a file
            FileWriter pollsJsoned = new FileWriter("f:\\jsons\\polls.json");
            System.out.println("Writing JSON object with polls data to file");
            System.out.println("-----------------------");
            System.out.print(pollThree);
            pollsJsoned.write(pollThree.toString());
            pollsJsoned.flush();
            pollsJsoned.close();
            FileWriter loginJsoned = new FileWriter("f:\\jsons\\validLoginData.json");
            System.out.println("\nWriting JSON object with login data to file");
            System.out.println("-----------------------");
            System.out.println(validAccountData);
            loginJsoned.write(validAccountData.toString());
            loginJsoned.flush();
            loginJsoned.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
