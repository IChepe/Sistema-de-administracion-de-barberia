/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Inventario;
import com.mycompany.sistemabarberia.Clases.ProductoVendido;
import com.mycompany.sistemabarberia.Clases.Venta;

public class GestorProductosVendidos {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static ProductoVendido[] productosVendidos = new ProductoVendido[contador];



    public static void agregarProductoVendido(Inventario inventario, Venta venta, int cantidad) {

        contador++;
        ultimoId++;
        int id = ultimoId;
        double precioUnitario = inventario.getPrecioVenta();

        ProductoVendido[] copia = new ProductoVendido[productosVendidos.length + 1];
        for (int i = 0; i < productosVendidos.length; i++) {
            copia[i] = productosVendidos[i];
        }
        productosVendidos = copia;

        productosVendidos[contador - 1] = new ProductoVendido(id, inventario, venta, cantidad, precioUnitario);

        inventario.setStock(inventario.getStock() - cantidad);

        if (inventario.getStock() <= inventario.getStockMinimo()) {
            JOptionPane.showMessageDialog(null, "Atencion: el producto " + inventario.getNombre()
                    + " quedo en " + inventario.getStock() + " unidades,"
                    + "\nque es igual o menor al stock minimo de " + inventario.getStockMinimo() + ".");
        }

    }


    public static void consultarProductosVendidos() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos vendidos registrados");
        } else {
            String mensaje = "Productos vendidos:\n";
            for (int i = 0; i < contador; i++) {
                if (productosVendidos[i] != null) {
                    mensaje = mensaje + productosVendidos[i].toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }

    }


    public static ProductoVendido buscarPorVenta(int idVenta) {

        for (int i = 0; i < contador; i++) {
            if (productosVendidos[i] != null && productosVendidos[i].getVenta().getId() == idVenta) {
                return productosVendidos[i];
            }
        }

        return null;
    }


    public static void calcularTotalGeneral() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos vendidos registrados");
            return;
        }

        double total = 0;
        for (int i = 0; i < contador; i++) {
            if (productosVendidos[i] != null) {
                total += productosVendidos[i].getSubtotal();
            }
        }

        JOptionPane.showMessageDialog(null, "Total general de productos vendidos: " + total);

    }



}
