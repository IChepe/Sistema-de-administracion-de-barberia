package com.mycompany.sistemabarberia.Gestores;

import javax.swing.JOptionPane;

import com.mycompany.sistemabarberia.Clases.Barbero;
import com.mycompany.sistemabarberia.Clases.Citas;
import com.mycompany.sistemabarberia.Clases.Cliente;

public class CitasGestores {

    public static int contador = 0;
    public static int ultimoId = 0;
    public static Citas[] citas = new Citas[contador];

    
    public static int DURACION = 60;



    public static void agendarCita(){
        int clientesActivos = 0;
        for (int i = 0; i < ClienteGestores.contador; i++) {
            if (ClienteGestores.clientes[i].isEstado()) {
                clientesActivos++;
            }
        }
        if (clientesActivos == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return;
        }

        String opcionesCliente[] = new String[clientesActivos];
        Cliente listaCliente[] = new Cliente[clientesActivos];
        int j = 0;
        for (int i = 0; i < ClienteGestores.contador; i++) {
            if (ClienteGestores.clientes[i].isEstado()) {
                opcionesCliente[j] = ClienteGestores.clientes[i].getId() + " - "
                        + ClienteGestores.clientes[i].getNombre() + " "
                        + ClienteGestores.clientes[i].getApellido();
                listaCliente[j] = ClienteGestores.clientes[i];
                j++;
            }
        }

        int clienteSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el cliente:", "Agendar Cita",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesCliente, opcionesCliente[0]);

        if (clienteSeleccionado == JOptionPane.CLOSED_OPTION) {
            return;
        }

        Cliente clienteCita = listaCliente[clienteSeleccionado];


        // ----- Dia: el indice que devuelve es el mismo del catalogo -----
        int diaSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione el dia:", "Agendar Cita",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Barbero.DIAS, Barbero.DIAS[0]);

        if (diaSeleccionado == JOptionPane.CLOSED_OPTION) {
            return;
        }


        // ----- Bloque de hora -----
        int bloqueSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione la hora:", "Agendar Cita",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Barbero.BLOQUES, Barbero.BLOQUES[0]);

        if (bloqueSeleccionado == JOptionPane.CLOSED_OPTION) {
            return;
        }


        // ----- Barbero: solo los que trabajan ese dia y esa hora, y que esten libres -----
        int barberosDisponibles = 0;
        for (int i = 0; i < Barberogestores.COntador; i++) {
            if (estaDisponible(Barberogestores.barbero[i], diaSeleccionado, bloqueSeleccionado)) {
                barberosDisponibles++;
            }
        }
        if (barberosDisponibles == 0) {
            JOptionPane.showMessageDialog(null, "No hay barberos disponibles el " + Barbero.DIAS[diaSeleccionado]
                    + " de " + Barbero.BLOQUES[bloqueSeleccionado]
                    + "\n\nRevise que el barbero tenga ese dia y esa hora marcados en su horario,"
                    + "\no que el bloque no este ya reservado.");
            return;
        }

        String opcionesBarbero[] = new String[barberosDisponibles];
        Barbero listaBarbero[] = new Barbero[barberosDisponibles];
        j = 0;
        for (int i = 0; i < Barberogestores.COntador; i++) {
            if (estaDisponible(Barberogestores.barbero[i], diaSeleccionado, bloqueSeleccionado)) {
                opcionesBarbero[j] = Barberogestores.barbero[i].getId() + " - "
                        + Barberogestores.barbero[i].getNombre();
                listaBarbero[j] = Barberogestores.barbero[i];
                j++;
            }
        }

        int barberoSeleccionado = JOptionPane.showOptionDialog(null,
                "Barberos disponibles el " + Barbero.DIAS[diaSeleccionado]
                + " de " + Barbero.BLOQUES[bloqueSeleccionado] + ":",
                "Agendar Cita",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesBarbero, opcionesBarbero[0]);

        if (barberoSeleccionado == JOptionPane.CLOSED_OPTION) {
            return;
        }

        Barbero barberoCita = listaBarbero[barberoSeleccionado];


        contador++;
        ultimoId++;
        int id = ultimoId;

        Citas[] copia = new Citas[citas.length + 1];
        for (int i = 0; i < citas.length; i++) {
            copia[i] = citas[i];
        }
        citas = copia;

        // El dia se guarda en fecha y el bloque en hora. Toda cita nueva entra Pendiente.
        citas[contador - 1] = new Citas(id, clienteCita, barberoCita, Barbero.DIAS[diaSeleccionado],
                Barbero.BLOQUES[bloqueSeleccionado], DURACION, "Pendiente");

        JOptionPane.showMessageDialog(null, "Cita agendada correctamente:"
                + "\n\nCita N°: " + id
                + "\nCliente: " + clienteCita.getNombre() + " " + clienteCita.getApellido()
                + "\nBarbero: " + barberoCita.getNombre()
                + "\nDia: " + Barbero.DIAS[diaSeleccionado]
                + "\nHora: " + Barbero.BLOQUES[bloqueSeleccionado]);

    }


    // Un barbero esta disponible si esta activo, si trabaja ese dia y esa hora,
    // y si nadie mas le reservo ya ese bloque.
    public static boolean estaDisponible(Barbero unBarbero, int dia, int bloque) {

        if (!unBarbero.isEstadousuario()) {
            return false;
        }

        if (!unBarbero.trabajaEn(dia, bloque)) {
            return false;
        }

        return !estaReservado(unBarbero, dia, bloque);
    }


    // Recorre las citas buscando una Pendiente para ese barbero en ese dia y bloque.
    // Las Completadas y las Canceladas ya no ocupan el espacio.
    public static boolean estaReservado(Barbero unBarbero, int dia, int bloque) {

        for (int i = 0; i < contador; i++) {
            if (citas[i].getBarbero().getId() == unBarbero.getId()
                    && citas[i].getFecha().equals(Barbero.DIAS[dia])
                    && citas[i].getHora().equals(Barbero.BLOQUES[bloque])
                    && citas[i].getEstado().equals("Pendiente")) {
                return true;
            }
        }

        return false;
    }


    public static void consultarCitas() {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas");
        } else {
            String mensaje = "Citas registradas:\n";
            for (int i = 0; i < contador; i++) {
                if (citas[i] != null) {
                    mensaje += "\n----- Cita " + citas[i].getIdCita() + " -----"
                            + "\nCliente: " + citas[i].getCliente().getNombre() + " " + citas[i].getCliente().getApellido()
                            + "\nBarbero: " + citas[i].getBarbero().getNombre()
                            + "\nDia: " + citas[i].getFecha()
                            + "\nHora: " + citas[i].getHora()
                            + "\nDuracion: " + citas[i].getDuracion() + " min"
                            + "\nEstado: " + citas[i].getEstado() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }

    }


    // Recorre el arreglo y muestra todas las citas para escoger una,
    // asi no hay que aprenderse los ID. Devuelve la posicion, o -1 si se cierra.
    public static int seleccionarCita(String titulo) {

        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas");
            return -1;
        }

        String opciones[] = new String[contador];
        for (int i = 0; i < contador; i++) {
            opciones[i] = citas[i].getIdCita() + " - " + citas[i].getCliente().getNombre()
                    + " con " + citas[i].getBarbero().getNombre()
                    + " " + citas[i].getFecha() + " " + citas[i].getHora()
                    + " (" + citas[i].getEstado() + ")";
        }

        return JOptionPane.showOptionDialog(null, "Seleccione la cita:", titulo,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }


    public static void anularCita() {

        int i = seleccionarCita("Anular Cita");
        if (i == JOptionPane.CLOSED_OPTION) {
            return;
        }

        cambiarEstado(i);

    }


    // La cita no sale del arreglo, solo se le cambia el estado.
    // Al pasarla a Completada o Cancelada, el bloque le queda libre al barbero.
    public static void cambiarEstado(int posicion) {

        String opciones[] = { "Pendiente", "Completada", "Cancelada" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "Cita N°: " + citas[posicion].getIdCita() + "\n"
                + "Cliente: " + citas[posicion].getCliente().getNombre() + "\n"
                + "Barbero: " + citas[posicion].getBarbero().getNombre() + "\n"
                + citas[posicion].getFecha() + " " + citas[posicion].getHora() + "\n"
                + "Estado actual: " + citas[posicion].getEstado() + "\n"
                + "¿Como queda la cita?",
                "Estado de la Cita",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        citas[posicion].setEstado(opciones[seleccion]);
        JOptionPane.showMessageDialog(null, "La cita quedo como " + opciones[seleccion] + ".");

    }



}
