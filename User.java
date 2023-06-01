public class User {
    private String card;
    private int meansOfTransport;

    public User(){
        this.card = "";
        this.meansOfTransport = 100;
    }

    public void setMeansOfTransport(int transport){
        this.meansOfTransport = transport;
    }

    public void setCard(String card){
        this.card = card;
    }

    public int getMeansOfTransport(){
        return this.meansOfTransport;
    }

    public String getCard(){
        return this.card;
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