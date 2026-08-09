package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Cliente;

public class ClienteGestores {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static Cliente[] clientes = new Cliente[contador];



    public static void AgregarCliente(){

        contador++;
        ultimoId++;
        int id = ultimoId;
        String nombreCli = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
        String apellidoCli = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
        String telefonoCli = JOptionPane.showInputDialog("Ingrese el telefono del cliente");
        String correoCli = JOptionPane.showInputDialog("Ingrese el correo del cliente");
        String fechaNacimientoCli = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del cliente (dd/mm/aaaa)");
        String fechaRegistroCli = JOptionPane.showInputDialog("Ingrese la fecha de registro del cliente (dd/mm/aaaa)");
        String notasCli = JOptionPane.showInputDialog("Ingrese las notas del cliente");


        Cliente[] copia = new Cliente[clientes.length + 1];
        for (int i = 0; i < clientes.length; i++) {
            copia[i] = clientes[i];
        }
        clientes = copia;

        clientes[contador - 1] = new Cliente(id, nombreCli, apellidoCli, telefonoCli, correoCli, fechaNacimientoCli, fechaRegistroCli, notasCli);


    }


    public static void consultarClientes() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
        } else {
            String mensaje = "Clientes registrados:\n";
            for (int i = 0; i < contador; i++) {
                if (clientes[i] != null) {
                    mensaje += clientes[i].toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }


    }

    public static void editarCliente() {
        String metodos[] = { "Por ID", "Por Nombre" };
        int metodoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar Cliente",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (metodoSeleccionado == 0) {
            int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a editar:"));
            for (int i = 0; i < contador; i++) {
                if (clientes[i].getId() == idBusqueda) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
                    String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente:");
                    String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo telefono del cliente:");
                    String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo del cliente:");
                    String nuevaFechaNacimiento = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento del cliente:");
                    String nuevasNotas = JOptionPane.showInputDialog("Ingrese las nuevas notas del cliente:");
                    clientes[i] = new Cliente(idBusqueda, nuevoNombre, nuevoApellido, nuevoTelefono, nuevoCorreo,
                            nuevaFechaNacimiento, clientes[i].getFechaRegistro(), nuevasNotas);
                    JOptionPane.showMessageDialog(null, "Cliente editado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con el ID especificado.");
        } else if (metodoSeleccionado == 1) {
            String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del cliente a editar:");
            for (int i = 0; i < contador; i++) {
                if (clientes[i].getNombre().contains(nombreBusqueda)) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
                    String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente:");
                    String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo telefono del cliente:");
                    String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo del cliente:");
                    String nuevaFechaNacimiento = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento del cliente:");
                    String nuevasNotas = JOptionPane.showInputDialog("Ingrese las nuevas notas del cliente:");
                    clientes[i] = new Cliente(clientes[i].getId(), nuevoNombre, nuevoApellido, nuevoTelefono, nuevoCorreo,
                            nuevaFechaNacimiento, clientes[i].getFechaRegistro(), nuevasNotas);
                    JOptionPane.showMessageDialog(null, "Cliente editado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con el nombre especificado.");
        }
    }

    public static void eliminarCliente() {
        String metodos[] = { "Por ID", "Por Nombre" };
        int metodoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar Cliente",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (metodoSeleccionado == 0) {
            int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar:"));
            for (int i = 0; i < contador; i++) {
                if (clientes[i].getId() == idBusqueda) {
                    eliminarEnPosicion(i);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con el ID especificado.");
        } else if (metodoSeleccionado == 1) {
            String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del cliente a eliminar:");
            for (int i = 0; i < contador; i++) {
                if (clientes[i].getNombre().contains(nombreBusqueda)) {
                    eliminarEnPosicion(i);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un cliente con el nombre especificado.");
        }
    }



    public static void eliminarEnPosicion(int posicion) {

        Cliente[] copia = new Cliente[clientes.length - 1];
        int j = 0;
        for (int i = 0; i < clientes.length; i++) {
            if (i != posicion) {
                copia[j] = clientes[i];
                j++;
            }
        }
        clientes = copia;
        contador--;

    }



}
