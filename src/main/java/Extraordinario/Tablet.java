/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extraordinario;

/**
 *
 * @author Usuario
 */
public class Tablet extends Electronicos{
    
    private String SO;
    
    public Tablet (Integer id, String nombre, double precio, int stock, String tipo, String SO){
        super(id, nombre, precio, stock, tipo);
        this.SO = SO;
    }
    
    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }
}
