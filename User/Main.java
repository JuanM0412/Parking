package User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi!");
    }

    public static void customerMenu(Scanner in, Parking parking){
        int option;
        User usr = new User();

        System.out.println("Welcome, dear customer! Please, type an option to start.");
        System.out.println("1. Use the parking.\n2. View my information. \n3. Leave the parking.");
        option = in.nextInt();

        if(option != 1 && option != 2 && option != 3){
            System.out.println("You have choose an invalid option, so the first option is selected by default.");
            option = 1;
        }

        cleanScreen();
        if(option == 1)
            useParking(in, parking, usr);
        else if(option == 2 || option == 3){
            String card;

            System.out.println("Please enter your card:");
            card = in.next();
            parking.searchUser(card, (option == 2) ? 1 : 0, parking);

            System.out.println("Please enter a word to continue.");
            in.next();
        }
    }
}
