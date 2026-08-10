/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabarberia;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Gestores.ClienteGestores;
import com.mycompany.sistemabarberia.Gestores.ServicioGestores;
import com.mycompany.sistemabarberia.Gestores.UsuarioGestores;

/**
 *
 * @author josed
 */
public class SistemaBarberia {

    public static void main(String[] args) {
     

        // ----- Login -----
        boolean sesionIniciada = false;
        int intentos = 3;

        while (intentos > 0 && !sesionIniciada) {

            String nombreUsuario = JOptionPane.showInputDialog("Ingrese su usuario:");
            if (nombreUsuario == null) {
                return;
            }
            String password = JOptionPane.showInputDialog("Ingrese su contraseña:");
            if (password == null) {
                return;
            }

            for (int i = 0; i < UsuarioGestores.contador; i++) {
                if (UsuarioGestores.usuarios[i].getNombre().equals(nombreUsuario)
                        && UsuarioGestores.validarPassword(UsuarioGestores.usuarios[i], password)) {

                    if (UsuarioGestores.usuarios[i].isEstado()) {
                        UsuarioGestores.usuarioActivo = UsuarioGestores.usuarios[i];
                        sesionIniciada = true;
                        JOptionPane.showMessageDialog(null, "Bienvenido " + UsuarioGestores.usuarios[i].getNombre()
                                + "\nRol: " + UsuarioGestores.usuarios[i].getRol());
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario esta inactivo. Contacte al administrador.");
                        return;
                    }
                    break;
                }
            }

            if (sesionIniciada== false) {
                intentos--;
                if (intentos > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.\nLe quedan " + intentos + " intento(s).");
                }
            }
        }

        if (sesionIniciada == false) {
            JOptionPane.showMessageDialog(null, "Se agotaron los intentos. El sistema se cerrara.");
            return;
        }


        int opcion = 0;

        do {
            String opciones[] ={
                "1. Servicios",
                "2. Clientes",
                "3. Barberos",
                "4. Citas",
                "5. Ventas",
                "6. Inventario",
                "7. Usuarios",
                "8. Salir"
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
                    int opcionCliente = 0;
                    do {
                        String opcionesCliente[] = {
                            "1. Agregar Cliente",
                            "2. Consultar Clientes",
                            "3. Editar Cliente",
                            "4. Eliminar Cliente",
                            "5. Regresar al Menú Principal"
                        };
                        opcionCliente = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Clientes",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCliente, opcionesCliente[0]);

                        if (opcionCliente == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionCliente) {
                            case 0:
                                ClienteGestores.AgregarCliente();
                                break;
                            case 1:
                                ClienteGestores.consultarClientes();
                                break;
                            case 2:
                                ClienteGestores.editarCliente();
                                break;
                            case 3:
                                ClienteGestores.eliminarCliente();
                                break;
                            case 4:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionCliente != 4);

                    break;
                case 2:
                   
                    break;
                case 3:
                   
                    break;    
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    int opcionUsuario = 0;
                    do {
                        String opcionesUsuario[] = {
                            "1. Agregar Usuario",
                            "2. Consultar Usuarios",
                            "3. Editar Usuario",
                            "4. Eliminar Usuario",
                            "5. Regresar al Menú Principal"
                        };
                        opcionUsuario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Usuarios",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesUsuario, opcionesUsuario[0]);

                        if (opcionUsuario == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionUsuario) {
                            case 0:
                                UsuarioGestores.AgregarUsuario();
                                break;
                            case 1:
                                UsuarioGestores.consultarUsuarios();
                                break;
                            case 2:
                                UsuarioGestores.editarUsuario();
                                break;
                            case 3:
                                UsuarioGestores.eliminarUsuario();
                                break;
                            case 4:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionUsuario != 4);

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 7);
       
    }



    }
