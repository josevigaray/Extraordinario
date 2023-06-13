/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Extraordinario;

/**
 *
 * @author Usuario
 */
public class Electronicos {
    
    private final Integer id;
    private String nombre;
    private double precio;
    private int stock;
    private String tipo;
    
    //Constructor
    public Electronicos(Integer id, String nombre, double precio, int stock, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.tipo = tipo;
    }
    
    public Integer getID() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Electronicos{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", tipo=" + tipo + '}';
    }
}
