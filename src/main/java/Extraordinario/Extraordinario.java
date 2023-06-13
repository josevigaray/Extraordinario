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

    public static void almacenarDatos() {
        if (DBManager.loadDriver() && DBManager.connect()) {
            //leo dela BD y cargo en estructura
            articulosElectronicos = DBManager.mapeaelectronicos();
            DBManager.close();
        }
    }

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
    
    public static double pideDouble(String mensaje){
        while (true){
            try {
                System.out.println(mensaje);
                Scanner sc = new Scanner(System.in);
                double valor = sc.nextDouble();
                return valor;
            } catch (Exception e) {
                System.out.println("No has introducido un número con decimales. Vuelve a intentarlo.");
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
    
    
    // crea los articulos de la tienda 
    public static Electronicos creaArticulo(Integer id, String nombre, double precio, int stock, String tipo, String categoria, String marca, String SO) {
        Electronicos nuevoArt = null;
        switch (categoria + marca + SO) {
            case "ELectrodomesticos":
                nuevoArt = new Electrodomestico(id, nombre, precio, stock, tipo, categoria);
                break;
            case "Moviles":
                nuevoArt = new Movil(id, nombre, precio, stock, tipo, marca);
                break;
            case "Tablets":
                nuevoArt = new Tablet(id, nombre, precio, stock, tipo, SO);
        }
        return nuevoArt;
    }

    public static boolean menuPrincipal() {
        System.out.println("");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Mostar datos de un producto por id");
        System.out.println("2. Mostrar stock total por tipo de producto");
        System.out.println("3. Mostrar el número de productos por sistema operativo");
        System.out.println("4. Añadir un producto a su coleccion o estructura de datos");
        System.out.println("5. Salir");
        try {
            int opcion = pideInt("Elige una opción: ");
            switch (opcion) {
                case 1:
                    mostrarUnaArticuloElectronicoporID();
                    return false;
                case 2:

                    return false;
                case 3:

                    return false;
                case 4:
                    addArticulo();
                    return false;
                case 5:
                    return true;
                default:
                    System.out.println("Opción elegida incorrecta");
                    return false;
            }

        } catch (Exception ex) {
            System.out.println("Escribe una opción numérica válida");
            return false;
        }

    }
    
    private static Integer numMaxDeId() {
        // Obtener el numero de id mas alto
        int maxId = 0;
        for (Electronicos artElectronico : articulosElectronicos) {
            if (artElectronico.getID() > maxId) {
                maxId = artElectronico.getID();
            }
        }
        return maxId;
    }
     
     public static void mostrarUnaArticuloElectronicoporID() {
        Electronicos articuloEncontrado = null;
        Integer id = pideInt("Escribe el id de la autora: ");
        for (Electronicos artElectronico : articulosElectronicos) {
            if (artElectronico.getID() == id) {
                articuloEncontrado = artElectronico;
                //Si lo encuentro, salgo del bucle
                break;
            }
        }
        //Verifico que ha encontrado un articulo
        if (articuloEncontrado != null) {
            System.out.println(articuloEncontrado.toString());
        } else {
            System.out.println("No hemos encontrado autora con el ID " + id);
        }
    }
     
     public static void addArticulo() {

        articulosElectronicos.add(creaArticulo(numMaxDeId() + 1, pideLinea("Introduce nombre "), pideDouble("Introduce precio del producto "), pideInt("Introduce cantidad en stock "), pideLinea("Tipo de producto"), pideLinea("Categoria de electrodomestico"), pideLinea("Marca de smartphone "), pideLinea("Sistema operativo de la tablet ")));
    }
    
    //paso los datos recogidos en la coleccion a un csv
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
            for (Electronicos artElectronico : articulosElectronicos) {
                fichero.write(artElectronico.toString());
                fichero.write("\n");
            }
            fichero.close();
        } catch (IOException ex) {
            System.out.println("No pudo escribirse el archivo de salida");
        }

    }

    public static void main(String[] args) {
        DBManager.loadDriver();
        DBManager.connect();
        DBManager.printTablaArticulosElectronicos();
        almacenarDatos();
        boolean salir = false;
        while (!salir) {
            salir = menuPrincipal();
        }
        guardarDatosEnCSV();

    }
}
