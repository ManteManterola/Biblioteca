package biblioteca;

import java.util.Scanner;

public class GestorBiblioteca {
	public static Scanner scan = new Scanner(System.in);
	public static void run() {
		int opcion;
		do {
			Menu.mostrarMenuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case Menu.SALIR:		
				break;

			case Menu.GESTIONAR_LIBROS:
				GestorLibros.run();
				break;
				
			case Menu.GESTIONAR_SOCIOS:
				GestorSocios.run();
				break;
				
			case Menu.GESTIONAR_PRESTAMOS:
				GestorPrestamos.run();
				break;
				
			default:
				Menu.mensajeNoDisponible();
				break;
			}
		} while (opcion!=Menu.SALIR);
		Menu.mensajeSalir();
	}

}
