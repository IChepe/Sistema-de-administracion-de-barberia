package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Inventario;
import com.mycompany.sistemabarberia.Enumeradores.Categoria;

public class InventarioGestores {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static Inventario[] inventarios = new Inventario[contador];



    public static void AgregarInventario(){

        contador++;
        ultimoId++;
        int id = ultimoId;
        String nombreInv = JOptionPane.showInputDialog("Ingrese el nombre del producto");
        String descripcionInv = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
        Categoria categoriaInv = seleccionarCategoria();
        int stockInv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en stock"));
        int stockMinimoInv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock minimo"));
        double precioCompraInv = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de compra"));
        double precioVentaInv = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de venta"));
        String unidadMedidaInv = JOptionPane.showInputDialog("Ingrese la unidad de medida (unidad, ml, gr)");


        Inventario[] copia = new Inventario[inventarios.length + 1];
        for (int i = 0; i < inventarios.length; i++) {
            copia[i] = inventarios[i];
        }
        inventarios = copia;

        // Todo producto nuevo entra activo.
        inventarios[contador - 1] = new Inventario(id, nombreInv, descripcionInv, categoriaInv, stockInv,
                stockMinimoInv, precioCompraInv, precioVentaInv, unidadMedidaInv, true);


    }


    // La categoria sale del enum, no se escribe a mano.
    public static Categoria seleccionarCategoria() {

        Categoria opciones[] = Categoria.values();

        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la categoria:", "Categoria",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return opciones[0];
        }

        return opciones[seleccion];
    }


    public static void consultarInventarios() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados");
        } else {
            String mensaje = "Productos registrados:\n";
            int activos = 0;
            for (int i = 0; i < contador; i++) {
                // Solo se muestran los que tienen el estado en true.
                if (inventarios[i] != null && inventarios[i].isEstado()) {
                    mensaje += inventarios[i].toString() + "\n";
                    activos++;
                }
            }
            if (activos == 0) {
                JOptionPane.showMessageDialog(null, "No hay productos activos");
            } else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }

    }


    // Recorre el arreglo y muestra todos los productos registrados para escoger uno,
    // asi no hay que aprenderse los ID. Devuelve la posicion, o -1 si se cierra.
    public static int seleccionarInventario(String titulo) {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados");
            return -1;
        }

        String opciones[] = new String[contador];
        for (int i = 0; i < contador; i++) {
            opciones[i] = inventarios[i].getId() + " - " + inventarios[i].getNombre()
                    + " (" + (inventarios[i].isEstado() ? "Activo" : "Inactivo") + ")";
        }

        return JOptionPane.showOptionDialog(null, "Seleccione el producto:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }


    public static void editarInventario() {

        int i = seleccionarInventario("Editar Producto");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto:");
        String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripcion del producto:");
        Categoria nuevaCategoria = seleccionarCategoria();
        int nuevoStock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock:"));
        int nuevoStockMinimo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock minimo:"));
        double nuevoPrecioCompra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio de compra:"));
        double nuevoPrecioVenta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio de venta:"));
        String nuevaUnidadMedida = JOptionPane.showInputDialog("Ingrese la nueva unidad de medida:");
        inventarios[i] = new Inventario(inventarios[i].getId(), nuevoNombre, nuevaDescripcion, nuevaCategoria,
                nuevoStock, nuevoStockMinimo, nuevoPrecioCompra, nuevoPrecioVenta, nuevaUnidadMedida, inventarios[i].isEstado());
        JOptionPane.showMessageDialog(null, "Producto editado correctamente.");
    }


    public static void eliminarInventario() {

        int i = seleccionarInventario("Eliminar Producto");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);
    }


    // Eliminado logico: el producto NO sale del arreglo, solo se le cambia el estado.
    public static void cambiarEstado(int posicion) {

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Producto: " + inventarios[posicion].getNombre() + "\n"
                + "Estado actual: " + (inventarios[posicion].isEstado() ? "Activo" : "Inactivo") + "\n"
                + "¿Que desea hacer?",
                "Estado del Producto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            inventarios[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Producto activado correctamente.");
        } else {
            inventarios[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Producto desactivado correctamente.");
        }

    }


    // Muestra los productos que ya llegaron al stock minimo.
    public static void consultarStockBajo() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos registrados");
            return;
        }

        String mensaje = "Productos con stock bajo:\n";
        int bajos = 0;
        for (int i = 0; i < contador; i++) {
            if (inventarios[i].isEstado() && inventarios[i].getStock() <= inventarios[i].getStockMinimo()) {
                mensaje += "\n" + inventarios[i].getNombre()
                        + " - Stock: " + inventarios[i].getStock()
                        + " - Minimo: " + inventarios[i].getStockMinimo() + "\n";
                bajos++;
            }
        }

        if (bajos == 0) {
            JOptionPane.showMessageDialog(null, "Todos los productos tienen stock suficiente");
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }

    }



}
