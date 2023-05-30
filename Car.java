public class Car {
    private String plate, model;

    public Car(){
        this.model = "";
        this.plate = "";
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

    public static boolean checkPlate(String plate){
        if(plate.length() > 6)
            return false;

        String charPart = plate.substring(0, 2);
        String numericPart = plate.substring(3, 5);

        for(char ch: charPart.toCharArray()){
            if(!(ch >= 'A' && ch <= 'Z')){
                return false;
            }
        }
        
        for(char n: numericPart.toCharArray()){
            if(!(n >= '0' && n <= '9')){
                return false;
            }
        }

        return true;
    }
}