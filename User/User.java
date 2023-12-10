package User;

import java.util.Scanner;

import Vehicle.*;
import Vehicle.Vehicle;

public class User {
    private String card, name, typeOfTransport;
    private int assignedSpace;
    private Vehicle vehicle;

    public User(){
        this.card = "";
        this.typeOfTransport = "";
        this.name = "";
        this.vehicle = null;
        this.assignedSpace = -1;
    }

    public void setTypeOfTransport(int transport, Vehicle vehicle){
        if(transport == 0){
            this.typeOfTransport = "Motorcycle";
        }
        else if(transport == 1){
            this.typeOfTransport = "Car";
        }
        
        this.vehicle = vehicle;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void setCard(String card){
        this.card = card;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAssignedSpace(int space){
        this.assignedSpace = space;
    }

    public int getTypeOfTransport(){
        if(typeOfTransport == "Car")
            return 1;
        
        return 0;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public String getCard(){
        return this.card;
    }

    public String getName(){
        return this.name;
    }

    public int getAssignedSpace(){
        return this.assignedSpace;
    }

    public boolean checkCard(String card){
        if(card.length() < 7)
            return false;
        
        for(char digit: card.toCharArray()){
            if(!(digit >= '0' && digit <= '9')){
                return false;
            }
        }

        return true;
    }

    public void setUser(User usr, Scanner in, Vehicle vehicle){
        boolean flag;
        String card, name;

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
        System.out.println("Please enter your name: ");
        name = in.nextLine();
        usr.setName(name);

        vehicle = setVehicle(in, vehicle, usr);
    }

    public Vehicle setVehicle(Scanner in, Vehicle vehicle, User usr){
        boolean flag;
        int typeOfTransport;
        String plate, model;

        System.out.println("Enter a valid mean of transport (0/1): ");
        typeOfTransport = in.nextInt();
        in.nextLine();
        if(typeOfTransport == 0){
            vehicle = new Motorcycle();
            usr.setTypeOfTransport(typeOfTransport, vehicle);
            System.out.println("Enter the plate of your motorcycle: ");
            plate = in.nextLine().toUpperCase();
        }
        else{
            vehicle = new Car();
            usr.setTypeOfTransport(typeOfTransport, vehicle);
            System.out.println("Enter the plate of your car: ");
            plate = in.nextLine().toUpperCase();
        }

        flag = vehicle.checkPlate(plate);
        while(flag == false){
            System.out.println("Please, enter a valid plate: ");
            plate = in.nextLine();
            flag = vehicle.checkPlate(plate);
        }
                
        vehicle.setPlate(plate.toUpperCase());
        System.out.println("Enter the model of your vehicle: ");
        model = in.nextLine();

        vehicle.setModel(model);

        return vehicle;
    }

    public void userInfo(User usr, Vehicle vehicle){
        System.out.println("This is the information of your vehicle.");
        System.out.println("Type of vehicle: " + usr.getTypeOfTransport());
        System.out.println("Plate: " + vehicle.getPlate());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Your information.");
        System.out.println("Card: " + usr.getCard());
        System.out.println("Name: " + usr.getName());
    }
}