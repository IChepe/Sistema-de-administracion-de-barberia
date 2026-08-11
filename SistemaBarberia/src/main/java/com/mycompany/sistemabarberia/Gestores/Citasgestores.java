/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Gestores;
import com.mycompany.sistemabarberia.Clases.Citas;
import javax.swing.JOptionPane;

/**
 *
 * @author sscr
 */
public class Citasgestores {
    public static int contador= 0;
    public static int UltimoID= 0;
    public static Citas[] citas = new Citas[contador];
    
    public static void crearcita(){
        if(ClienteGestores.contador == 0){
        JOptionPane.showMessageDialog(null, "No hay clientes registrados");  
        return;
    }
        String  crienteelegido = "Clientes activos: \n";
        for (int i= 0;i < ClienteGestores.contador; i++){
            if (ClienteGestores.clientes[i] != null && ClienteGestores.clientes[i].isEstado()){
                crienteelegido += "ID: "+ ClienteGestores.clientes[i].getId()
                        + "- Cliente: "+ ClienteGestores.clientes[i].getNombre()+ "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "Estos son los servicios disponibles \n"+ crienteelegido);
        
        int IDCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de cliente"));
        String nombrecliente = null;
        String telefonocliente = null;
        for (int i= 0;i < ClienteGestores.contador; i++){
            if (ClienteGestores.clientes[i].getId() == IDCliente){
                nombrecliente = ClienteGestores.clientes[i].getNombre();
                telefonocliente = ClienteGestores.clientes[i].getTelefono();
            }
        }
        if(Barberogestores.COntador == 0){
        JOptionPane.showMessageDialog(null, "No hay barberos registrados");  
        return;
    }
        String  barberoelegido = "Barberos disponibles: \n";
        for (int i= 0;i < Barberogestores.COntador; i++){
            if (Barberogestores.barbero[i] != null && Barberogestores.barbero[i].isEstadousuario()){
                barberoelegido += "ID: "+ Barberogestores.barbero[i].getId()
                        + "- Cliente: "+ Barberogestores.barbero[i].getNombre()+ "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "Estos son los servicios disponibles \n"+ barberoelegido);
        int IDbarberoele = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del barbero a seleccionar"));
        String horariobarbero = null;
        for (int i= 0;i < Barberogestores.COntador; i++){
            if (Barberogestores.barbero[i].getId() == IDbarberoele){
                horariobarbero = Barberogestores.barbero[i].getHorario();
                JOptionPane.showMessageDialog(null, "Información del barbero seleccionado: "
                        + "\n Nombre: "+ Barberogestores.barbero[i].getNombre()
                        + "\n horario de atención: "+ horariobarbero);    
            }
          } 
        if (horariobarbero == null){
            JOptionPane.showMessageDialog(null, "El ID de barbero ingresado no existe");
            return;
        }  
        if(ServicioGestores.contador == 0){
        JOptionPane.showMessageDialog(null, "No hay servicios registrados");  
        return;
    }
        String  servicioelegido = "servicios disponibles: \n";
        for (int i= 0;i < ServicioGestores.contador; i++){
            if (ServicioGestores.servicios[i] != null && ServicioGestores.servicios[i].isEstado()){
                servicioelegido += "ID: "+ ServicioGestores.servicios[i].getIdServicio()
                        + "- Servicio: "+ ServicioGestores.servicios[i].getNombreser()+ "\n";
            }
        }
        JOptionPane.showMessageDialog(null, "Estos son los servicios disponibles \n"+ servicioelegido);
        int idservicioelegido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio: "));
        String fechahora = JOptionPane.showInputDialog("Hola "+ nombrecliente 
                + ",\nIngrese la fecha y hora de la cita \n (Recuerde que el horario del barbero es: " + horariobarbero 
                + "):");
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración estimada de la cita: "));
        String fechacreacion = JOptionPane.showInputDialog("Ingrese la fecha actual: ");
        String notas = JOptionPane.showInputDialog("Ingrese notas u observaciones adicionales: ");
        String estado = "pendiente";
        contador++;
        UltimoID++;
        Citas[] copia = new Citas[citas.length +1];
        for (int i = 0; i< citas.length; i++){
            copia[i] = citas[i];
        }
        citas = copia;
        citas[contador - 1] = new Citas(UltimoID, IDCliente, IDbarberoele,
                idservicioelegido, fechahora, duracion, estado, notas, fechacreacion);
        JOptionPane.showMessageDialog(null, "Cita creada con éxito");
    }  
    public static void confirmarcita(){
        if (contador == 0){
            JOptionPane.showMessageDialog(null, "No hay citas registradas");
            return;
        }
        int IDcitaconfirmar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de su cita: " ));
        for (int i= 0;i < contador; i++){
            if(citas[i].getId() == IDcitaconfirmar){
                int opcion = JOptionPane.showConfirmDialog(null, "Desea confirmar la cita de "
                + citas[i].getIdCliente() + " para el " +citas[i].getFechahora()+ " ?",
                "onfirmar cita", JOptionPane.YES_NO_OPTION);
                
                if (opcion == JOptionPane.YES_OPTION){
                    citas[i].setEstado("Confirmada");
                    JOptionPane.showMessageDialog(null, "Cita confirmada");
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha confirmado la cita");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el ID");        
    }
    public static void cancelarcita(){
        if(contador == 0){
            JOptionPane.showMessageDialog(null,"No hay citas registradas");
            return;
        }
         int IDcitacancelar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de su cita: " ));
        for (int i= 0;i < contador; i++){
            if(citas[i].getId() == IDcitacancelar){
                int opcion = JOptionPane.showConfirmDialog(null, "Desea cancelar la cita de "
                + citas[i].getIdCliente() + " para el " +citas[i].getFechahora()+ " ?",
                "cancelar cita", JOptionPane.YES_NO_OPTION);
                
                if (opcion == JOptionPane.YES_OPTION){
                    citas[i].setEstado("Cancelada");
                    JOptionPane.showMessageDialog(null, "Cita cancelada");
                }else{
                    JOptionPane.showMessageDialog(null, "No se ha cancelado la cita");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el ID");        
    }
 }

    
