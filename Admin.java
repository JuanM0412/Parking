import java.util.Scanner;

public class Admin {
    private String password, username;
    private Parking parking;

    public Admin(){
        this.password = "";
        this.username = "";
        this.parking = null;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setParking(Scanner in){
        int motorcycle, car;
        this.parking = new Parking();

        System.out.println("Hi, Admin. Let's create a parking for you!");
        System.out.println("How many car spaces do you have?: ");
        car = in.nextInt();

        System.out.println("How many motorcycle spaces do you have?: ");
        motorcycle = in.nextInt();
        parking.setParking(car, motorcycle);

        parkingInfo(parking);
    }

    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    public Parking getParking(){
        return this.parking;
    }

    public void parkingInfo(Parking parking){
        System.out.println("This is the information of the parking.");
        System.out.println("Free spaces for car: " + parking.getCarFreeSpaces());
        System.out.println("Free spaces for motorcycle: " + parking.getMotorcycleFreeSpaces());
        System.out.println("Ocupied car spaces: " + parking.getCarOccupiedSpaces());
        System.out.println("Ocupied motorcycle spaces: " + parking.getMotorcycleOccupiedSpaces());
    }

    public void adminMenu(Scanner in){
        int op;

        System.out.println("Welcome to you parking, Admin!");
        System.out.println("What do you want to do?");
        System.out.println("1. Change your parking. \n2. General parking information. \n3. Car parking information. \n4. Motorcycle parking information.");
    
        op = in.nextInt();

        if(op == 1){
            setParking(in);
        }
        else if(op == 2){
            parkingInfo(parking);
        }
    }

    public void setAdmin(Scanner in, Parking parking, Admin admin){
        String username, password;

        System.out.println("Hello, Admin!");
        System.out.println("Please, enter a username: ");
        username = in.next();

        admin.setUsername(username);
        System.out.println("Please, enter a password: ");
        password = in.next();

        admin.setPassword(password);
    }
}