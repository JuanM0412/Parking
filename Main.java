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

        cleanScreen();
        admin.setAdmin(in, parking, admin);
        admin.setParking(in);

        parking = admin.getParking();
        System.out.println("Please enter a word to continue.");
        in.next();

        do{
            menu(in);
            cleanScreen();
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

                        op = in.next().charAt(0);
                        vehicle = processOption(in, op, usr, vehicle);
                        usr.userInfo(usr, vehicle);

                        System.out.println("Is your information right? (Y/n): ");
                        op = in.next().charAt(0);
                    } 
                    catch(InputMismatchException e){
                        System.out.println("Choose a valid option: ");
                        in.next().charAt(0);
                    }
                }
                else{
                    System.out.println("Invalid option.");
                }
            } while(flag);

            System.out.println("Please enter a word to continue.");
            in.next();
            cleanScreen();

            admin.parkingInfo(parking, in);
            parking.showParking();

            System.out.println("Select one of the spaces to view the information: ");
            selectedParking = in.next().toUpperCase();
            parking.parkingInfo(selectedParking);

            System.out.println("Please enter a word to continue.");
            in.next();
        } while(true);
    }

    public static Vehicle processOption(Scanner in, char op, User usr, Vehicle vehicle){
        if(op == '1'){
            vehicle = usr.setVehicle(in, vehicle, usr);
        }
        else if(op == '2'){
            int typeOfTransport = usr.getTypeOfTransport();
            String plate;

            if(typeOfTransport == 0){
                System.out.println("Enter the plate of your motorcycle: ");
                plate = in.next().toUpperCase();
            }
            else{
                System.out.println("Enter the plate of your car: ");
                plate = in.next().toUpperCase();
            }

            vehicle.setPlate(plate);
        }

        return vehicle;
    }

    public static void cleanScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu(Scanner in){
        int usrType = 2;

        System.out.println("Please enter your user type [1/2]: \n1. Admin. \n2. Client.");
        usrType = in.nextInt();
        
        if(usrType != 1 && usrType != 2){
            System.out.println("You have choose an invalid option, so by default you are going to enter on client mode.");
            usrType = 2;
        }
    }
}