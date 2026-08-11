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

        // ----- Cliente -----
        // Primero se cuentan los activos para saber de que tamaño hacer los arreglos.
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

        // Se recorre todo el arreglo para asociar cada ID con su nombre.
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
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCliente, opcionesCliente[0]);

        if (clienteSeleccionado == JOptionPane.CLOSED_OPTION) {
            return;
        }

        // La posicion del boton escogido es la misma posicion en la lista que se armo.
        Cliente clienteVen = listaCliente[clienteSeleccionado];


        // ----- ¿Servicio o producto? -----
        String queVender[] = { "Servicio", "Producto" };
        int tipoVenta = JOptionPane.showOptionDialog(null, "¿Que desea vender?", "Tipo de Venta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, queVender, queVender[0]);

        if (tipoVenta == JOptionPane.CLOSED_OPTION) {
            return;
        }

        // Segun lo que se venda, se llena uno u otro. El que no se use queda en null.
        Barbero barberoVen = null;
        Servicio servicioVen = null;
        Inventario productoVen = null;
        int cantidadVen = 0;
        double subtotalVen;

        if (tipoVenta == 0) {

            // ----- Barbero: solo se pide cuando se vende un servicio,
            // porque un producto lo despacha cualquiera y no lleva comision -----
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


            // ----- Servicio -----
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
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesServicio, opcionesServicio[0]);

            if (servicioSeleccionado == JOptionPane.CLOSED_OPTION) {
                return;
            }

            servicioVen = listaServicio[servicioSeleccionado];

            // El subtotal sale del precio del servicio, por eso la venta guarda el servicio.
            subtotalVen = servicioVen.getPrecio();

        } else {

            // ----- Producto: solo los activos y que tengan existencias -----
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

            // El subtotal es el precio de venta por la cantidad.
            subtotalVen = productoVen.getPrecioVenta() * cantidadVen;
        }

        // Se piden en porcentaje y aqui se convierten a monto.
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

        // Toda venta nueva entra activa. Si fue de un producto, el servicio queda en null.
        ventas[contador - 1] = new Venta(id, servicioVen, clienteVen, barberoVen, subtotalVen,
                descuentoVen, impuestoVen, totalVen, true, fechaVentaVen);

        // Si se vendio un producto, se anota en la lista de productos vendidos
        // y ahi mismo se le resta la cantidad al stock.
        if (productoVen != null) {
            GestorProductosVendidos.agregarProductoVendido(productoVen, ventas[contador - 1], cantidadVen);
        }

        // Crear la venta es lo mismo que generar la factura.
        generarFactura(contador - 1);

    }


    public static double calcularTotal(double subtotal, double descuento, double impuesto) {

        return subtotal - descuento + impuesto;

    }


    // Lo que se lleva el barbero por el servicio, segun su porcentaje de comision.
    // Si la venta fue de un producto no hay comision, porque no hizo ningun servicio.
    public static double calcularGananciaBarbero(int posicion) {

        if (ventas[posicion].getIdServicio() == null) {
            return 0;
        }

        double precioServicio = ventas[posicion].getIdServicio().getPrecio();
        double comision = ventas[posicion].getIdBarbero().getComision();

        return (precioServicio * comision) / 100;

    }


    // Vuelve a mostrar la factura de una venta ya registrada.
    public static void generarFactura() {

        int i = seleccionarVenta("Generar Factura");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        generarFactura(i);

    }


    public static void generarFactura(int posicion) {

        // El detalle cambia segun si se vendio un servicio o un producto.
        // La venta de producto no lleva barbero, por eso esas lineas solo salen en el servicio.
        String detalle;
        String lineaBarbero = "";
        String lineaComision = "";
        if (ventas[posicion].getIdServicio() != null) {
            detalle = "Servicio: " + ventas[posicion].getIdServicio().getNombreser() + "\n"
                    + "Precio: " + ventas[posicion].getIdServicio().getPrecio() + "\n";
            lineaBarbero = "Barbero: " + ventas[posicion].getIdBarbero().getNombre() + "\n";
            lineaComision = "-----------------------------" + "\n"
                    + "Comision del barbero: " + ventas[posicion].getIdBarbero().getComision() + " %" + "\n"
                    + "Gana el barbero: " + calcularGananciaBarbero(posicion) + "\n";
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

        String factura = "========== FACTURA ==========" + "\n"
                + "Factura N°: " + ventas[posicion].getId() + "\n"
                + "Fecha: " + ventas[posicion].getFechaVenta() + "\n"
                + "-----------------------------" + "\n"
                + "Cliente: " + ventas[posicion].getIdCliente().getNombre() + " "
                + ventas[posicion].getIdCliente().getApellido() + "\n"
                + "Telefono: " + ventas[posicion].getIdCliente().getTelefono() + "\n"
                + lineaBarbero
                + "-----------------------------" + "\n"
                + detalle
                + "-----------------------------" + "\n"
                + "Subtotal: " + ventas[posicion].getSubtotal() + "\n"
                + "Descuento: " + ventas[posicion].getDescuento() + "\n"
                + "Impuesto: " + ventas[posicion].getImpuesto() + "\n"
                + "TOTAL: " + ventas[posicion].getTotal() + "\n"
                + lineaComision
                + "=============================" + "\n"
                + "Estado: " + (ventas[posicion].isEstado() ? "Activa" : "ANULADA");

        JOptionPane.showMessageDialog(null, factura);

    }


    public static void consultarVentas() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas");
        } else {
            String mensaje = "Ventas registradas:\n";
            int activas = 0;
            for (int i = 0; i < contador; i++) {
                // Solo se muestran las que no estan anuladas.
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


    // Recorre el arreglo y muestra todas las ventas registradas para escoger una,
    // asi no hay que aprenderse los ID. Devuelve la posicion, o -1 si se cierra.
    public static int seleccionarVenta(String titulo) {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas");
            return -1;
        }

        String opciones[] = new String[contador];
        for (int i = 0; i < contador; i++) {
            opciones[i] = ventas[i].getId() + " - " + ventas[i].getIdCliente().getNombre()
                    + " - " + ventas[i].getTotal()
                    + " (" + (ventas[i].isEstado() ? "Activa" : "Anulada") + ")";
        }

        return JOptionPane.showOptionDialog(null, "Seleccione la venta:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }


    public static void anularVenta() {

        int i = seleccionarVenta("Anular Venta");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);

    }


    // Anulado logico: la venta NO sale del arreglo, solo se le cambia el estado.
    public static void cambiarEstado(int posicion) {

        String opciones[] = { "Activar", "Anular" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Venta N°: " + ventas[posicion].getId() + "\n"
                + "Cliente: " + ventas[posicion].getIdCliente().getNombre() + "\n"
                + "Total: " + ventas[posicion].getTotal() + "\n"
                + "Estado actual: " + (ventas[posicion].isEstado() ? "Activa" : "Anulada") + "\n"
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
