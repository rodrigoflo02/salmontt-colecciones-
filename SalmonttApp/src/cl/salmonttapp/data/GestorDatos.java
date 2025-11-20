package cl.salmonttapp.data;

import cl.salmonttapp.model.Centro_de_Cultivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos { //apertura clase

    public List <Centro_de_Cultivos> cargarcentros(String GestorDatos){ //apertura metodo
        List <Centro_de_Cultivos> informacion = new ArrayList<>();
        ClassLoader cl = getClass().getClassLoader();

        try {//apertura excepcion archivo
            InputStream archivo = cl.getResourceAsStream(GestorDatos);
            if  (archivo == null ){
                System.out.println("No se encontro el archivo " +  GestorDatos);
                return informacion;
            }


            try { //apertura excepcion while
                BufferedReader br = new BufferedReader(new InputStreamReader(archivo));
                String linea;
                int numerolinea = 0;

                while ((linea = br.readLine()) != null){ //apertura while
                    numerolinea++;
                    if (linea.trim().isEmpty()){
                        continue;
                    }

                    //separacion por ;
                    String [] seccion =  linea.split(";");
                    if(seccion.length != 3){
                        System.out.println("error en la linea " + numerolinea);
                        continue;
                    }
                    String nombre = seccion[0].trim();
                    String comuna = seccion[1].trim();
                    String toneladastr = seccion[2].trim();

                    try {
                        int toneladas =  Integer.parseInt(toneladastr);
                        Centro_de_Cultivos centrocultivos = new Centro_de_Cultivos(nombre,comuna,toneladas);
                        informacion.add(centrocultivos);

                    } catch (NumberFormatException e) {
                        System.out.println("error: formato incorrecto...");
                    }

                } //cierre while
            } catch (IOException e){
                System.out.println("Error en el archivo");
            } //cierre excepcion while

        } catch (NullPointerException e) {
            System.out.println("Error: Archivo no encontrado");
        } //cierre excepcion archivo

        return informacion;
    } //cierre metodo
} //cierre clase
