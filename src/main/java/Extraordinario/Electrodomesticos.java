/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extraordinario;

/**
 *
 * @author Usuario
 */
public class Electrodomesticos extends Electronicos{
    
    private String categoria;
    
    public Electrodomesticos (Integer id, String nombre, double precio, int stock, String tipo){
        super(id, nombre, precio, stock, tipo);
        this.categoria = categoria;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
