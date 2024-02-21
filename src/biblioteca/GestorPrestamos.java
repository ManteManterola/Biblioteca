package biblioteca;

import java.util.Scanner;

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

			default:
				break;
			}
		} while (opcion != Menu.SALIR);
	}
}
