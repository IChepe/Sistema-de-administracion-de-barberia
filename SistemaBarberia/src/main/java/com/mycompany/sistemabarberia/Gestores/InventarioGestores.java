/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Gestores;

import com.mycompany.sistemabarberia.Clases.Inventario;
import com.mycompany.sistemabarberia.Enumeradores.Categoria;
import javax.swing.JOptionPane;

public class InventarioGestores {
    public static int contador = 0;
    public static int ultimoId = 0;
    public static Inventario[] inventarios = new Inventario[contador];

    // Agregar producto
    public static void agregarInventario() {
        contador++;
        ultimoId++;

        int id = ultimoId;
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
        Categoria categoria = Categoria.valueOf(
            JOptionPane.showInputDialog("Ingrese la categoría (ej: Maquina, Shampoo, Tijera):")
        );
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock inicial:"));
        int stockMinimo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock mínimo:"));
        double precioCompra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de compra:"));
        double precioVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de venta:"));
        String unidadMedida = JOptionPane.showInputDialog("Ingrese la unidad de medida:");

        Inventario[] nuevo = new Inventario[inventarios.length + 1];
        for (int i = 0; i < inventarios.length; i++) {
            nuevo[i] = inventarios[i];
        }
        inventarios = nuevo;
        inventarios[contador - 1] = new Inventario(id, descripcion, categoria, stock, stockMinimo, precioCompra, precioVenta, unidadMedida);

        JOptionPane.showMessageDialog(null, "✅ Producto agregado correctamente.");
    }

    // Consultar inventario
    public static void consultarInventario() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados.");
        } else {
            String mensaje = "📦 Inventario registrado:\n";
            for (Inventario inv : inventarios) {
                if (inv != null) {
                    mensaje += inv.toString() + "\n----------------------\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    // Editar producto por ID
    public static void editarInventario() {
        int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a editar:"));
        for (int i = 0; i < contador; i++) {
            if (inventarios[i].getId() == idBusqueda) {
                String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripción:");
                Categoria nuevaCategoria = Categoria.valueOf(JOptionPane.showInputDialog("Nueva categoría:"));
                int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock:"));
                int nuevoStockMinimo = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock mínimo:"));
                double nuevoPrecioCompra = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio compra:"));
                double nuevoPrecioVenta = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio venta:"));
                String nuevaUnidadMedida = JOptionPane.showInputDialog("Nueva unidad de medida:");

                inventarios[i] = new Inventario(idBusqueda, nuevaDescripcion, nuevaCategoria, nuevoStock, nuevoStockMinimo, nuevoPrecioCompra, nuevoPrecioVenta, nuevaUnidadMedida);
                JOptionPane.showMessageDialog(null, "✅ Producto editado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "⚠️ No se encontró un producto con ese ID.");
    }

    // Eliminar producto
    public static void eliminarInventario() {
        int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:"));
        for (int i = 0; i < contador; i++) {
            if (inventarios[i].getId() == idBusqueda) {
                inventarios[i] = null;
                JOptionPane.showMessageDialog(null, "❌ Producto eliminado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "⚠️ No se encontró un producto con ese ID.");
    }

    // Calcular valor total del stock
    public static void calcularValorStock() {
        double total = 0;
        for (Inventario inv : inventarios) {
            if (inv != null) {
                total += inv.getStock() * inv.getPrecioVenta();
            }
        }
        JOptionPane.showMessageDialog(null, "💰 Valor total del inventario: " + total);
    }
}