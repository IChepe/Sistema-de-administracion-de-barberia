/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Gestores;

import com.mycompany.sistemabarberia.Clases.Barbero;
import com.mycompany.sistemabarberia.Clases.Usuario;
import javax.swing.JOptionPane;
/**
 *
 * @author sscr
 */
public class Barberogestores {
    
    public static int COntador = 0;
    public static int ULtimoid = 0;
    public static Barbero[] barbero = new Barbero[COntador];
    
    public static void AgregarBarbero() {
        COntador ++;
        ULtimoid ++;
        
        int id = ULtimoid;
        Usuario idUsuario = null;
        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del barbero: ");
        String fechaRegistro = JOptionPane.showInputDialog("Ingrese la fecha en la que se registro al barbero: ");
        String horario = JOptionPane.showInputDialog("Ingrese el horario del barberp:");
        Double comision = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje de comisión: "));
        int Opcionestado = JOptionPane.showConfirmDialog(null, "El barbero esta disponible?", "Estado de barbero"
                ,JOptionPane.YES_NO_OPTION);
       String estado;
       if(Opcionestado == JOptionPane.YES_OPTION){
           estado = "Disponible";
       }else{
           estado = "No disponible";
       }
       Barbero[] ingresado = new Barbero[barbero.length +1];
       for (int i = 0;  i < barbero.length; i++) {
           ingresado[i] = barbero[i];
       }
       barbero = ingresado;
       barbero[COntador -1] = new Barbero(id, idUsuario, especialidad, fechaRegistro, horario, comision, estado);
    }
     public static void consultarBarbero() {
        if (COntador == 0) {
            JOptionPane.showMessageDialog(null, "No hay barberos registrados");
        } else {
            String mensaje = "Barberos registrados:\n";
            for (int i = 0; i < COntador; i++) {
                if (barbero[i] != null) {
                    mensaje += barbero[i].toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    public static void editarBarbero() {
       String metodos[] = { "Por ID", "Por especialidad" };
        int metodoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar barbero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (metodoSeleccionado == 0) {
            int idBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del barbero a editar:"));
            for (int i = 0; i < COntador; i++) {
                if (barbero[i].getId() == idBusqueda) {
                    int nuevoid = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del barbero:"));
                    String nuevaespecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad:");
                    String nuevafechaRegistro = JOptionPane.showInputDialog("Ingrese la nueva fecha de registro del barbero:");
                    String nuevohorario = JOptionPane.showInputDialog("Ingrese el nuevo horario del barbero:");
                    Double nuevacomision = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nueva comisión: "));
                    int Opcionestado = JOptionPane.showConfirmDialog(null, "El barbero esta disponible?", "Estado de barbero"
                ,JOptionPane.YES_NO_OPTION);
       String nuevoestado;
       if(Opcionestado == JOptionPane.YES_OPTION){
           nuevoestado = "Disponible";
       }else{
           nuevoestado = "No disponible";
                    barbero[i] = new Barbero(nuevoid, nuevaespecialidad, nuevafechaRegistro, nuevohorario, nuevacomision, nuevoestado);
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
                    servicios[i] = new Servicio(servicios[i].getIdServicio(), nuevoNombre, nuevoPrecio, nuevaDuracion, nuevaCategoria);
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
                    eliminarEnPosicion(contador);
                    JOptionPane.showMessageDialog(null, "Servicio eliminado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un servicio con el ID especificado.");
        } else if (metodoSeleccionado == 1) {
            String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del servicio a eliminar:");
            for (int i = 0; i < contador; i++) {
                if (servicios[i].getNombreser().contains(nombreBusqueda)) {
                    eliminarEnPosicion(i);
                    JOptionPane.showMessageDialog(null, "Servicio eliminado correctamente.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un servicio con el nombre especificado.");
        }
    }


    
    public static void eliminarEnPosicion(int posicion) {

        Servicio[] copia = new Servicio[servicios.length - 1];
        int j = 0;
        for (int i = 0; i < servicios.length; i++) {
            if (i != posicion) {
                copia[j] = servicios[i];
                j++;
            }
        }
        servicios = copia;
        contador--;

    }
}
