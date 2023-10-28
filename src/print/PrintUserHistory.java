package print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintUserHistory {
    public static void printUserHistory(String file ,String userName, String  password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.printf("USERNAME: %s%n", userName);
            System.out.printf("PASSWORD: %s%n", password);
            boolean match = false;
            while ((line = reader.readLine()) != null) {
                String[] splitHistoryValues = line.trim().split(", ");
                if (splitHistoryValues[1].equals(password)) {
                    System.out.printf("BOOKED ROOM NUMBER: %s%n", splitHistoryValues[2]);
                    match = true;
                }
            }
            if (!match) {
                System.out.println("NO HISTORY WAS FOUND FOR THIS USER!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
