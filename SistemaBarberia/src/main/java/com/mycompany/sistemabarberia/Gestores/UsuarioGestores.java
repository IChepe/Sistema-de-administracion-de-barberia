package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Usuario;

public class UsuarioGestores {

    // El sistema arranca siempre con el usuario Admin ya cargado en la lista.
    public static int contador = 1;
    public static int ultimoId = 1;
    public static Usuario[] usuarios = {
        new Usuario(1, "Admin", "Principal", "admin@barberia.com", "123", "Administrador", true, "09/08/2026")
    };

    // Usuario que inicio sesion en el sistema.
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

        usuarios[contador - 1] = new Usuario(id, nombreUsu, apellidoUsu, emailUsu, passwordUsu, rolUsu, estadoUsu, fechaRegistroUsu);


    }


    public static void consultarUsuarios() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
        } else {
            String mensaje = "Usuarios registrados:\n";
            int activos = 0;
            for (int i = 0; i < contador; i++) {
                // Solo se muestran los que tienen el estado en true.
                if (usuarios[i] != null && usuarios[i].isEstado()) {
                    mensaje += usuarios[i].toString() + "\n";
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

    // Recorre el arreglo y muestra todos los usuarios registrados para escoger uno,
    // asi no hay que aprenderse los ID. Devuelve la posicion, o -1 si se cierra.
    public static int seleccionarUsuario(String titulo) {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
            return -1;
        }

        String opciones[] = new String[contador];
        for (int i = 0; i < contador; i++) {
            opciones[i] = usuarios[i].getId() + " - " + usuarios[i].getNombre() + " " + usuarios[i].getApellido()
                    + " (" + (usuarios[i].isEstado() ? "Activo" : "Inactivo") + ")";
        }

        return JOptionPane.showOptionDialog(null, "Seleccione el usuario:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

    public static void editarUsuario() {

        int i = seleccionarUsuario("Editar Usuario");
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

        int i = seleccionarUsuario("Eliminar Usuario");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);
    }


    public static boolean validarPassword(Usuario usuario, String password) {

        return usuario.getPassword().equals(password);

    }



    // Eliminado logico: el usuario NO sale del arreglo, solo se le cambia el estado.
    public static void cambiarEstado(int posicion) {

        if (usuarioActivo != null && usuarios[posicion].getId() == usuarioActivo.getId()) {
            JOptionPane.showMessageDialog(null, "No puede cambiar el estado del usuario con el que inicio sesion.");
            return;
        }

        String opciones[] = { "Activar", "Desactivar" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Usuario: " + usuarios[posicion].getNombre() + " " + usuarios[posicion].getApellido() + "\n"
                + "Estado actual: " + (usuarios[posicion].isEstado() ? "Activo" : "Inactivo") + "\n"
                + "¿Que desea hacer?",
                "Estado del Usuario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        if (seleccion == 0) {
            usuarios[posicion].setEstado(true);
            JOptionPane.showMessageDialog(null, "Usuario activado correctamente.");
        } else {
            usuarios[posicion].setEstado(false);
            JOptionPane.showMessageDialog(null, "Usuario desactivado correctamente.");
        }

    }



}
