/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabarberia;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Gestores.CitasGestores;
import com.mycompany.sistemabarberia.Gestores.ClienteGestores;
import com.mycompany.sistemabarberia.Gestores.GestorProductosVendidos;
import com.mycompany.sistemabarberia.Gestores.InventarioGestores;
import com.mycompany.sistemabarberia.Gestores.ReporteGestores;
import com.mycompany.sistemabarberia.Gestores.ServicioGestores;
import com.mycompany.sistemabarberia.Gestores.UsuarioGestores;
import com.mycompany.sistemabarberia.Gestores.VentaGestores;
import com.mycompany.sistemabarberia.Gestores.Barberogestores;

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
                "8. Reportes",
                "9. Salir"
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
                   int opcionbarbero = 0;
                    do {
                        String opcionesbarbero[] = {
                            "1. Agregar barbero",
                            "2. Consultar barberos",
                            "3. Editar barbero",
                            "4. Eliminar barbero",
                            "5. calcular comisión",
                            "6. Consultar agenda de barbero",
                            "7. Regresar al Menú Principal"
                        };
                        opcionbarbero = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Clientes",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesbarbero, opcionesbarbero[0]);

                        if (opcionbarbero == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionbarbero) {
                            case 0:
                                Barberogestores.AgregarBarbero();
                                break;
                            case 1:
                                Barberogestores.consultarbarbero();
                                break;
                            case 2:
                                Barberogestores.editarbarbero();
                                break;
                            case 3:
                                Barberogestores.eliminarbarbero();
                                break;
                            case 4:
                                Barberogestores.calcularcomision();
                                break;
                            case 5:
                                Barberogestores.consultaragenda();
                                break;
                            case 6:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionbarbero != 6);

                    break;
                case 3:
                    int opcionCita = 0;
                    do {
                        String opcionesCita[] = {
                            "1. Agendar Cita",
                            "2. Consultar Citas",
                            "3. Anular Cita",
                            "4. Regresar al Menú Principal"
                        };
                        opcionCita = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Citas",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCita, opcionesCita[0]);

                        if (opcionCita == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionCita) {
                            case 0:
                                CitasGestores.agendarCita();
                                break;
                            case 1:
                                CitasGestores.consultarCitas();
                                break;
                            case 2:
                                CitasGestores.anularCita();
                                break;
                            case 3:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionCita != 3);

                    break;
                case 4:
                    int opcionVenta = 0;
                    do {
                        String opcionesVenta[] = {
                            "1. Crear Venta",
                            "2. Consultar Ventas",
                            "3. Anular Venta",
                            "4. Generar Factura",
                            "5. Regresar al Menú Principal"
                        };
                        opcionVenta = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Ventas",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesVenta, opcionesVenta[0]);

                        if (opcionVenta == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionVenta) {
                            case 0:
                                VentaGestores.crearVenta();
                                break;
                            case 1:
                                VentaGestores.consultarVentas();
                                break;
                            case 2:
                                VentaGestores.anularVenta();
                                break;
                            case 3:
                                VentaGestores.generarFactura();
                                break;
                            case 4:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionVenta != 4);

                    break;
                case 5:
                    int opcionInventario = 0;
                    do {
                        String opcionesInventario[] = {
                            "1. Agregar Producto",
                            "2. Consultar Productos",
                            "3. Editar Producto",
                            "4. Eliminar Producto",
                            "5. Ver Stock Bajo",
                            "6. Productos Vendidos",
                            "7. Total Vendido en Productos",
                            "8. Regresar al Menú Principal"
                        };
                        opcionInventario = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Inventario",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesInventario, opcionesInventario[0]);

                        if (opcionInventario == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionInventario) {
                            case 0:
                                InventarioGestores.AgregarInventario();
                                break;
                            case 1:
                                InventarioGestores.consultarInventarios();
                                break;
                            case 2:
                                InventarioGestores.editarInventario();
                                break;
                            case 3:
                                InventarioGestores.eliminarInventario();
                                break;
                            case 4:
                                InventarioGestores.consultarStockBajo();
                                break;
                            case 5:
                                GestorProductosVendidos.consultarProductosVendidos();
                                break;
                            case 6:
                                GestorProductosVendidos.calcularTotalGeneral();
                                break;
                            case 7:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionInventario != 7);

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
                case 7:
                    int opcionReporte = 0;
                    do {
                        String opcionesReporte[] = {
                            "1. Crear Reporte",
                            "2. Consultar Reportes",
                            "3. Ver Reporte",
                            "4. Eliminar Reporte",
                            "5. Regresar al Menú Principal"
                        };
                        opcionReporte = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Reportes",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesReporte, opcionesReporte[0]);

                        if (opcionReporte == JOptionPane.CLOSED_OPTION) {
                            break;
                        }

                        switch (opcionReporte) {
                            case 0:
                                ReporteGestores.crearReporte();
                                break;
                            case 1:
                                ReporteGestores.consultarReportes();
                                break;
                            case 2:
                                ReporteGestores.generar();
                                break;
                            case 3:
                                ReporteGestores.eliminarReporte();
                                break;
                            case 4:
                                // Regresar al menú principal
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                        }
                    } while (opcionReporte != 4);

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 8);
       
    }



    }
