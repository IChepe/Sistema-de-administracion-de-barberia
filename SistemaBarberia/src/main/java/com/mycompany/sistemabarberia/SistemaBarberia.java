/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabarberia;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Gestores.ServicioGestores;

/**
 *
 * @author josed
 */
public class SistemaBarberia {

    public static void main(String[] args) {
     

        ServicioGestores gestion = new ServicioGestores();


        int opcion = 0;

        do {
            String opciones[] ={
                "1. Servicios",
                "2. Clientes",
                "3. Barberos",
                "4. Citas",
                "5. Ventas",
                "6. Inventario",
                "7. Salir"
            };
             opcion = JOptionPane.showOptionDialog(null, "Seleccione un Modulo", "Menú de Gestor de barbería",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            if (opcion == JOptionPane.CLOSED_OPTION) {
                break;
            }

            switch (opcion) {
                case 0:
                    int opcionServicio = 0;
                    do {
                        String opcionesServicio[] = {
                            "1. Agregar Servicio",
                            "2. Consultar Servicios",
                            "3. Editar Servicio",
                            "4. Eliminar Servicio",
                            "5. Regresar al Menú Principal"
                        };
                        opcionServicio = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Servicios",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesServicio, opcionesServicio[0]);

                        if (opcionServicio == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionServicio) {
                            case 0:
                                ServicioGestores.AgregarServicio();
                                break;
                            case 1:
                                ServicioGestores.consultarServicios();
                                break;
                            case 2:
                                ServicioGestores.editarServicio();
                                break;
                            case 3:
                                ServicioGestores.eliminarServicio();
                                break;
                            case 4:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionServicio != 4);

                    break;
                case 1:
                  
                    break;
                case 2:
                   
                    break;
                case 3:
                   
                    break;    
                case 4:
                
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");    
            }
        
        } while (opcion != 6);
       
    }



    }
