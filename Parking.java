import java.util.ArrayList;

class Parking {
    private int freeSpacesC, occupiedSpacesC, freeSpacesM, occupiedSpacesM;
    private User carSpaces[], motorcycleSpaces[];

    public Parking(){
        this.freeSpacesC = 0;
        this.occupiedSpacesC = 0;
        this.freeSpacesM = 0;
        this.occupiedSpacesM = 0;
        this.motorcycleSpaces = new User[0]; 
        this.carSpaces = new User[0]; 
    }

    public void setParking(int car, int mot){
        this.carSpaces = new User[car];
        this.motorcycleSpaces = new User[mot];
        this.freeSpacesC = car;
        this.freeSpacesM = mot;
        for(int i = 0; i < car; i++){
            carSpaces[i] = null;
        }

        for(int i = 0; i < mot; i++){
            motorcycleSpaces[i] = null;
        }
    }

    public void setCarSpaces(int numOfSpaces){
        this.freeSpacesC = numOfSpaces;
        this.occupiedSpacesC = 0;
    }

    public void setMotorcycleSpaces(int numOfSpaces){
        this.freeSpacesM = numOfSpaces;
        this.occupiedSpacesM = 0;
    }

    public User[] getCarSpaces(){
        return this.carSpaces;
    }

    public User[] getMotorcycleSpaces(){
        return this.motorcycleSpaces;
    }

    public int getCarFreeSpaces(){
        return this.freeSpacesC;
    }

    public int getCarOccupiedSpaces(){
        return this.occupiedSpacesC;
    }

    public int getMotorcycleFreeSpaces(){
        return this.freeSpacesM;
    }

    public int getMotorcycleOccupiedSpaces(){
        return this.occupiedSpacesM;
    }

    public int allocateSpace(int meanOfTransport, User usr){
        int space = -1;
        if(meanOfTransport == 0){
            for(int i = 0; i < motorcycleSpaces.length; i++){
                if(motorcycleSpaces[i] == null){
                    space = i;
                    motorcycleSpaces[i] = usr;
                    freeSpacesM--;
                    occupiedSpacesM++;
                    break;
                }
            }
        }
        else{
            for(int i = 0; i < carSpaces.length; i++){
                if(carSpaces[i] == null){
                    space = i;
                    carSpaces[i] = usr;
                    freeSpacesC--;
                    occupiedSpacesC++;
                    break;
                }
            }
        }

        if(space == -1)
            return -1;

        return space;
    }

    public void showCarParking(){
        for(int i = 0; i < carSpaces.length; i++){
            System.out.print(String.format("%-3s ", "C" + i));
        }
    }

    public void showMotorcycleParking(){
        for(int i = 0; i < motorcycleSpaces.length; i++){
            System.out.print(String.format("%-3s ", "M" + i));;
        }
    }

    public void showParking(){
        showCarParking();
        System.out.println();

        showMotorcycleParking();
        System.out.println();
    }

    public void parkingInfo(String selectedParking){
        try{
            char[] selected = selectedParking.toCharArray();
            int num = Character.getNumericValue(selected[1]);
            char vehicle = selected[0];
            User tmpUsr;

            if(vehicle == 'M'){
                tmpUsr = motorcycleSpaces[num];
            }
            else{
                tmpUsr = carSpaces[num];
            }

            String transport = (tmpUsr.getTypeOfTransport() == 1) ? "Car" : "Motorcycle";
            Vehicle tmpVehicle = tmpUsr.getVehicle();
            
            System.out.println("This parking is occupied by:");
            System.out.println("Name: " + tmpUsr.getName());
            System.out.println("Card: " + tmpUsr.getCard());
            
            System.out.println("With the following vehicle:");
            System.out.println("Type of vehicle: " + transport);
            System.out.println("Plate: " + tmpVehicle.getPlate());
            System.out.println("Model: " + tmpVehicle.getModel());
        }
        catch(Exception e){
            System.out.println("Parking space " + selectedParking + " is free.");
        }
    }

    public void freeSpaces(){
        ArrayList<String> freeSpaces = new ArrayList<String>();

        for(int i = 0; i < carSpaces.length; i++) {
            if(carSpaces[i] == null){
                freeSpaces.add("C" + i);
            }
        }

        for(int i = 0; i < carSpaces.length; i++) {
            if(carSpaces[i] == null){
                freeSpaces.add("M" + i);
            }
        }

        for(String parking: freeSpaces) {
            System.out.println(parking);
        }

        if(freeSpaces.size() == 0)
            System.out.println("All spaces are occupied.");
    }

    public void occupiedSpaces(){
        ArrayList<String> occupiedSpaces = new ArrayList<String>();

        for(int i = 0; i < carSpaces.length; i++) {
            if(carSpaces[i] != null){
                occupiedSpaces.add("C" + i);
            }
        }

        for(int i = 0; i < carSpaces.length; i++) {
            if(carSpaces[i] != null){
                occupiedSpaces.add("M" + i);
            }
        }

        for(String parking: occupiedSpaces) {
            System.out.println(parking);
        }

        if(occupiedSpaces.size() == 0)
            System.out.println("All spaces are available.");
    }
}