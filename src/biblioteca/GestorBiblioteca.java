package biblioteca;

import java.util.Scanner;

public class GestorBiblioteca {
	public static Scanner scan = new Scanner(System.in);
	public static void run() {
		int opcion;
		do {
			menu.mostrarMenuPrincipal();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case menu.SALIR:		
				break;

			case menu.GESTIONAR_LIBROS:
				menu.mostrarMenuLibros();
				opcion = Integer.parseInt(scan.nextLine());
				break;
				
			case menu.
				
			default:
				System.out.println("OPCION NO DISPONIBLE");
				break;
			}
		} while (opcion!=menu.SALIR);
		menu.mensajeSalir();
	}

}
