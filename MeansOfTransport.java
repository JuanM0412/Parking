public class MeansOfTransport {
    private String plate, model;

    public MeansOfTransport(){
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
}