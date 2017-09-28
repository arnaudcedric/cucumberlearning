package learningjson;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by acedric on 14/06/2017.
 */
public class Gson2Example {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("C:\\Workspace\\learningcucumber\\src\\test\\java\\staff.json")) {
            // Convert JSON to Java Object
            Staff staff = gson.fromJson(reader, Staff.class);
//            System.out.println(staff.to);
            String s = staff.toString();
            System.out.println(s);
            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
