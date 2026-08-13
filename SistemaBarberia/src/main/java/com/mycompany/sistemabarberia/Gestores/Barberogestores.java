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
        boolean dias[] = marcardias();
        boolean bloques[] = marcarbloques();
        Double comision = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje de comisión\n(numero entero, ejemplo: 20 para un 20%): "));
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
       barbero[COntador -1] = new Barbero(id,nombre, especialidad, fechaRegistro, dias,
               bloques, comision, estado, true);

    }

    public static boolean[] marcardias() {

        boolean marcas[] = new boolean[Barbero.DIAS.length];

        for (int i = 0; i < Barbero.DIAS.length; i++) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿El barbero trabaja el " + Barbero.DIAS[i] + "?",
                    "Dias que trabaja (" + (i + 1) + " de " + Barbero.DIAS.length + ")",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                marcas[i] = true;
            }
        }

        return marcas;
    }

    public static boolean[] marcarbloques() {

        boolean marcas[] = new boolean[Barbero.BLOQUES.length];

        for (int i = 0; i < Barbero.BLOQUES.length; i++) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿El barbero atiende de " + Barbero.BLOQUES[i] + "?",
                    "Bloques de hora (" + (i + 1) + " de " + Barbero.BLOQUES.length + ")",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                marcas[i] = true;
            }
        }

        return marcas;
    }
     public static void consultarbarbero() {
        if (COntador == 0) {
            JOptionPane.showMessageDialog(null, "No hay barberos registrados");
        } else {
            String mensaje = "Barberos registrados:\n";
            int Activos = 0;
            for (int i = 0; i < COntador; i++) {
                if (barbero[i] != null && barbero[i].isEstadousuario()) {
                    mensaje = mensaje + barbero[i].toString() + "\n";
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


    public static int seleccionarbarbero(String titulo, boolean soloActivos) {

        int disponibles = 0;
        for (int i = 0; i < COntador; i++) {
            if (!soloActivos || barbero[i].isEstadousuario()) {
                disponibles++;
            }
        }

        if (disponibles == 0) {
            JOptionPane.showMessageDialog(null, "No hay barberos para mostrar");
            return -1;
        }
        
        String opciones[] = new String[disponibles];
        int posiciones[] = new int[disponibles];
        int j = 0;
        for (int i = 0; i < COntador; i++) {
            if (!soloActivos || barbero[i].isEstadousuario()) {
                
                   String Estadotexto= "";
                if(barbero[i].isEstadousuario()){
                    Estadotexto = "Activa";
                }else{ 
                    Estadotexto = "Inactiva";
                }
                
                opciones[j] = barbero[i].getId() + " - " + barbero[i].getNombre()
                        + " (" + Estadotexto + ")";
                posiciones[j] = i;
                j++;
            }
        }

        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el barbero:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return -1;
        }

        return posiciones[seleccion];
    }

    public static void editarbarbero() {

        int i = seleccionarbarbero("Editar barbero", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

                    String nuevonombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del barbero: ");
                    String nuevaespecialidad = JOptionPane.showInputDialog("Ingrese la nueva especialidad:");
                    String nuevafechaRegistro = JOptionPane.showInputDialog("Ingrese la nueva fecha de registro del barbero:");
                    boolean nuevosdias[] = marcardias();
                    boolean nuevosbloques[] = marcarbloques();
                    Double nuevacomision = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo porcentaje de comisión\n(numero entero, ejemplo: 20 para un 20%): "));
                    int Opcionestado = JOptionPane.showConfirmDialog(null, "El barbero esta disponible?", "Estado de barbero"
                ,JOptionPane.YES_NO_OPTION);
       String nuevoestado;
       if(Opcionestado == JOptionPane.YES_OPTION){
           nuevoestado = "Disponible";
       }else{
           nuevoestado = "No disponible";
       }
                    barbero[i] = new Barbero(barbero[i].getId(), nuevonombre, nuevaespecialidad, nuevafechaRegistro,
                            nuevosdias, nuevosbloques,nuevacomision, nuevoestado, barbero[i].isEstadousuario());
                    JOptionPane.showMessageDialog(null, "Barbero editado correctamente.");
    }
    public static void eliminarbarbero() {
        int i = seleccionarbarbero("Eliminar barbero", false);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarestado(i);
    }
    public static void calcularcomision() {

        int i = seleccionarbarbero("Calcular comision", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

                double precioservicio = Double.parseDouble(JOptionPane.showInputDialog(
                        "Ingrese el precio del servicio realizado: "));
                double ganancia = (precioservicio * barbero[i].getComision())/ 100;

                JOptionPane.showMessageDialog(null, "Cálculo de comisión: "
                        +"\n\n Barbero: "+ barbero[i].getId() + " - " + barbero[i].getNombre()
                        +"\n Comisión del barbero: "+ barbero[i].getComision()+" %"
                        +"\n Total ganado: "+ ganancia);
    }
    public static void consultaragenda(){

        int i = seleccionarbarbero("Consultar agenda", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

                JOptionPane.showMessageDialog(null, "Agenda del barbero"
                        +"\n\n ID: "+ barbero[i].getId()
                        +"\n Nombre: "+ barbero[i].getNombre()
                        +"\n Especialidad: "+ barbero[i].getEspecialidad()
                        +"\n Dias que trabaja: "+ barbero[i].getDiasTexto()
                        +"\n Horario: "+ barbero[i].getBloquesTexto()
                        +"\n Estado actual: "+ barbero[i].getEstado() );
    }
        public static void cambiarestado(int posicion) {
             String Estadoactual = "";
        if (barbero[posicion].isEstadousuario()){
            Estadoactual = "Activo";
        }else{
            Estadoactual = "Inactivo";
        }

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Barbero: " + barbero[posicion].getId()+ " " + barbero[posicion].getNombre()+ "\n"
                + "Estado actual: " + Estadoactual + "\n"
                + "¿Que desea hacer?",
                "Estado del barbero",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
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
