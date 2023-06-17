class User {
    private String card, name, typeOfTransport;
    private int assignedSpace;

    public User(){
        this.card = "";
        this.typeOfTransport = "";
        this.name = "";
    }

    public void setTypeOfTransport(int transport){
        if(transport == 0)
            this.typeOfTransport = "Motorcycle";
        else if(transport == 1)
            this.typeOfTransport = "Car";
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

    public String getVehicle(){
        return this.typeOfTransport;
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