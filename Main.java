import java.util.Scanner;

import Admin.*;
import User.*;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Scanner in = new Scanner(System.in);
        Admin admin = new Admin();

        cleanScreen();
        admin.setAdmin(in, parking, admin);
        admin.setParking(in);

        parking = admin.getParking();
        System.out.println("Please enter a word to continue.");
        in.next();

        do{
            cleanScreen();
            menu(in, parking, admin);
        } while(true);
    }

    public static void cleanScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu(Scanner in, Parking parking, Admin admin){
        int usrType = 2;

        System.out.println("Please enter your user type [1/2]: \n1. Admin. \n2. Custumer.");
        usrType = in.nextInt();
        
        if(usrType != 1 && usrType != 2){
            System.out.println("You have choose an invalid option, so by default you are going to enter on custumer mode.");
            usrType = 2;
        }

        System.out.println("Please enter a word to continue.");
        in.next();
        cleanScreen();

        if(usrType == 2)
            UserMain.main(parking);
        else
            AdminMain.main(parking, admin);
    }
}