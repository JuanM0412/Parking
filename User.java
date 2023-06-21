class User {
    private String card, name, typeOfTransport;
    private int assignedSpace;
    private Vehicle vehicle;

    public User(){
        this.card = "";
        this.typeOfTransport = "";
        this.name = "";
        this.vehicle = null;
    }

    public void setTypeOfTransport(int transport){
        if(transport == 0){
            this.typeOfTransport = "Motorcycle";
            this.vehicle = new Motorcycle();
        }
        else if(transport == 1){
            this.typeOfTransport = "Car";
            this.vehicle = new Car();
        }
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

    public String getTypeOfTransport(){
        return this.typeOfTransport;
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
}