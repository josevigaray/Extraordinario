/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extraordinario;

/**
 *
 * @author Usuario
 */
public class Movil extends Electronicos {
    
    private String marca;
    
    public Movil (Integer id, String nombre, double precio, int stock, String tipo, String marca){
        super (id, nombre, precio, stock, tipo);
        this.marca = marca;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
