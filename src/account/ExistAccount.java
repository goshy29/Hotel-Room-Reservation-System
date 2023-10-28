package account;

import print.PrintUsers;

import java.util.ArrayList;
import java.util.HashMap;

public class ExistAccount {
    public static String existAccount(String file, String password) {
        String msg = "";
        HashMap<String, String> listOfUsers =
                PrintUsers.printUsers("inputFilePath" + file);
        ArrayList<String> auth = new ArrayList<>();
        for (HashMap.Entry<String, String> entry : listOfUsers.entrySet()) {
            auth.add(entry.getValue());
        }
        for (String userAuth: auth) {
            if (userAuth.equals(password)) {
                msg = "User with this password already exist!";
            }
        }

        return msg;
    }
}
