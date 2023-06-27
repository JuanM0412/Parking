import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Scanner in = new Scanner(System.in);
        int typeOfTransport, space;
        boolean flag = true;
        char op = 'Y';
        String selectedParking;
        Vehicle vehicle = null;
        Admin admin = new Admin();

        admin.setAdmin(in, parking, admin);
        admin.setParking(in);
        parking = admin.getParking();

        do{
            User usr = new User();
            usr.setUser(usr, in, vehicle);
            vehicle = usr.getVehicle();

            usr.userInfo(usr, vehicle);

            typeOfTransport = usr.getTypeOfTransport();
            System.out.println("Is your information right? (Y/n): ");
            op = in.next().charAt(0);
            do{
                if(op == 'Y' || op == 'y'){
                    space = parking.allocateSpace(typeOfTransport, usr);
                    usr.setAssignedSpace(space);
                    System.out.println("The assigned parking space is " + usr.getAssignedSpace());
                    flag = false;
                }
                else if(op == 'N' || op == 'n'){
                    try{
                        System.out.println("Which of the following do you want to replace?: ");
                        System.out.println("1. Type of vehicle. \n2. Plate. \n3. Model. \n4. Card. \n5. Name.");
                        System.out.println("Choose one: ");
                        in.next().charAt(0);
                    } 
                    catch(InputMismatchException e){
                        System.out.println("Choose a valid option: ");
                        in.next().charAt(0);
                        flag = false;
                    }
                }
                else{
                    System.out.println("Invalid option.");
                    flag = false;
                }
            } while(flag);

            admin.parkingInfo(parking);
            parking.showParking();
            
            System.out.println("Select one of the spaces to view the information: ");
            selectedParking = in.next().toUpperCase();
            parking.parkingInfo(selectedParking);
        } while(true);
    }
}