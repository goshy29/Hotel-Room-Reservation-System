package room;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveRoom {
    public static boolean saveRoom(String file, String room) {
        boolean isBooked = false;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Pattern pattern = Pattern.compile(room);
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    Pattern pattern2 = Pattern.compile("booked");
                    Matcher matcher2 = pattern2.matcher(line);
                    if (matcher2.find()) {
                        isBooked = true;
                        content.append(line).append(System.lineSeparator());
                    } else {
                        String matchedvalue = line.replaceAll("available", "booked");
                        content.append(matchedvalue).append(System.lineSeparator());
                    }
                } else {
                    content.append(line).append(System.lineSeparator());
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(content.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isBooked) {
                System.out.printf("Room %s is already booked!%n", room);
            } else {
                System.out.printf("Room %s was successfully booked!%n", room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isBooked;
    }
}
