package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Citas;
import com.mycompany.sistemabarberia.Clases.Cliente;
import com.mycompany.sistemabarberia.Clases.Inventario;
import com.mycompany.sistemabarberia.Clases.Reporte;
import com.mycompany.sistemabarberia.Clases.Venta;
import com.mycompany.sistemabarberia.Enumeradores.Tipo;

public class ReporteGestores {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static Reporte[] reportes = new Reporte[contador];



    public static void crearReporte(){

        Tipo tipoRep = seleccionarTipo();
        if (tipoRep == null) {
            return;
        }
        Inventario inventarioRep = null;
        Venta ventaRep = null;
        Citas citaRep = null;
        Cliente clienteRep = null;

        if (tipoRep == Tipo.Venta) {

            int posicion = VentaGestores.SeleccionarVenta("Reporte de Venta", true);
            if (posicion == JOptionPane.CLOSED_OPTION) {
                return;
            }
            ventaRep = VentaGestores.ventas[posicion];
            clienteRep = ventaRep.getIdCliente();

        } else if (tipoRep == Tipo.Cita) {

            int posicion = CitasGestores.seleccionarCita("Reporte de Cita");
            if (posicion == JOptionPane.CLOSED_OPTION) {
                return;
            }
            citaRep = CitasGestores.citas[posicion];
            clienteRep = citaRep.getCliente();

        } else {
            int posicion = InventarioGestores.seleccionarInventario("Reporte de " 
                    + tipoRep, true);
            if (posicion == JOptionPane.CLOSED_OPTION) {
                return;
            }
            inventarioRep = InventarioGestores.inventarios[posicion];

        }

        contador++;
        ultimoId++;
        int id = ultimoId;

        Reporte[] copia = new Reporte[reportes.length + 1];
        for (int i = 0; i < reportes.length; i++) {
            copia[i] = reportes[i];
        }
        reportes = copia;

        reportes[contador - 1] = new Reporte(id, tipoRep, inventarioRep, ventaRep,
                citaRep, clienteRep, true);

        generar(contador - 1);

    }


    public static Tipo seleccionarTipo() {

        Tipo opciones[] = {Tipo.Venta, Tipo.Cita, Tipo.Producto, Tipo.Inventario};

        int seleccion = JOptionPane.showOptionDialog(null, "¿Que tipo de reporte desea generar?", "Tipo de Reporte",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return null;
        }

        return opciones[seleccion];
    }


    public static void generar(int posicion) {

        String mensaje = "";

        switch (reportes[posicion].getTipos()) {

            case Venta:
                Venta laVenta = reportes[posicion].getIdVenta();
                String Vendido = "";
                if (laVenta.isEstado()){
                    Vendido = laVenta.getIdServicio().getNombreser();
                }else{
                    Vendido = "Producto";
                }
                
                
                String Estadoventa = "";
                if (laVenta.isEstado()){
                    Estadoventa = "Activo";
                }else{
                    Estadoventa = "Anulada";
                }
                
                mensaje = "===== Reporte de Venta =====" + "\n"
                        + "Reporte N°: " + reportes[posicion].getId() + "\n"
                        + "-----------------------------" + "\n"
                        + "Venta N°: " + laVenta.getId() + "\n"
                        + "Fecha: " + laVenta.getFechaVenta() + "\n"
                        + "Cliente: " + laVenta.getIdCliente().getNombre() + " "
                        + laVenta.getIdCliente().getApellido() + "\n"
                        + "Vendio: " + Vendido + "\n"
                        + "Subtotal: " + laVenta.getSubtotal() + "\n"
                        + "Descuento: " + laVenta.getDescuento() + "\n"
                        + "Impuesto: " + laVenta.getImpuesto() + "\n"
                        + "Total: " + laVenta.getTotal() + "\n"
                        + "Estado: " + Estadoventa + "\n";
                break;

            case Cita:
                Citas laCita = reportes[posicion].getIdCita();
                mensaje = "===== Reporte de Cita =====" + "\n"
                        + "Reporte N°: " + reportes[posicion].getId() + "\n"
                        + "-----------------------------" + "\n"
                        + "Cita N°: " + laCita.getIdCita() + "\n"
                        + "Cliente: " + laCita.getCliente().getNombre() + " "
                        + laCita.getCliente().getApellido() + "\n"
                        + "Barbero: " + laCita.getBarbero().getNombre() + "\n"
                        + "Dia: " + laCita.getFecha() + "\n"
                        + "Hora: " + laCita.getHora() + "\n"
                        + "Duracion: " + laCita.getDuracion() + " min" + "\n"
                        + "Estado: " + laCita.getEstado() + "\n";
                break;

            case Producto:
                Inventario elProducto = reportes[posicion].getIdInventario();
                mensaje = "===== Reporte de Producto =====" + "\n"
                        + "Reporte N°: " + reportes[posicion].getId() + "\n"
                        + "-----------------------------" + "\n"
                        + "Producto N°: " + elProducto.getId() + "\n"
                        + "Nombre: " + elProducto.getNombre() + "\n"
                        + "Descripcion: " + elProducto.getDescripcion() + "\n"
                        + "Categoria: " + elProducto.getCategoria() + "\n"
                        + "Precio de compra: " + elProducto.getPrecioCompra() + "\n"
                        + "Precio de venta: " + elProducto.getPrecioVenta() + "\n"
                        + "Ganancia por unidad: "
                        + (elProducto.getPrecioVenta() - elProducto.getPrecioCompra()) + "\n";
                break;

            case Inventario:
                Inventario enBodega = reportes[posicion].getIdInventario();
                   String Estadostock= "";
                if(enBodega.getStock() <= enBodega.getStockMinimo()){
                    Estadostock = "Hay que reabastecer el stock";
                }else{ 
                    Estadostock = "Stock suficiente";
                }
                mensaje = "===== Reporte de Inventario =====" + "\n"
                        + "Reporte N°: " + reportes[posicion].getId() + "\n"
                        + "-----------------------------" + "\n"
                        + "Producto: " + enBodega.getNombre() + "\n"
                        + "Stock actual: " + enBodega.getStock() + " " + enBodega.getUnidadMedida() + "\n"
                        + "Stock minimo: " + enBodega.getStockMinimo() + "\n"
                        + "Valor en bodega: " + (enBodega.getStock() * enBodega.getPrecioCompra()) + "\n"
                        + "-----------------------------" + "\n"
                        + Estadostock + "\n";
                break;
        }

        JOptionPane.showMessageDialog(null, mensaje);

    }


    public static String sobreQue(int posicion) {

        switch (reportes[posicion].getTipos()) {
            case Venta:
                return "Venta N° " + reportes[posicion].getIdVenta().getId();
            case Cita:
                return "Cita N° " + reportes[posicion].getIdCita().getIdCita();
            case Producto:
                return reportes[posicion].getIdInventario().getNombre();
            case Inventario:
                return reportes[posicion].getIdInventario().getNombre();
            default:
                return "Sin asignar";
        }
    }


    public static void consultarReportes() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay reportes registrados");
        } else {
            String mensaje = "Reportes registrados:\n";
            int activos = 0;
            for (int i = 0; i < contador; i++) {
                if (reportes[i] != null && reportes[i].isEstado()) {
                    mensaje += "\n----- Reporte " + reportes[i].getId() + " -----"
                            + "\nTipo: " + reportes[i].getTipos()
                            + "\nSobre: " + sobreQue(i) + "\n";
                    activos++;
                }
            }
            if (activos == 0) {
                JOptionPane.showMessageDialog(null, "No hay reportes activos");
            } else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }

    }


    public static int seleccionarReporte(String titulo, boolean soloActivos) {

        int disponibles = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivos || reportes[i].isEstado()) {
                disponibles++;
            }
        }

        if (disponibles == 0) {
            JOptionPane.showMessageDialog(null, "No hay reportes para mostrar");
            return -1;
        }

        String opciones[] = new String[disponibles];
        int posiciones[] = new int[disponibles];
        int j = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivos || reportes[i].isEstado()) {
                String Estadotexto= "";
                if(reportes[i].isEstado()){
                    Estadotexto = "Activa";
                }else{ 
                    Estadotexto = "Inactiva";
                }
                opciones[j] = reportes[i].getId() + " - " + reportes[i].getTipos()
                        + " - " + sobreQue(i)
                        + " (" + Estadotexto + ")";
                posiciones[j] = i;
                j++;
            }
        }

        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el reporte:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return -1;
        }

        return posiciones[seleccion];
    }


    public static void generar() {

        int i = seleccionarReporte("Ver Reporte", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }
        generar(i);
    }
    public static void eliminarReporte() {

        int i = seleccionarReporte("Eliminar Reporte", false);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);
    }


    public static void cambiarEstado(int posicion) {
         String Estadoactual = "";
        if (reportes[posicion].isEstado()){
            Estadoactual = "Activo";
        }else{
            Estadoactual = "Inactivo";
        }

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Reporte N°: " + reportes[posicion].getId() + "\n"
                + "Tipo: " + reportes[posicion].getTipos() + "\n"
                + "Sobre: " + sobreQue(posicion) + "\n"
                + "Estado actual: " + Estadoactual + "\n"
                + "¿Que desea hacer?",
                "Estado del Reporte",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            reportes[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Reporte activado correctamente.");
        } else {
            reportes[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Reporte desactivado correctamente.");
        }

    }



}
