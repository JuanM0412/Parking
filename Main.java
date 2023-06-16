import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int typeOfTransport;
        boolean flag;
        char op = 'Y';
        String plate, card, model, name;
        User usr = new User();
        Vehicle transport = null;

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
        }
        else{
            transport = new Car();
        }

        usr.setTypeOfTransport(typeOfTransport);
        System.out.println("Enter the plate of your vehicle: ");
        plate = in.nextLine();
        flag = transport.checkPlate(plate);
        while(flag == false){
            System.out.println("Please, enter a valid plate: ");
            plate = in.nextLine();
            flag = transport.checkPlate(plate);
        }
            
        transport.setPlate(plate);
        System.out.println("Enter the model of your vehicle: ");
        model = in.nextLine();

        transport.setModel(model);
        System.out.println("This is the information of your vehicle.");
        System.out.println("Type of vehicle: " + usr.getVehicle());
        System.out.println("Plate: " + transport.getPlate());
        System.out.println("Model: " + transport.getModel());
        System.out.println("Your information.");
        System.out.println("Card: " + usr.getCard());
        System.out.println("Name: " + usr.getName());

        System.out.println("Is your information right? (Y/n): ");
        op = in.next().charAt(0);
        if(op == 'Y' || op == 'y'){

        }
        else if(op == 'N' || op == 'n'){

        }
        else{
            System.out.println("Invalid option.");
        }
    }
}