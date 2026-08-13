package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Usuario;

public class UsuarioGestores {

    public static int contador = 1;
    public static int ultimoId = 1;
    public static Usuario[] usuarios = {
        new Usuario(1, "Admin", "Principal", "admin@barberia.com", "123", "Administrador", true, "09/08/2026")
    };

    public static Usuario usuarioActivo = null;



    public static void AgregarUsuario(){
        contador++;
        ultimoId++;
        int id = ultimoId;
        String nombreUsu = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
        String apellidoUsu = JOptionPane.showInputDialog("Ingrese el apellido del usuario");
        String emailUsu = JOptionPane.showInputDialog("Ingrese el email del usuario");
        String passwordUsu = JOptionPane.showInputDialog("Ingrese la contraseña del usuario");
        String rolUsu = JOptionPane.showInputDialog("Ingrese el rol del usuario (Administrador, Barbero, Recepcionista)");
        boolean estadoUsu = JOptionPane.showConfirmDialog(null, "¿El usuario esta activo?", "Estado del usuario",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        String fechaRegistroUsu = JOptionPane.showInputDialog("Ingrese la fecha de registro del usuario (dd/mm/aaaa)");


        Usuario[] copia = new Usuario[usuarios.length + 1];
        for (int i = 0; i < usuarios.length; i++) {
            copia[i] = usuarios[i];
        }
        usuarios = copia;

        usuarios[contador - 1] = new Usuario(id, nombreUsu, apellidoUsu, emailUsu,
                passwordUsu, rolUsu, estadoUsu, fechaRegistroUsu);
    }


    public static void consultarUsuarios() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
        } else {
            String mensaje = "Usuarios registrados:\n";
            int activos = 0;
            for (int i = 0; i < contador; i++) {
                if (usuarios[i] != null && usuarios[i].isEstado()) {
                    mensaje = mensaje + usuarios[i].toString() + "\n";
                    activos++;
                }
            }
            if (activos == 0) {
                JOptionPane.showMessageDialog(null, "No hay usuarios activos");
            } else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }


    }
    public static int seleccionarUsuario(String titulo, boolean soloActivos) {
        int disponibles = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivos || usuarios[i].isEstado()) {
                disponibles++;
            }
        }

        if (disponibles == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios para mostrar");
            return -1;
        }
        String opciones[] = new String[disponibles];
        int posiciones[] = new int[disponibles];
        int j = 0;
        for (int i = 0; i < contador; i++) {
            if (!soloActivos || usuarios[i].isEstado()) {
                String Estadotexto= "";
                if(usuarios[i].isEstado()){
                    Estadotexto = "Activa";
                }else{ 
                    Estadotexto = "Inactiva";
                }
                opciones[j] = usuarios[i].getId() + " - " + usuarios[i].getNombre() 
                        + " " + usuarios[i].getApellido()
                        + " (" + Estadotexto + ")";
                posiciones[j] = i;
                j++;
            }
        }

        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el usuario:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return -1;
        }
        return posiciones[seleccion];
    }

    public static void editarUsuario() {

        int i = seleccionarUsuario("Editar Usuario", true);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de usuario:");
        String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del usuario:");
        String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email del usuario:");
        String nuevaPassword = JOptionPane.showInputDialog("Ingrese la nueva contraseña del usuario:");
        String nuevoRol = JOptionPane.showInputDialog("Ingrese el nuevo rol del usuario:");
        boolean nuevoEstado = JOptionPane.showConfirmDialog(null, "¿El usuario esta activo?", "Estado del usuario",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        usuarios[i] = new Usuario(usuarios[i].getId(), nuevoNombre, nuevoApellido, nuevoEmail, nuevaPassword,
                nuevoRol, nuevoEstado, usuarios[i].getFechaRegistro());
        JOptionPane.showMessageDialog(null, "Usuario editado correctamente.");
    }

    public static void eliminarUsuario() {
        int i = seleccionarUsuario("Eliminar Usuario", false);
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }
        cambiarEstado(i);
    }


    public static boolean validarPassword(Usuario usuario, String password) {

        return usuario.getPassword().equals(password);

    }
    public static void cambiarEstado(int posicion) {

        if (usuarioActivo != null && usuarios[posicion].getId() == usuarioActivo.getId()) {
            JOptionPane.showMessageDialog(null, "No puede cambiar el estado del usuario con el que inicio sesion.");
            return;
        }
       String Estadoactual= "";
       if(usuarios[posicion].isEstado()){
           Estadoactual = "Activa";
       }else{
           Estadoactual = "Inactiva";
       }

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Usuario: " + usuarios[posicion].getNombre() + " " + usuarios[posicion].getApellido() + "\n"
                + "Estado actual: " + Estadoactual + "\n"
                + "¿Que desea hacer?",
                "Estado del Usuario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            usuarios[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Usuario activado correctamente");
        } else {
            usuarios[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Usuario desactivado correctamente");
        }

    }



}
