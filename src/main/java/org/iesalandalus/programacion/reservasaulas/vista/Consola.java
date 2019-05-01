/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * @author Youness
 */
public class Consola {

    private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    private Consola() {

    }

    public static void mostrarMenu() {
        mostrarCabecera("Gestión de reservar aulas");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    public static void mostrarCabecera(String mensaje) {
        System.out.printf("%n%s%n", mensaje);
        String cadena = "%0" + mensaje.length() + "d%n";
        System.out.println(String.format(cadena, 0).replace("0", "-"));
    }

    public static int elegirOpcion() {
        int ordinalOpcion;
        do {
            System.out.print("\nElige una opción: ");
            ordinalOpcion = Entrada.entero();
        } while (!Opcion.esOrdinalValido(ordinalOpcion));
        return ordinalOpcion;
    }

    public static Aula leerAula() {
        Aula aula = null;
        do {
            try {
                aula = new Aula(leerNombreAula());
                System.out.print("Aula leida.");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (aula == null);

        return aula;
    }

    public static String leerNombreAula() {
        String nombre = "";
        do {
            System.out.println("Introduzca el nombre del aula:");
            nombre = Entrada.cadena();

        } while (nombre.equals(""));
        System.out.println("Nombre del aula leido correctamente");
        return nombre;
    }

    public static Profesor leerProfesor() {
        Profesor profesor = null;
        do {
            try {
                String nombre = leerNombreProfesor();
                System.out.println("Introduzca el correo electrónico del profesor:");
                String correo = Entrada.cadena();
                System.out.println("Introduzca el teléfono del profesor :");
                String telefono = Entrada.cadena();
                if (telefono.equals("")) {
                    profesor = new Profesor(nombre, correo);
                } else {
                    profesor = new Profesor(nombre, correo, telefono);
                }
                System.out.println("Profesor leído correctamente.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (profesor == null);

        return profesor;
    }

    public static String leerNombreProfesor() {
        String nombre = "";
        do {
            System.out.println("Introduzca el nombre del profesor:");
            nombre = Entrada.cadena();

        } while (nombre.equals(""));
        System.out.println("Nombre del profesor leido correctamente");
        return nombre;
    }

    public static Tramo leerTramo() {
        int opcion;
        do {
            System.out.println("Introduzca el tramo, 0 si es Mañana o 1 si es Tarde:");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion > Tramo.values().length);
        return Tramo.values()[opcion];
    }

    public static LocalDate leerDia() {
        LocalDate dia = null;
        do {
            System.out.println("Introduzca el día de reserva con el formato (dd/mm/aaaa): ");
            try {
                String fecha=Entrada.cadena();
                dia = LocalDate.parse(fecha, FORMATO_DIA);
            } catch (DateTimeParseException e) {
                System.out.println("La fecha introducida no tiene un formato válido, recuerda ¡dd/mm/aaaa!");
            }
        } while (dia == null);
        return dia;
    }

}
