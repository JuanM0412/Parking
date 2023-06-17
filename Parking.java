class Parking {
    private int freeSpacesC, occupiedSpacesC, freeSpacesM, occupiedSpacesM;
    private int carSpaces[], motorcycleSpaces[];

    public Parking(){
        this.freeSpacesC = 0;
        this.occupiedSpacesC = 0;
        this.freeSpacesM = 0;
        this.occupiedSpacesM = 0;
        this.motorcycleSpaces = new int[0]; 
        this.carSpaces = new int[0]; 
    }

    public void setParking(int car, int mot){
        this.carSpaces = new int[car];
        this.motorcycleSpaces = new int[mot];
        for(int i = 0; i < car; i++){
            carSpaces[i] = 0;
        }

        for(int i = 0; i < mot; i++){
            motorcycleSpaces[i] = 0;
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

    public int[] getCarSpaces(){
        return this.carSpaces;
    }

    public int[] getMotorcycleSpaces(){
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

    public int allocateSpace(int meanOfTransport){
        int space = 0;
        if(meanOfTransport == 0){
            for(int n: motorcycleSpaces){
                if(n == 0)
                    space = n;
            }
            motorcycleSpaces[space] = 1;
            freeSpacesM--;
            occupiedSpacesM++;
        }
        else{
            for(int n: carSpaces){
                if(n == 0)
                    space = n;
            }
            carSpaces[space] = 1;
            freeSpacesC--;
            occupiedSpacesC++;
        }

        return space;
    }
}