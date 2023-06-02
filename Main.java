import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int typeOfTransport;
            String plate, card, model, name;
            User usr = new User();
            MeansOfTransport transport = new MeansOfTransport();

            System.out.println("Please enter your card: ");
            card = in.nextLine();
            usr.setCard(card);

            System.out.println("Please enter your name: ");
            name = in.nextLine();
            usr.setName(name);

            System.out.println("Enter a valid mean of transport (0/1): ");
            typeOfTransport = in.nextInt();
            usr.setTypeOfTransport(typeOfTransport);

            transport = usr.getMeansOfTransport();
            System.out.println("Enter the plate of your vehicle plate: ");
            plate = in.nextLine();

            transport.setPlate(plate);
            System.out.println("Enter the model of your vehicle: ");
            model = in.nextLine();

            transport.setModel(model);
            System.out.println("This is the information of your vehicle.");
            System.out.println("Plate: " + transport.getPlate());
            System.out.println("Model: " + transport.getModel());
            System.out.println("Your information.");
            System.out.println("Card: " + usr.getCard());
            System.out.println("Name: " + usr.getName());
        }
    }
}