/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Gestores;
import com.mycompany.sistemabarberia.Clases.ProductoVendido;
import com.mycompany.sistemabarberia.Clases.Inventario;
import com.mycompany.sistemabarberia.Clases.Venta;
import javax.swing.JOptionPane;
/**
 *
 * 
 */
public class GestorProductosVendidos {
    public static int contador = 0;
    public static int ultimoId = 0;
    public static ProductoVendido[] productosVendidos = new ProductoVendido[contador];

    // Agregar producto vendido
    public static void agregarProductoVendido(Inventario inventario, Venta venta) {
        contador++;
        ultimoId++;

        int id = ultimoId;
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad vendida:"));
        double precioUnitario = inventario.getPrecioVenta();

        ProductoVendido[] nuevo = new ProductoVendido[productosVendidos.length + 1];
        for (int i = 0; i < productosVendidos.length; i++) {
            nuevo[i] = productosVendidos[i];
        }
        productosVendidos = nuevo;

        productosVendidos[contador - 1] = new ProductoVendido(id, inventario, venta, cantidad, precioUnitario);
        JOptionPane.showMessageDialog(null, "✅ Producto vendido agregado correctamente.");
    }

    // Consultar productos vendidos
    public static void consultarProductosVendidos() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos vendidos registrados.");
        } else {
            String mensaje = "🧾 Productos vendidos:\n";
            for (ProductoVendido pv : productosVendidos) {
                if (pv != null) {
                    mensaje += pv.toString() + "\n----------------------\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    // Editar producto vendido
    public static void editarProductoVendido() {
        int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto vendido a editar:"));
        for (int i = 0; i < contador; i++) {
            if (productosVendidos[i] != null && productosVendidos[i].getId() == idBusqueda) {
                int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad:"));
                double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio unitario:"));

                productosVendidos[i].setCantidad(nuevaCantidad);
                productosVendidos[i].setPrecioUnitario(nuevoPrecio);

                JOptionPane.showMessageDialog(null, "✅ Producto vendido editado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "⚠️ No se encontró un producto vendido con ese ID.");
    }

    // Eliminar producto vendido
    public static void eliminarProductoVendido() {
        int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto vendido a eliminar:"));
        for (int i = 0; i < contador; i++) {
            if (productosVendidos[i] != null && productosVendidos[i].getId() == idBusqueda) {
                productosVendidos[i] = null;
                JOptionPane.showMessageDialog(null, "❌ Producto vendido eliminado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "⚠️ No se encontró un producto vendido con ese ID.");
    }

    // Calcular subtotal de un producto vendido
    public static void calcularSubtotal() {
        int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto vendido:"));
        for (ProductoVendido pv : productosVendidos) {
            if (pv != null && pv.getId() == idBusqueda) {
                JOptionPane.showMessageDialog(null, "💰 Subtotal: " + pv.getSubtotal());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "⚠️ No se encontró un producto vendido con ese ID.");
    }

    // Calcular total general de productos vendidos
    public static void calcularTotalGeneral() {
        double total = 0;
        for (ProductoVendido pv : productosVendidos) {
            if (pv != null) {
                total += pv.getSubtotal();
            }
        }
        JOptionPane.showMessageDialog(null, "💵 Total general de productos vendidos: " + total);
    }
}