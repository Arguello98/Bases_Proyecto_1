/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Persona
 */
public class ProductoCompra {
    int id_Producto;
    String nombre;
    int cantidad;

    public int getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public ProductoCompra(int id_Producto,
    String nombre,
    int cantidad){
        this.id_Producto= id_Producto;
        this.nombre= nombre;
        this.cantidad= cantidad;
    }
}
