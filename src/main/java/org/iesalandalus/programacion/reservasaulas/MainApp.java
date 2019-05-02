package org.iesalandalus.programacion.reservasaulas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.vista.IUTextual;

public class MainApp {

	public static void main(String[] args) throws OperationNotSupportedException {
		System.out.println("Programa para la gestión de reservas de espacios del IES Al-Ándalus");
                IUTextual iniciarPrograma = new IUTextual();
		iniciarPrograma.comenzar();
	}

}
