package print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintRooms {
    public static void printRooms(String file , int menuIndex) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitRoomValues = line.trim().split(", ");
                if (menuIndex == 1) {
                    System.out.printf("ROOM TYPE: %s; DESCRIPTION: %s; NUMBER OF GUESTS: %s%n",
                            splitRoomValues[0], splitRoomValues[1], splitRoomValues[2]);
                } else if (menuIndex == 2) {
                    System.out.printf("NUMBER: %s; TYPE: %s; PRICE PER NIGHT: %slv.; STATUS: %s%n",
                            splitRoomValues[0], splitRoomValues[1], splitRoomValues[2], splitRoomValues[3]);
                } else if (menuIndex == 6) {
                    System.out.printf("USER: %s; PASSWORD: %s; BOOKED ROOM NUMBER: %s%n",
                            splitRoomValues[0], splitRoomValues[1], splitRoomValues[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
