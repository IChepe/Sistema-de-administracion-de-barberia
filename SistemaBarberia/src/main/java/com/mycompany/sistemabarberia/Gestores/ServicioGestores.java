package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Servicio;

public class ServicioGestores {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static Servicio[] servicios = new Servicio[contador];



    public static void AgregarServicio(){

        contador++;
        ultimoId++;
        int id = ultimoId;
        String nombreSer = JOptionPane.showInputDialog("Ingrese el nombre del servicio");
        double precioSer = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del servicio"));
        int duracionSer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración del servicio en minutos"));
        String categoriaSer = JOptionPane.showInputDialog("Ingrese la categoría del servicio");

        
        Servicio[] copia = new Servicio[servicios.length + 1];
        for (int i = 0; i < servicios.length; i++) {
            copia[i] = servicios[i];
        }
        servicios = copia;

        // Todo servicio nuevo entra activo.
        servicios[contador - 1] = new Servicio(id, nombreSer, precioSer, duracionSer, categoriaSer, true);


    }


    public static void consultarServicios() {
      
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay servicios registrados");
        } else {
            String mensaje = "Servicios registrados:\n";
            int activos = 0;
            for (int i = 0; i < contador; i++) {
                // Solo se muestran los que tienen el estado en true.
                if (servicios[i] != null && servicios[i].isEstado()) {
                    mensaje += servicios[i].toString() + "\n";
                    activos++;
                }
            }
            if (activos == 0) {
                JOptionPane.showMessageDialog(null, "No hay servicios activos");
            } else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }


    }

    // Recorre el arreglo y muestra todos los servicios registrados para escoger uno,
    // asi no hay que aprenderse los ID. Devuelve la posicion, o -1 si se cierra.
    public static int seleccionarServicio(String titulo, boolean soloActivos) {

        // Primero se cuentan los que se van a mostrar.
        int disponibles = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivos || servicios[i].isEstado()) {
                disponibles++;
            }
        }

        if (disponibles == 0) {
            JOptionPane.showMessageDialog(null, "No hay servicios para mostrar");
            return -1;
        }

        // El arreglo posiciones guarda en que lugar del arreglo original quedo cada opcion.
        String opciones[] = new String[disponibles];
        int posiciones[] = new int[disponibles];
        int j = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivos || servicios[i].isEstado()) {
                opciones[j] = servicios[i].getIdServicio() + " - " + servicios[i].getNombreser()
                        + " (" + (servicios[i].isEstado() ? "Activo" : "Inactivo") + ")";
                posiciones[j] = i;
                j++;
            }
        }

        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el servicio:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return -1;
        }

        return posiciones[seleccion];
    }

    public static void editarServicio() {

        int i = seleccionarServicio("Editar Servicio", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del servicio:");
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del servicio:"));
        int nuevaDuracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva duración del servicio:"));
        String nuevaCategoria = JOptionPane.showInputDialog("Ingrese la nueva categoría del servicio:");
        servicios[i] = new Servicio(servicios[i].getIdServicio(), nuevoNombre, nuevoPrecio, nuevaDuracion, nuevaCategoria, servicios[i].isEstado());
        JOptionPane.showMessageDialog(null, "Servicio editado correctamente.");
    }

    public static void eliminarServicio() {

        // Aqui se muestran todos, porque es la unica forma de volver a activar uno.
        int i = seleccionarServicio("Eliminar Servicio", false);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);
    }


    // Eliminado logico: el servicio NO sale del arreglo, solo se le cambia el estado.
    public static void cambiarEstado(int posicion) {

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Servicio: " + servicios[posicion].getNombreser() + "\n"
                + "Estado actual: " + (servicios[posicion].isEstado() ? "Activo" : "Inactivo") + "\n"
                + "¿Que desea hacer?",
                "Estado del Servicio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            servicios[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Servicio activado correctamente.");
        } else {
            servicios[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Servicio desactivado correctamente.");
        }

    }



}