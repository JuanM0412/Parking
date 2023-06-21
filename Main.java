import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Scanner in = new Scanner(System.in);
        int typeOfTransport, space;
        boolean flag;
        char op = 'Y';
        String plate, card, model, name, selectedParking;
        User usr = new User();
        Vehicle transport = null;

        parking.setParking(10, 10);

        do{
            System.out.println("Please enter your card: ");
            card = in.nextLine();
            flag = usr.checkCard(card);
            while(flag == false){
                System.out.println("Please enter a valid card: ");
                card = in.nextLine();
                flag = usr.checkCard(card);
            }
                
            usr.setCard(card);
            System.out.println("Please enter your name: ");
            name = in.nextLine();
            usr.setName(name);

            System.out.println("Enter a valid mean of transport (0/1): ");
            typeOfTransport = in.nextInt();
            in.nextLine();
            if(typeOfTransport == 0){
                transport = new Motorcycle();
                usr.setTypeOfTransport(typeOfTransport);
                System.out.println("Enter the plate of your motorcycle: ");
                plate = in.nextLine().toUpperCase();
            }
            else{
                transport = new Car();
                usr.setTypeOfTransport(typeOfTransport);
                System.out.println("Enter the plate of your car: ");
                plate = in.nextLine().toUpperCase();
            }

            flag = transport.checkPlate(plate);
            while(flag == false){
                System.out.println("Please, enter a valid plate: ");
                plate = in.nextLine();
                flag = transport.checkPlate(plate);
            }
                
            transport.setPlate(plate.toUpperCase());
            System.out.println("Enter the model of your vehicle: ");
            model = in.nextLine();

            transport.setModel(model);
            System.out.println("This is the information of your vehicle.");
            System.out.println("Type of vehicle: " + usr.getTypeOfTransport());
            System.out.println("Plate: " + transport.getPlate());
            System.out.println("Model: " + transport.getModel());
            System.out.println("Your information.");
            System.out.println("Card: " + usr.getCard());
            System.out.println("Name: " + usr.getName());

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
                    } catch(InputMismatchException e){
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

            System.out.println("This is the information of the parking.");
            System.out.println("Free spaces for car: " + parking.getCarFreeSpaces());
            System.out.println("Free spaces for motorcycle: " + parking.getMotorcycleFreeSpaces());
            System.out.println("Ocupied car spaces: " + parking.getCarOccupiedSpaces());
            System.out.println("Ocupied motorcycle spaces: " + parking.getMotorcycleOccupiedSpaces());
            parking.showParking();
            System.out.println("Select one of the spaces to view the information: ");
            selectedParking = in.next();
            parking.parkingInfo(selectedParking);
        } while(true);
    }
}