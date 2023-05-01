class Parqueadero {
    private String modelo, placa, color,cedula;
    private static int totalSpaces = 6;
    static String[][] occupiedSpacesByCars = {{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}};
    static int[] occupiedSpaces = {0, 0, 0, 0, 0, 0};
    // static int casilla = (int)(Math.random()*6);

    public Parqueadero(){
        this.modelo = "";
        this.placa = "";
        this.color = "";
        this.cedula = "";
    }

    public void setModelo(String m){
        this.modelo = m.toUpperCase();
    }
    public void setPlaca(String p){
        this.placa = p;
    }
    public void setColor(String c){
        this.color = c.toUpperCase();
    }

    public void setCedula(String ce){
        this.cedula = ce.toUpperCase();
    }


    public String getModelo(){
        return this.modelo;
    }
    public String getPlaca(){
        return this.placa;
    }
    public String getColor(){
        return this.color;
    }
    public String getCedula(){
        return this.cedula;
    }

    public static int asignarCasillas(){

        int casilla = (int)(Math.random()*6);

        if(occupiedSpaces[casilla] == 0){
            occupiedSpaces[casilla] = 1;
            return casilla;

        } else{
            return asignarCasillas();
        }
    }

    public static int quitarCasillas(int ocu){
        occupiedSpacesByCars[ocu][0] = "";
        occupiedSpacesByCars[ocu][1] = "";
        occupiedSpacesByCars[ocu][2] = "";
        occupiedSpacesByCars[ocu][3] = "";
        occupiedSpaces[ocu] = 0;
        return occupiedSpaces[ocu];
    }

    public static void dataBase(String p, String m, String c, String ce, int casi){
        occupiedSpacesByCars[casi][0] = p;
        occupiedSpacesByCars[casi][1] = m;
        occupiedSpacesByCars[casi][2] = c;
        occupiedSpacesByCars[casi][3] = ce;
    }

    public static int searchCar(String p){
        int alm = 0;
        for(int i = 0; i<totalSpaces; i++){
            String cont = occupiedSpacesByCars[i][0];
            if(cont.equals(p)){
                alm = i;
                break;
            }else{
                alm = -1;
            }
        }
        return alm;
    }

    public static String searchCedula(String ce){
        String alm = "";
        for(int i = 0; i<totalSpaces; i++){
            String cont = occupiedSpacesByCars[i][3];
            if(cont.equals(ce)){
                alm = occupiedSpacesByCars[i][3];
                break;
            }else{
                alm = "No se ha encontrado la cedula";
            }
        }
        return alm;
    }

    public static int inputVerification(String p){

        boolean letter = true;
        boolean numbers = true;
        int flag = 0;
        char a;

        if(p.length() == 6){
            flag = 1;
        }   else {
            flag = -1;
        }

        if (flag == 1){
            for (int i = 0; i < 3; i++){
                a =  p.charAt(i);
                if (letter == true){
                    if (a >='A' && a<='Z'){
                        letter = true;
                        flag = 1;
                    } else {
                        letter = false;
                    }
                } else {
                    flag = -2;
                }
            }
        }

        if (flag == 1){
            for (int i = 3; i <= 5; i++){
                a =  p.charAt(i);
                if (numbers == true){
                    if (a >='0' && a<='9'){
                        numbers = true;
                        flag = 1;
                    } else {
                        numbers = false;
                    }
                } else
                    flag = -3;
            }
        }

        return flag;
    }
}