package Admin;

import java.util.Scanner;

public class AdminMain{
    public static void main(Parking parking, Admin admin) {
        Scanner in = new Scanner(System.in);
        adminMenu(in, admin, parking);
    }

    public static void cleanScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
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

    public static void motorcycleInfo(Parking parking, Scanner in){
        String selectedParking;
        parking.showMotorcycleParking();
        System.out.println();

        System.out.println("Select one of the spaces to view the information: ");
        selectedParking = in.next().toUpperCase();
        parking.parkingInfo(selectedParking);
    }

    public static void carInfo(Parking parking, Scanner in){
        String selectedParking;
        parking.showCarParking();
        System.out.println();

        System.out.println("Select one of the spaces to view the information: ");
        selectedParking = in.next().toUpperCase();
        parking.parkingInfo(selectedParking);
    }

    public static void generalInfo(Admin admin, Scanner in, Parking parking){
        String selectedParking;
        admin.parkingInfo(parking, in);
        parking.showParking();

        System.out.println("Select one of the spaces to view the information: ");
        selectedParking = in.next().toUpperCase();
        parking.parkingInfo(selectedParking);
    }
}