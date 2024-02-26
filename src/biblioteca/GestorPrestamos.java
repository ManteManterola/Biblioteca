package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import clases.Libro;
import clases.Prestamo;
import clases.Socio;

public class GestorPrestamos {
	public static Scanner scan = new Scanner(System.in);
	
	public static void run () {
		int opcion;
		
		GestorBBDD gestorBBDD = new GestorBBDD();
		do {
			Menu.mostrarMenuPrestamos();
			opcion = scan.nextInt();
			
			switch (opcion) {
			case Menu.INSERTAR_PRESTAMO:
				gestorBBDD.Conectar();
				gestorBBDD.insertarPrestamo(gestorBBDD.getIdConTitulo(Formulario.pedirTituloLibro(scan)), gestorBBDD.getIdConDni(Formulario.pedirDniSocio(scan)));
				gestorBBDD.cerrar();
				break;
				
			case Menu.DEVOLVER_PRESTAMO:
				gestorBBDD.Conectar();
				gestorBBDD.devolverPrestamo(gestorBBDD.getIdConTitulo(Formulario.pedirTituloLibro(scan)), gestorBBDD.getIdConDni(Formulario.pedirDniSocio(scan)));
				gestorBBDD.cerrar();
				break;
				
			case Menu.VISUALIZAR_PRESTAMOS_ORDENADOS:
				gestorBBDD.Conectar();
				String dni = Formulario.pedirDniSocio(scan);
				Socio socio = gestorBBDD.getSocio(gestorBBDD.getIdConDni(dni));
				Visor.mostrarSocio(socio);
				
				ArrayList<Prestamo> prestamos = gestorBBDD.getPrestamosDeSocio(gestorBBDD.getIdConDni(dni));
				Visor.mostrarPrestamos(prestamos);
				ArrayList<Libro> libros = new ArrayList<Libro>();
				for (Prestamo p:prestamos) {
					int id= p.getIdLibro();
					libros.add(gestorBBDD.getLibro(id));
				}
				Visor.mostrarLibros(libros);
				break;
			default:
				Menu.mensajeNoDisponible();
				break;
			}
		} while (opcion != Menu.SALIR);
	}
}
