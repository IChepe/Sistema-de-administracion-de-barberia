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

    public static void editarServicio() {
       String metodos[] = { "Por ID", "Por Nombre" };
        int metodoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar Servicio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (metodoSeleccionado == 0) {
            int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio a editar:"));
            for (int i = 0; i < contador; i++) {
                if (servicios[i].getIdServicio() == idBusqueda) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del servicio:");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del servicio:"));
                    int nuevaDuracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva duración del servicio:"));
                    String nuevaCategoria = JOptionPane.showInputDialog("Ingrese la nueva categoría del servicio:");
                    servicios[i] = new Servicio(idBusqueda, nuevoNombre, nuevoPrecio, nuevaDuracion, nuevaCategoria, servicios[i].isEstado());
                    JOptionPane.showMessageDialog(null, "Servicio editado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un servicio con el ID especificado.");
        } else if (metodoSeleccionado == 1) {
            String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del servicio a editar:");
            for (int i = 0; i < contador; i++) {
                if (servicios[i].getNombreser().contains(nombreBusqueda)) {
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del servicio:");
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del servicio:"));
                    int nuevaDuracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva duración del servicio:"));
                    String nuevaCategoria = JOptionPane.showInputDialog("Ingrese la nueva categoría del servicio:");
                    servicios[i] = new Servicio(servicios[i].getIdServicio(), nuevoNombre, nuevoPrecio, nuevaDuracion, nuevaCategoria, servicios[i].isEstado());
                    JOptionPane.showMessageDialog(null, "Servicio editado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un servicio con el nombre especificado.");
        }
    }

    public static void eliminarServicio() {
        String metodos[] = { "Por ID", "Por Nombre" };
        int metodoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar Servicio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (metodoSeleccionado == 0) {
            int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio a eliminar:"));
            for (int i = 0; i < contador; i++) {
                if (servicios[i].getIdServicio() == idBusqueda) {
                    cambiarEstado(i);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un servicio con el ID especificado.");
        } else if (metodoSeleccionado == 1) {
            String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del servicio a eliminar:");
            for (int i = 0; i < contador; i++) {
                if (servicios[i].getNombreser().contains(nombreBusqueda)) {
                    cambiarEstado(i);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un servicio con el nombre especificado.");
        }
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