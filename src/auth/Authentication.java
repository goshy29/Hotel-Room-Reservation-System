package auth;

import print.PrintUsers;

import java.util.HashMap;
import java.util.Scanner;

public class Authentication {
    public static String auth(String file, String userName, String password) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> listOfUsers =
                PrintUsers.printUsers("inputFilePath" + file);
        String loginSuccess = (isValidUser(userName, password, listOfUsers)) ?
                "" : "Login failed! Invalid username or password!";
        return loginSuccess;
    }

    private static boolean isValidUser(String userName, String password, HashMap<String, String> listOfUsers) {
        String currPassword = listOfUsers.get(userName);
        return currPassword != null && currPassword.equals(password);
    }
}
