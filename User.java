public class User {
    private String card, name;
    private MeansOfTransport typeOfTransport;

    public User(){
        this.card = "";
        this.typeOfTransport = new MeansOfTransport();
        this.name = "";
    }

    public void setTypeOfTransport(int transport){
        if(transport == 0)
            this.typeOfTransport = new Motorcycle();
        else if(transport == 1)
            this.typeOfTransport = new Car();
    }

    public void setCard(String card){
        this.card = card;
    }

    public void setName(String name){
        this.name = name;
    }

    public MeansOfTransport getMeansOfTransport(){
        return this.typeOfTransport;
    }

    public String getCard(){
        return this.card;
    }

    public String getName(){
        return this.name;
    }

    public boolean checkCard(String card){
        for(char digit: card.toCharArray()){
            if(!(digit >= '0' && digit <= 9)){
                return false;
            }
        }

        if(card.length() < 8)
            return false;

        return true;
    }
}