public class User {
    private int meansOfTransport, card;

    public User(){
        this.card = 100;
        this.meansOfTransport = 100;
    }

    public void setMeansOfTransport(int transport){
        this.meansOfTransport = transport;
    }

    public void setCard(int card){
        this.card = card;
    }

    public int getMeansOfTransport(){
        return this.meansOfTransport;
    }

    public int getCard(){
        return this.card;
    }
}