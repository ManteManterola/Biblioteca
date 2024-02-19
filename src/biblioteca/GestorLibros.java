package biblioteca;

import java.util.*;

import clases.Libro;

public class GestorLibros {
	public static Scanner scan = new Scanner(System.in);

	public static void run() {
		int opcion;
		int id=0;
		Libro libro = new Libro();
		GestorBBDD gestorBBDD = new GestorBBDD();
		do {
			Menu.mostrarMenuLibros();
			opcion = scan.nextInt();
			switch (opcion) {
			case Menu.SALIR:
				Menu.mensajeSalir();
				break;

			case Menu.VISUALIZAR_LIBROS:
				gestorBBDD.Conectar();
				Visor.mostrarLibros(gestorBBDD.getLibros());
				break;

			case Menu.INSERTAR_LIBROS:
				gestorBBDD.Conectar();
				gestorBBDD.instertarLibro(Formulario.pedirDatosLibro(scan));
				gestorBBDD.cerrar();
				break;
				
			case Menu.VISUALIZAR_LIBRO:
				gestorBBDD.Conectar();
				Visor.mostrarLibro(gestorBBDD.getLibro(Formulario.pedirIdLibro(scan)));
				break;
				
			case Menu.ELIMINAR_LIBROS:
				gestorBBDD.Conectar();
				gestorBBDD.eliminarLibro(Formulario.pedirIdLibro(scan));
				break;
				
			case Menu.MODIFICAR_LIBROS:
				id = Formulario.pedirIdLibro(scan);
				gestorBBDD.Conectar();
				libro = gestorBBDD.getLibro(id);
				libro = Formulario.modificarDatosLibro(libro, scan);
				gestorBBDD.modificarLibro(id, libro);
				gestorBBDD.cerrar();
				break;
				
			default:
				Menu.mensajeNoDisponible();
				break;
			}
		} while (opcion != Menu.SALIR);
	}
}
