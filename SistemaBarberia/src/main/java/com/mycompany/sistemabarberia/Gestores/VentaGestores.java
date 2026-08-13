package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Barbero;
import com.mycompany.sistemabarberia.Clases.Cliente;
import com.mycompany.sistemabarberia.Clases.Inventario;
import com.mycompany.sistemabarberia.Clases.ProductoVendido;
import com.mycompany.sistemabarberia.Clases.Servicio;
import com.mycompany.sistemabarberia.Clases.Venta;

public class VentaGestores {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static Venta[] ventas = new Venta[contador];



    public static void crearVenta(){

        int clientesActivos = 0;
        for (int i = 0; i < ClienteGestores.contador; i++) {
            if (ClienteGestores.clientes[i].isEstado()) {
                clientesActivos++;
            }
        }
        if (clientesActivos == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return;
        }

        String opcionesCliente[] = new String[clientesActivos];
        Cliente listaCliente[] = new Cliente[clientesActivos];
        int j = 0;
        for (int i = 0; i < ClienteGestores.contador; i++) {
            if (ClienteGestores.clientes[i].isEstado()) {
                opcionesCliente[j] = ClienteGestores.clientes[i].getId() + " - "
                        + ClienteGestores.clientes[i].getNombre() + " "
                        + ClienteGestores.clientes[i].getApellido();
                listaCliente[j] = ClienteGestores.clientes[i];
                j++;
            }
        }

        int clienteSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el cliente:", "Clientes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opcionesCliente, opcionesCliente[0]);

        if (clienteSeleccionado == JOptionPane.CLOSED_OPTION) {
            return;
        }

        
        Cliente clienteVen = listaCliente[clienteSeleccionado];


        String queVender[] = { "Servicio", "Producto" };
        int tipoVenta = JOptionPane.showOptionDialog(null, "¿Que desea vender?", "Tipo de Venta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                queVender, queVender[0]);

        if (tipoVenta == JOptionPane.CLOSED_OPTION) {
            return;
        }

       
        Barbero barberoVen = null;
        Servicio servicioVen = null;
        Inventario productoVen = null;
        int cantidadVen = 0;
        double subtotalVen;

        if (tipoVenta == 0) {

           
            int barberosActivos = 0;
            for (int i = 0; i < Barberogestores.COntador; i++) {
                if (Barberogestores.barbero[i].isEstadousuario()) {
                    barberosActivos++;
                }
            }
            if (barberosActivos == 0) {
                JOptionPane.showMessageDialog(null, "No hay barberos registrados");
                return;
            }
            String opcionesBarbero[] = new String[barberosActivos];
            Barbero listaBarbero[] = new Barbero[barberosActivos];
            j = 0;
            for (int i = 0; i < Barberogestores.COntador; i++) {
                if (Barberogestores.barbero[i].isEstadousuario()) {
                    opcionesBarbero[j] = Barberogestores.barbero[i].getId() + " - "
                            + Barberogestores.barbero[i].getNombre();
                    listaBarbero[j] = Barberogestores.barbero[i];
                    j++;
                }
            }

            int barberoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el barbero:", "Barberos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesBarbero, opcionesBarbero[0]);

            if (barberoSeleccionado == JOptionPane.CLOSED_OPTION) {
                return;
            }

            barberoVen = listaBarbero[barberoSeleccionado];
            int serviciosActivos = 0;
            for (int i = 0; i < ServicioGestores.contador; i++) {
                if (ServicioGestores.servicios[i].isEstado()) {
                    serviciosActivos++;
                }
            }
            if (serviciosActivos == 0) {
                JOptionPane.showMessageDialog(null, "No hay servicios registrados");
                return;
            }

            String opcionesServicio[] = new String[serviciosActivos];
            Servicio listaServicio[] = new Servicio[serviciosActivos];
            j = 0;
            for (int i = 0; i < ServicioGestores.contador; i++) {
                if (ServicioGestores.servicios[i].isEstado()) {
                    opcionesServicio[j] = ServicioGestores.servicios[i].getIdServicio() + " - "
                            + ServicioGestores.servicios[i].getNombreser() + " ("
                            + ServicioGestores.servicios[i].getPrecio() + ")";
                    listaServicio[j] = ServicioGestores.servicios[i];
                    j++;
                }
            }

            int servicioSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el servicio:", "Servicios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcionesServicio, opcionesServicio[0]);

            if (servicioSeleccionado == JOptionPane.CLOSED_OPTION) {
                return;
            }

            servicioVen = listaServicio[servicioSeleccionado];
            subtotalVen = servicioVen.getPrecio();

        } else {
            int productosActivos = 0;
            for (int i = 0; i < InventarioGestores.contador; i++) {
                if (InventarioGestores.inventarios[i].isEstado() && InventarioGestores.inventarios[i].getStock() > 0) {
                    productosActivos++;
                }
            }
            if (productosActivos == 0) {
                JOptionPane.showMessageDialog(null, "No hay productos con existencias");
                return;
            }

            String opcionesProducto[] = new String[productosActivos];
            Inventario listaProducto[] = new Inventario[productosActivos];
            j = 0;
            for (int i = 0; i < InventarioGestores.contador; i++) {
                if (InventarioGestores.inventarios[i].isEstado() && InventarioGestores.inventarios[i].getStock() > 0) {
                    opcionesProducto[j] = InventarioGestores.inventarios[i].getId() + " - "
                            + InventarioGestores.inventarios[i].getNombre() + " ("
                            + InventarioGestores.inventarios[i].getPrecioVenta() + ") - Stock: "
                            + InventarioGestores.inventarios[i].getStock();
                    listaProducto[j] = InventarioGestores.inventarios[i];
                    j++;
                }
            }

            int productoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el producto:", "Productos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesProducto, opcionesProducto[0]);

            if (productoSeleccionado == JOptionPane.CLOSED_OPTION) {
                return;
            }

            productoVen = listaProducto[productoSeleccionado];

            cantidadVen = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad de " + productoVen.getNombre() + " que va a vender"
                    + "\n(hay " + productoVen.getStock() + " en existencia):"));

            if (cantidadVen <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero.");
                return;
            }

            if (cantidadVen > productoVen.getStock()) {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock."
                        + "\nPidio " + cantidadVen + " y solo hay " + productoVen.getStock() + ".");
                return;
            }

            
            subtotalVen = productoVen.getPrecioVenta() * cantidadVen;
        }

        
        double porcentajeDescuento = Double.parseDouble(JOptionPane.showInputDialog(
                "Ingrese el porcentaje de descuento\n(numero entero, ejemplo: 10 para un 10%)\nEscriba 0 si no lleva descuento:"));
        double porcentajeImpuesto = Double.parseDouble(JOptionPane.showInputDialog(
                "Ingrese el porcentaje de impuesto\n(numero entero, ejemplo: 13 para un 13%)\nEscriba 0 si no lleva impuesto:"));

        double descuentoVen = (subtotalVen * porcentajeDescuento) / 100;
        double impuestoVen = ((subtotalVen - descuentoVen) * porcentajeImpuesto) / 100;
        double totalVen = calcularTotal(subtotalVen, descuentoVen, impuestoVen);
        String fechaVentaVen = JOptionPane.showInputDialog("Ingrese la fecha de la venta (dd/mm/aaaa):");

        contador++;
        ultimoId++;
        int id = ultimoId;

        Venta[] copia = new Venta[ventas.length + 1];
        for (int i = 0; i < ventas.length; i++) {
            copia[i] = ventas[i];
        }
        ventas = copia;

        
        ventas[contador - 1] = new Venta(id, servicioVen, clienteVen, barberoVen, subtotalVen,
                descuentoVen, impuestoVen, totalVen, true, fechaVentaVen);

        
        if (productoVen != null) {
            GestorProductosVendidos.agregarProductoVendido(productoVen, ventas[contador - 1],
                    cantidadVen);
        }

        
        generarFactura(contador - 1);

    }


    public static double calcularTotal(double subtotal, double descuento, double impuesto) {

        return subtotal - descuento + impuesto;

    }
    public static double CalcularGananciaBarbero(int posicion) {

        if (ventas[posicion].getIdServicio() == null) {
            return 0;
        }

        double precioServicio = ventas[posicion].getIdServicio().getPrecio();
        double comision = ventas[posicion].getIdBarbero().getComision();

        return (precioServicio * comision) / 100;

    }
    public static void GenerarFactura() {
        int i = SeleccionarVenta("Generar Factura", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        generarFactura(i);

    }


    public static void generarFactura(int posicion) {
        String detalle;
        String LineaBarbero = "";
        String LineaComision = "";
        if (ventas[posicion].getIdServicio() != null) {
            detalle = "Servicio: " + ventas[posicion].getIdServicio().getNombreser() + "\n"
                    + "Precio: " + ventas[posicion].getIdServicio().getPrecio() + "\n";
            LineaBarbero = "Barbero: " + ventas[posicion].getIdBarbero().getNombre() + "\n";
            LineaComision = "-----------------------------" + "\n"
                    + "Comision del barbero: " + ventas[posicion].getIdBarbero().getComision() + " %" + "\n"
                    + "Gana el barbero: " + CalcularGananciaBarbero(posicion) + "\n";
        } else {
            ProductoVendido vendido = GestorProductosVendidos.buscarPorVenta(ventas[posicion].getId());
            if (vendido != null) {
                detalle = "Producto: " + vendido.getInventario().getNombre() + "\n"
                        + "Precio unitario: " + vendido.getPrecioUnitario() + "\n"
                        + "Cantidad: " + vendido.getCantidad() + "\n";
            } else {
                detalle = "Sin detalle\n";
            }
        }
        String Estadofact = "";
        if (ventas[posicion].isEstado()){
            Estadofact = "Activa";
        }else{
            Estadofact = "Anulada";
        }

        String factura = "========== FACTURA ==========" + "\n"
                + "Factura N°: " + ventas[posicion].getId() + "\n"
                + "Fecha: " + ventas[posicion].getFechaVenta() + "\n"
                + "-----------------------------" + "\n"
                + "Cliente: " + ventas[posicion].getIdCliente().getNombre() + " "
                + ventas[posicion].getIdCliente().getApellido() + "\n"
                + "Telefono: " + ventas[posicion].getIdCliente().getTelefono() + "\n"
                + LineaBarbero
                + "-----------------------------" + "\n"
                + detalle
                + "-----------------------------" + "\n"
                + "Subtotal: " + ventas[posicion].getSubtotal() + "\n"
                + "Descuento: " + ventas[posicion].getDescuento() + "\n"
                + "Impuesto: " + ventas[posicion].getImpuesto() + "\n"
                + "TOTAL: " + ventas[posicion].getTotal() + "\n"
                + LineaComision
                + "=============================" + "\n"
                + "Estado: " + Estadofact;

        JOptionPane.showMessageDialog(null, factura);

    }
    public static void consultarVentas() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas");
        } else {
            String mensaje = "Ventas registradas:\n";
            int activas = 0;
            for (int i = 0; i < contador; i++) {
                if (ventas[i] != null && ventas[i].isEstado()) {
                    mensaje += ventas[i].toString() + "\n";
                    activas++;
                }
            }
            if (activas == 0) {
                JOptionPane.showMessageDialog(null, "No hay ventas activas");
            } else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }

    }
    public static int SeleccionarVenta(String titulo, boolean soloActivas) {

        
        int disponibles = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivas || ventas[i].isEstado()) {
                disponibles++;
            }
        }

        if (disponibles == 0) {
            JOptionPane.showMessageDialog(null, "No hay ventas para mostrar");
            return -1;
        }

        
        String opciones[] = new String[disponibles];
        int posiciones[] = new int[disponibles];
        int j = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivas || ventas[i].isEstado()) {
               String estadotexto = "";
                if (ventas[i].isEstado()){
                    estadotexto = "Activo";
                }else{
                    estadotexto = "Anulada";
                }
                opciones[j] = ventas[i].getId() + " - " + ventas[i].getIdCliente().getNombre()
                        + " - " + ventas[i].getTotal()
                        + " (" + estadotexto + ")";
                posiciones[j] = i;
                j++;
            }
        }

        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la venta:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return -1;
        }

        return posiciones[seleccion];
    }
    public static void anularVenta() {
        int i = SeleccionarVenta("Anular Venta", false);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);

    }

    public static void cambiarEstado(int posicion) {

        String estadoactual = "";
        if(ventas[posicion].isEstado()){
            estadoactual = "Activo";
        }else{
            estadoactual = "Anulada";
        }
        String opciones[] = { "Activar", "Anular" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Venta N°: " + ventas[posicion].getId() + "\n"
                + "Cliente: " + ventas[posicion].getIdCliente().getNombre() + "\n"
                + "Total: " + ventas[posicion].getTotal() + "\n"
                + "Estado actual: " + estadoactual + "\n"
                + "¿Que desea hacer?",
                "Estado de la Venta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            ventas[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Venta activada correctamente.");
        } else {
            ventas[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Venta anulada correctamente.");
        }

    }



}
