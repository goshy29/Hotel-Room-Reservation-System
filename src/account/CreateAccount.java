package account;

import java.io.*;

public class CreateAccount {
    public static void createAccount(String userName, String password, String file, String room) {
        String fileDir = "inputFilePath" + file;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileDir));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileDir, true))) {
            String line;
            if (room.equals("")) {
                if ((line = reader.readLine()) == null) {
                    writer.write(userName + ", " + password);
                } else {
                    writer.write("\n" + userName + ", " + password);
                    System.out.printf("User %s was created%n", userName);
                }
            } else {
                if ((line = reader.readLine()) == null) {
                    writer.write(userName + ", " + password+ ", " + room);
                } else {
                    writer.write("\n" + userName + ", " + password+ ", " + room);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
