package Admin;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hi.");
    }

    public static void adminMenu(Scanner in, Admin admin, Parking parking){
        int option;
        
        System.out.println("Welcome, dear admin! Please, type an option to start.");
        System.out.println("1. View free spaces.\n2. View occupied spaces. \n3. General info. \n4. Car parking info. \n5. Motorcycle parking info.");
        option = in.nextInt();

        cleanScreen();
        switch(option){
            case 1:
                parking.freeSpaces();
                break;
            case 2:
                parking.occupiedSpaces();
                break;
            case 4:
                carInfo(parking, in);
                break;
            case 5:
                motorcycleInfo(parking, in);
                break;
            default:
                if(option != 3)
                    System.out.println("You have choose an invalid option, so the third option is selected by default.");
                generalInfo(admin, in, parking);
                break;
        }

        System.out.println("Please enter a word to continue.");
        in.next();
        cleanScreen();
    }
}