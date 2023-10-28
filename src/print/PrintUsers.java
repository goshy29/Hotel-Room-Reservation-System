package print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PrintUsers {
    public static HashMap<String, String> printUsers(String file) {
        HashMap<String, String> listOfUsers = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitProp = line.trim().split(", ");
                if (splitProp.length == 2) {
                    String userName = splitProp[0];
                    String password = splitProp[1];
                    listOfUsers.put(userName, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfUsers;
    }
}
