package app;

import auth.*;
import print.*;
import account.*;
import room.*;

import java.util.HashMap;
import java.util.Scanner;

public class HotelRoomReservationSystem {
    public static void main(String[] args) {

        final String fileUsers = "filePath\\Users.txt";
        final String fileRoomTypes = "filePath\\RoomTypes.txt";
        final String fileRooms = "filePath\\Rooms.txt";
        final String fileHistory = "filePath\\History.txt";
        final String fileAdmin = "filePath\\Admin.txt";

        //In the search field at IntelliJ, type "inputFilePath"
        //to find and replace this search word with your file path!

        Scanner sc = new Scanner(System.in);
        System.out.println("****** Hotel Reservation System ******");
        System.out.println("");
        System.out.println("Sign in:");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Login as Administrator");
        System.out.println("9. Exit");
        int menuIndex = Integer.parseInt(sc.nextLine());
        boolean isAdmin = menuIndex == 3;
        String userName = "";
        String password = "";
        while (menuIndex != 9) {
            if (menuIndex == 1) {
                System.out.print("username: ");
                userName = sc.nextLine();
                System.out.print("password: ");
                password = sc.nextLine();
                String loginSuccess = Authentication.auth("Users.txt", userName, password);
                System.out.println(loginSuccess);
                if (!loginSuccess.equals("")) {
                    continue;
                }
            }

            if (menuIndex == 2) {
                System.out.print("username: ");
                userName = sc.nextLine();
                System.out.print("password: ");
                password = sc.nextLine();
                String accountAuth = ExistAccount.existAccount("Users.txt", password);
                if (!accountAuth.equals("")) {
                    System.out.println(accountAuth);
                    continue;
                }
                CreateAccount.createAccount(userName, password, "Users.txt", "");
            }

            if (menuIndex == 3) {
                System.out.print("username: ");
                userName = sc.nextLine();
                System.out.print("password: ");
                password = sc.nextLine();
                String loginSuccess = Authentication.auth("Admin.txt", userName, password);
                System.out.println(loginSuccess);
                if (!loginSuccess.equals("")) {
                    continue;
                }
            }

            System.out.println("Menu:");
            System.out.println("1. Room Type");
            System.out.println("2. List of Rooms");
            System.out.println("3. Reserve");
            System.out.println("4. User Profile & History");
            if (isAdmin) {
                System.out.println("5. List of Users");
                System.out.println("6. User's History");
                System.out.println("7. Create Admin Account");
            }

            System.out.println("9. Exit");
            menuIndex = Integer.parseInt(sc.nextLine());
            if (menuIndex == 9) {
                break;
            }

            while (menuIndex != 8) {
                if (menuIndex == 1) {
                    PrintRooms.printRooms(fileRoomTypes, menuIndex);
                }

                if (menuIndex == 2) {
                    PrintRooms.printRooms(fileRooms, menuIndex);
                }

                if (menuIndex == 3) {
                    System.out.print("Book a Room: ");
                    String room = sc.nextLine();
                    System.out.println("8. Save");
                    System.out.println("9. Cancel");
                    menuIndex = Integer.parseInt(sc.nextLine());
                    if (menuIndex == 8) {
                        if (!SaveRoom.saveRoom(fileRooms, room)) {
                            CreateAccount.createAccount(userName, password, "History.txt", room);
                        }
                    }
                }

                if (menuIndex == 4) {
                    PrintUserHistory.printUserHistory(fileHistory, userName, password);
                }

                if (menuIndex == 5) {
                    HashMap<String, String> listOfUsers =
                            PrintUsers.printUsers(fileUsers);
                    for (HashMap.Entry<String, String> entry : listOfUsers.entrySet()) {
                        System.out.printf("USERNAME: %s; PASSWORD: %s%n", entry.getKey(), entry.getValue());
                    }
                }

                if (menuIndex == 6) {
                    PrintRooms.printRooms(fileHistory, menuIndex);
                }

                if (menuIndex == 7) {
                    System.out.print("username: ");
                    userName = sc.nextLine();
                    System.out.print("password: ");
                    password = sc.nextLine();
                    String accountAuth = ExistAccount.existAccount("Admin.txt", password);
                    if (!accountAuth.equals("")) {
                        System.out.println(accountAuth);
                        continue;
                    }
                    CreateAccount.createAccount(userName, password, "Admin.txt","");
                }

                System.out.println("8. Back");
                System.out.println("9. Exit");
                menuIndex = Integer.parseInt(sc.nextLine());
                if (menuIndex == 9) {
                    break;
                }
            }
        }
    }

}


