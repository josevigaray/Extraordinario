/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Extraordinario;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */

public class Extraordinario {

    private static ArrayList<Electronicos> articulosElectronicos;
    private static final String CSV_FILE_IN = "tienda_electronica.csv";
    
    public static int pideInt(String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                Scanner sc = new Scanner(System.in);
                int valor = sc.nextInt();
                //in.nextLine();
                return valor;
            } catch (Exception e) {
                System.out.println("No has introducido un número entero. Vuelve a intentarlo.");
            }
        }
    }

    public static String pideLinea(String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                Scanner sc = new Scanner(System.in);
                String linea = sc.nextLine();
                return linea;
            } catch (Exception e) {
                System.out.println("No has introducido una cadena de texto. Vuelve a intentarlo.");
            }
        }
    }
    
    public static Electronicos creaArticulo(Integer id, String nombre, double precio, int stock, String tipo, String categoria, String marca, String SO) {
        Electronicos artElectronico;
        switch () {
            case "ELectrodomesticos":
                artElectronico = new Electrodomestico(id, nombre, precio, stock, tipo, categoria);
                break;
            case "Moviles":
                artElectronico = new Movil(id, nombre, precio, stock, tipo, marca);
                break;
            case "Tablets":
                artElectronico = new Tablet(id, nombre, precio, stock, tipo, SO);
        }
        return artElectronico;
    }
    
    public static void guardarDatosEnCSV() {
        FileWriter fichero;
        try {
            String nombreDeArchivo = "articulos_electronicos_" + LocalDate.now() + "_" + LocalTime.now() + ".csv";
            System.out.println("El nombre por defecto del archivo de salida es " + nombreDeArchivo);
            String nombreAlternativo = pideLinea("Introduce otro nombre para el archivo o pulsa ENTER si aceptas ese nombre");
            if (nombreAlternativo.isEmpty()) {
                fichero = new FileWriter(nombreDeArchivo);
            } else {
                fichero = new FileWriter(nombreAlternativo);
            }

            for (Autora autora : listaDeAutoras) {
                fichero.write(autora.toStringCSV());
                fichero.write("\n");
            }
            fichero.close();
        } catch (IOException ex) {
            System.out.println("No pudo escribirse el archivo de salida");
        }

    }
    public static void main(String[] args) {
        
    }
}
