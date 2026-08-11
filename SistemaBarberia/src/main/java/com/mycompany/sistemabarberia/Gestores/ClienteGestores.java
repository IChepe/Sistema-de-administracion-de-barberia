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

        // Todo cliente nuevo entra activo.
        clientes[contador - 1] = new Cliente(id, nombreCli, apellidoCli, telefonoCli, correoCli, fechaNacimientoCli, fechaRegistroCli, notasCli, true);


    }


    public static void consultarClientes() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
        } else {
            String mensaje = "Clientes registrados:\n";
            int activos = 0;
            for (int i = 0; i < contador; i++) {
                // Solo se muestran los que tienen el estado en true.
                if (clientes[i] != null && clientes[i].isEstado()) {
                    mensaje += clientes[i].toString() + "\n";
                    activos++;
                }
            }
            if (activos == 0) {
                JOptionPane.showMessageDialog(null, "No hay clientes activos");
            } else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }


    }

    // Recorre el arreglo y muestra todos los clientes registrados para escoger uno,
    // asi no hay que aprenderse los ID. Devuelve la posicion, o -1 si se cierra.
    public static int seleccionarCliente(String titulo) {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return -1;
        }

        String opciones[] = new String[contador];
        for (int i = 0; i < contador; i++) {
            opciones[i] = clientes[i].getId() + " - " + clientes[i].getNombre() + " " + clientes[i].getApellido()
                    + " (" + (clientes[i].isEstado() ? "Activo" : "Inactivo") + ")";
        }

        return JOptionPane.showOptionDialog(null, "Seleccione el cliente:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

    public static void editarCliente() {

        int i = seleccionarCliente("Editar Cliente");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:");
        String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente:");
        String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo telefono del cliente:");
        String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo del cliente:");
        String nuevaFechaNacimiento = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento del cliente:");
        String nuevasNotas = JOptionPane.showInputDialog("Ingrese las nuevas notas del cliente:");
        clientes[i] = new Cliente(clientes[i].getId(), nuevoNombre, nuevoApellido, nuevoTelefono, nuevoCorreo,
                nuevaFechaNacimiento, clientes[i].getFechaRegistro(), nuevasNotas, clientes[i].isEstado());
        JOptionPane.showMessageDialog(null, "Cliente editado correctamente.");
    }

    public static void eliminarCliente() {

        int i = seleccionarCliente("Eliminar Cliente");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);
    }


    // Eliminado logico: el cliente NO sale del arreglo, solo se le cambia el estado.
    public static void cambiarEstado(int posicion) {

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Cliente: " + clientes[posicion].getNombre() + " " + clientes[posicion].getApellido() + "\n"
                + "Estado actual: " + (clientes[posicion].isEstado() ? "Activo" : "Inactivo") + "\n"
                + "¿Que desea hacer?",
                "Estado del Cliente",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            clientes[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Cliente activado correctamente.");
        } else {
            clientes[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Cliente desactivado correctamente.");
        }

    }



}
