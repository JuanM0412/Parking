import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Scanner in = new Scanner(System.in);
        String selectedParking;
        Admin admin = new Admin();

        cleanScreen();
        admin.setAdmin(in, parking, admin);
        admin.setParking(in);

        parking = admin.getParking();
        System.out.println("Please enter a word to continue.");
        in.next();

        do{
            cleanScreen();
            menu(in, parking);

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
        else if(op == '3'){
            String model;

            in.nextLine();
            System.out.println("Enter the model of your vehicle: ");
            model = in.nextLine();
            vehicle.setModel(model);
        }
        else if(op == '4'){
            boolean flag;
            String card;

            in.nextLine();
            System.out.println("Please enter your card: ");
            card = in.nextLine();
            flag = usr.checkCard(card);

            while(flag == false){
                System.out.println("Please enter a valid card: ");
                card = in.nextLine();
                flag = usr.checkCard(card);
            }

            usr.setCard(card);
        }
        else if(op == '5'){
            String name;

            in.nextLine();
            System.out.println("Please enter your name: ");
            name = in.nextLine();
            usr.setName(name);
        }

        return vehicle;
    }

    public static void cleanScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu(Scanner in, Parking parking){
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
            customerMenu(in, parking);
    }

    public static void customerMenu(Scanner in, Parking parking){
        int option = 1;
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
        else if(option == 2)
            userInfo(usr);
        else
            leaveParking();
    }

    public static void useParking(Scanner in, Parking parking, User usr){
        int typeOfTransport, space;
        boolean flag = true;
        char op = 'Y';
        Vehicle vehicle = null;
            
        usr.setUser(usr, in, vehicle);
        vehicle = usr.getVehicle();
        usr.userInfo(usr, vehicle);

        System.out.println("Is your information right? (Y/n): ");
        op = in.next().charAt(0);
        do{
            typeOfTransport = usr.getTypeOfTransport();
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
    }

    public static void userInfo(User usr){
        Vehicle vehicle = usr.getVehicle();
        usr.userInfo(usr, vehicle);
    }

    public static void leaveParking(){
        System.out.println("Thanks for using the parking!");
    }
}