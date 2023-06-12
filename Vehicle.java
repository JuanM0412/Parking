public abstract class Vehicle {
    private String plate, model;

    public Vehicle(){
        this.plate = "";
        this.model = "";
    }

    public void setPlate(String plate){
        this.plate = plate.toUpperCase();
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getPlate(){
        return this.plate;
    }

    public String getModel(){
        return this.model;
    }

    public abstract boolean checkPlate(String plate);
}