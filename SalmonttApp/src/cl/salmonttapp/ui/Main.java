package cl.salmonttapp.ui;

import cl.salmonttapp.data.GestorDatos;
import cl.salmonttapp.model.Centro_de_Cultivos;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main { //apertura main
    public static void main(String[] args) {//apertura psvm

        Scanner sc = new Scanner(System.in);
        GestorDatos gestordatos = new GestorDatos();

        List<Centro_de_Cultivos> produccion = gestordatos.cargarcentros("centros.txt");
        List<Centro_de_Cultivos> ordenmayormenor = produccion.stream().sorted(Comparator.comparingInt(Centro_de_Cultivos::getToneladas)
                        .reversed()).toList();

        System.out.println("************* Centros de Produccion *************");
        for (Centro_de_Cultivos c : produccion) {
           System.out.println(c);
        }
        opcionorden();

        //validacion entero
        try {
            int input = Integer.parseInt(sc.nextLine());
            if (input == 1) {
                for (Centro_de_Cultivos d : ordenmayormenor) {
                    System.out.println(d);
                }
            } else if (input == 2) {
                System.out.println("El programa finalizara en unos segundos");
            } else {
                System.out.println("Opcion no valida... finalizara la ejecucion del programa");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error, formato incorrecto");
        }
        sc.close();
    } //cierre psvm


    public static void opcionorden(){
        System.out.println("Desea ver los datos de toneladas producidas de mayor a menor? ");
        System.out.println("1) Si, 2) Cerrar el programa...");
    }

}//cierre main
