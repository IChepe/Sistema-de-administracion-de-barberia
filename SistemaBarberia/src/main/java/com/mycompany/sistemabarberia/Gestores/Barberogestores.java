/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Gestores;

import com.mycompany.sistemabarberia.Clases.Barbero;
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
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del barbero: ");
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
       barbero[COntador -1] = new Barbero(id,nombre, especialidad, fechaRegistro, horario, comision, estado, true);
       
    }
     public static void consultarbarbero() {
        if (COntador == 0) {
            JOptionPane.showMessageDialog(null, "No hay barberos registrados");
        } else {
            String mensaje = "Barberos registrados:\n";
            int Activos = 0;
            for (int i = 0; i < COntador; i++) {
                if (barbero[i] != null && barbero[i].isEstadousuario()) {
                    mensaje += barbero[i].toString() + "\n";
                    Activos++;
                }
            }
            if (Activos == 0){
                JOptionPane.showMessageDialog(null, "No hay barberos activos");
            }else{
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }
    }

    public static void editarbarbero() {
       String metodos[] = { "Por ID", "Por nombre" };
        int metodoseleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar barbero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (metodoseleccionado == 0) {
            int idBUsqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del barbero a editar:"));
            for (int i = 0; i < COntador; i++) {
                if (barbero[i].getId() == idBUsqueda) {
                    int nuevoid = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del barbero:"));
                    String nuevonombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del barbero: ");
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
       }
                    barbero[i] = new Barbero(nuevoid, nuevonombre, nuevaespecialidad, nuevafechaRegistro, nuevohorario,
                            nuevacomision,nuevoestado, true);
                    JOptionPane.showMessageDialog(null, "Barbero editado correctamente.");
                    return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro un barbero con eee ID.");
        
        }else if(metodoseleccionado == 1){
            String nombrebusqueda = JOptionPane.showInputDialog("Ingrese el nombre del barbero a editar:");
            for (int i = 0; i < COntador; i++) {
                if (barbero[i].getNombre().contains(nombrebusqueda)) {
                    int nuevoid = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del barbero:"));
                    String nuevonombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del barbero: ");
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
            }
                    barbero[i] = new Barbero(nuevoid, nuevonombre, nuevaespecialidad, nuevafechaRegistro, nuevohorario, nuevacomision, nuevoestado, true);
                    JOptionPane.showMessageDialog(null, "Barbero editado correctamente.");
                    return;
            }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un barbero con ese nombre.");
        }
    }
    public static void eliminarbarbero() {
        String metodos[] = { "Por ID", "Por Nombre" };
        int Metodoseleccionado = JOptionPane.showOptionDialog(null, "Seleccione el metodo de busqueda:", "Buscar barbero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, metodos, metodos[0]);
        if (Metodoseleccionado == 0) {
            int IDbusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del barbero a eliminar:"));
            for (int i = 0; i < COntador; i++) {
                if (barbero[i].getId() == IDbusqueda) {
                    cambiarestado(i);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un barbero con ee ID.");
        } else if (Metodoseleccionado == 1) {
            String Nombrebusqueda = JOptionPane.showInputDialog("Ingrese el nombre del barbero a eliminar:");
            for (int i = 0; i < COntador; i++) {
                if (barbero[i].getNombre().contains(Nombrebusqueda)) {
                    cambiarestado(i);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No se encontro un barbero con ee nombre especificado.");
        }
    }
    public static void calcularcomision() {
        int IDbusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del barbero: "));
        for (int i = 0; i < COntador; i++){
            if (barbero[i].getId() == IDbusqueda){
                double precioservicio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del servicio realizado: "));
                double ganancia = (precioservicio * barbero[i].getComision())/ 100;
                
                JOptionPane.showMessageDialog(null, "Cálculo de comisión: "
                        +"\n\n Barbero ID: "+ barbero[i].getId()
                        +"\n Comisión del barbero: "+ barbero[i].getComision()+" %"
                        +"\n Total ganado: "+ ganancia);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro un barberoc on ese ID");
    }
    public static void consultaragenda(){
        int IDBusqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del barbero: "));
        for (int i = 0; i < COntador; i++){
            if (barbero[i].getId() == IDBusqueda){
                JOptionPane.showMessageDialog(null, "Agenda del barbero"
                        +"\n\n ID: "+ barbero[i].getId() 
                        +"\n Especialidad: "+ barbero[i].getEspecialidad()
                        +"\n Horario: "+ barbero[i].getHorario()
                        +"\n Estado actual: "+ barbero[i].getEstado() );
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro un barbero con ese ID");
    }
        public static void cambiarestado(int posicion) {

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Barbero: " + barbero[posicion].getId()+ " " + barbero[posicion].getNombre()+ "\n"
                + "Estado actual: " + (barbero[posicion].isEstadousuario()? "Activo" : "Inactivo") + "\n"
                + "¿Que desea hacer?",
                "Estado del barbero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            barbero[posicion].setEstadousuario(true);
            JOptionPane.showMessageDialog(null, "Barbero activado correctamente");
        } else {
            barbero[posicion].setEstadousuario(false);
            JOptionPane.showMessageDialog(null, "Barbero desactivado correctamente");
        }
    }
}
