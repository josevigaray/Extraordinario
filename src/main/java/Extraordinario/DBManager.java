/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extraordinario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class DBManager {
    
    // Conexión a la base de datos
    private static Connection conn = null;
    
    // Configuración de la conexión a la base de datos
    private static String IP_ADDRES_HOST = "localhost";
    private static final String IP_ADDRESS_IES = "10.230.109.71";
    private static final String IP_ADDRESS_HOME = "10.230.108.59";
    private static final String IP_ADDRESS_DEFAULT = "192.168.11.65";
    
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "Electronicos";
    
    private static String DB_URL;
    
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";
    
    private static final String DB_CONT = "Electronicos";
    private static final String DB_CONT_SELECT = "SELECT * FROM " + DB_CONT;
    private static final String DB_CONT_ID = "id";
    private static final String DB_CONT_NOMBRE = "nombre";
    private static final String DB_CONT_PRECIO = "precio";
    private static final String DB_CONT_STOCK = "stock";
    private static final String DB_CONT_TIPO = "tipo";
    private static final String DB_CONT_CATEGORIA = "categoria";
    private static final String DB_CONT_MARCA = "marca";
    private static final String DB_CONT_SO = "sistema_operativo";
    
    //METODOS PARA CONECTARSE A LA BBDD
    
    /**
     * Intenta cargar el JDBC driver.
     * @return true si pudo cargar el driver, false en caso contrario
     */
    public static boolean loadDriver() {
        try {
            System.out.print("Cargando Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("OK!");
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     * Intenta conectar con la base de datos.
     *
     * @return true si pudo conectarse, false en caso contrario
     */
    public static boolean connect() {
        try {
            try {
                //Leemos del teclado para elegir la IP del servidor en casa o en el IES
                System.out.println("Si estás en casa escribe H de Home, en el instituto I de IES");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.next("[hHiIrR]");
                switch (respuesta.toUpperCase()) {
                    case "H":
                        IP_ADDRES_HOST = IP_ADDRESS_HOME;
                        break;
                    case "I":
                        IP_ADDRES_HOST = IP_ADDRESS_IES;
                        break;
                    default: IP_ADDRES_HOST = IP_ADDRESS_DEFAULT;
;
                }
            } catch (Exception ex) {
                System.out.println("Te empeñas en escribir cualquier cosa en vez de una letra H o I");
                return false;
            }
            DB_URL = "jdbc:mysql://" + IP_ADDRES_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";

            System.out.print("Conectando a la base de datos "+DB_NAME+" en la IP "+IP_ADDRES_HOST+" ... ");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    //Termina la conexion con la bbdd
    public static void close() {
        try {
            System.out.print("Cerrando la conexión...");
            conn.close();
            System.out.println("OK!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ResultSet getTablaElectronica(int resultSetType, int resultSetConcurrency) {
        try {
            Statement stmt = conn.createStatement(resultSetType, resultSetConcurrency);
            ResultSet rs = stmt.executeQuery(DB_CONT_SELECT);
            //stmt.close();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
