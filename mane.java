import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

class Main extends JFrame{
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JTextField txtInfo = new JTextField();
        Parqueadero car = new Parqueadero();
        String placa, modelo, color,cedula;
        int totalSpaces = 6;
        int options;
        int inicial = 6;
        boolean free = true;

        if(totalSpaces == 0){
            free =  false;
        }

        while(free){
            options = Integer.parseInt(JOptionPane.showInputDialog(jFrame, "¡Bienvenido! Escoja una de las siguientes opciones.\n" + "1. Desea ingresar un nuevo carro.\n"  + "2. Deseo buscar un carro.\n" + "3. Deseo retirar mi carro.\n" + "4. Deseo saber la información del parqueadero.\n" + "5. Salir.\n" + "Ingrese la opción: "));
            switch(options) {
                case 1:
                    placa = JOptionPane.showInputDialog(jFrame, "Ingresa la placa de tu vehiculo: ");
                    placa = placa.toUpperCase();
                    if (Parqueadero.inputVerification(placa) == -1){
                        JOptionPane.showMessageDialog(jFrame, "Lo sentimos, su placa tiene menos o más de 6 carácteres");
                        break;
                    } 
                    else if (Parqueadero.inputVerification(placa) == -2) {
                        JOptionPane.showMessageDialog(jFrame, "Lo sentimos, los tres primeros carácteres de su placa no son letras");
                        break;
                    } 
                    else if (Parqueadero.inputVerification(placa) == -3) {
                        JOptionPane.showMessageDialog(jFrame, "Lo sentimos, los tres últimos carácteres de su placa no son números");
                        break;
                    } 
                    else
                        car.setPlaca(placa);

                    modelo = JOptionPane.showInputDialog(jFrame,"Ingresa el modelo de tu vehiculo");
                    modelo = modelo.toUpperCase();
                    car.setModelo(modelo);

                    color = JOptionPane.showInputDialog(jFrame, "Ingresa el color de tu vehiculo");
                    color = color.toUpperCase();
                    car.setColor(color);

                    cedula = JOptionPane.showInputDialog(jFrame, "Ingresa tu número de cédula");
                    car.setCedula(cedula);

                    if(totalSpaces == 0){
                        JOptionPane.showMessageDialog(jFrame, "Lo sentimos, no hay lugares disponibles.");
                        continue;
                    } 
                    else {
                        totalSpaces--;
                    }

                    int sitio = Parqueadero.asignarCasillas();
                    Parqueadero.dataBase(placa, modelo, color, cedula, sitio);
                    Date fechaI = new Date();
                    SimpleDateFormat hourI = new SimpleDateFormat("HH:mm:ss");
                    JOptionPane.showMessageDialog(jFrame, "Placa: " + placa + "\nModelo: " + modelo + "\nColor: " + color +  "\nSitio: " + sitio + "\nHora de ingreso: " + hourI.format(fechaI));
                    continue;

                case 2:
                    placa = JOptionPane.showInputDialog(null, "Ingrese la placa del carro \n");
                    placa = placa.toUpperCase();
                    int ubi = Parqueadero.searchCar(placa);
                    if(ubi != -1){
                        JOptionPane.showMessageDialog(jFrame, "El carro está en la casilla " + ubi + "\n ¡Gracias por hacer uso del parqueadero!");
                    } 
                    else{
                        JOptionPane.showMessageDialog(jFrame, "Lo sentimos, no hemos identificado la placa ingresada. \n ¡Gracias por hacer uso del parqueadero!");
                    }
                    continue;

                case 3:
                    placa = JOptionPane.showInputDialog(null, "Ingrese la placa del carro \n");
                    cedula = JOptionPane.showInputDialog(null, "Ingrese tu número de cedula\n");
                    placa = placa.toUpperCase();
                    cedula = cedula.toUpperCase();
                    ubi = Parqueadero.searchCar(placa);
                    String ce = Parqueadero.searchCedula(cedula);
                    Date fechaF = new Date();
                    SimpleDateFormat hourF = new SimpleDateFormat("HH:mm:ss");
                    if (ubi != -1) {
                        if (ce.equals(cedula)) {
                            sitio = Parqueadero.quitarCasillas(ubi);
                            if (sitio == 0) {
                                totalSpaces++;
                                JOptionPane.showMessageDialog(jFrame, "El proceso de verificación ha sido exitoso. \n El carro ha salido correctamente de la casilla " + ubi  + "\nHora de salida: " + hourF.format(fechaF) + "\nFeliz día.");
                            }
                        } 
                        else {
                            JOptionPane.showMessageDialog(jFrame, "Lo sentimos, el proceso de verificación ha fallado. \n Por favor, intente nuevamente.");
                        }

                        continue;
                    } 
                    else {
                        JOptionPane.showMessageDialog(jFrame, "Lo sentimos, no hemos identificado la placa ingresada");
                        continue;
                    }

                case 4:
                    int valor = inicial - totalSpaces;
                    txtInfo.setText("\nInformación general del parqueadero");
                    JOptionPane.showMessageDialog(jFrame, "Espacios libres: " + totalSpaces + "\nEspacios ocupados: " + valor);
                    continue;

                case 5:
                    free = false;
                    continue;

                default:
                    JOptionPane.showMessageDialog(jFrame, "Por favor escoge una de las cuatro opciones. \n");
            }
        }

    }
}