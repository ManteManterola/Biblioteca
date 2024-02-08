package biblioteca;

import java.util.Scanner;

public class menu {

	Scanner scan = new Scanner(System.in);
	// Finals de las opciones del menu principal
	public static final int GESTIONAR_LIBROS = 1;
	public static final int GESTIONAR_SOCIOS = 2;
	public static final int GESTIONAR_PRESTAMOS = 3;
	public static final int SALIR = 0;



	// Finals de las opciones del MenuLibros
	public static final int INSERTAR_LIBROS = 1;
	public static final int ELIMINAR_LIBROS = 2;
	public static final int MODIFICAR_LIBROS = 3;
	public static final int VISUALIZAR_LIBROS = 4;	

	// Finals de las opciones del MenuSocio
	public static final int INSERTAR_SOCIO = 1;
	public static final int ELIMINAR_SOCIO = 2;
	public static final int MODIFICAR_SOCIO = 3;
	public static final int VISUALIZAR_SOCIO = 4;

	// Finals de las opciones del MenuPRESTAMO
	public static final int INSERTAR_PRESTAMO = 1;
	public static final int ELIMINAR_PRESTAMO = 2;
	public static final int MODIFICAR_PRESTAMO = 3;
	public static final int VISUALIZAR_PRESTAMO = 4;



	static void mostrarMenuPrincipal() {

		System.out.println("----Menu Principal----");
		System.out.println(SALIR + "-Salir");
		System.out.println(GESTIONAR_LIBROS + "Gestionar Libros");
		System.out.println(GESTIONAR_SOCIOS + "Gestionar Socios");
		System.out.println(GESTIONAR_PRESTAMOS + "Gestionar Prestamo");
	}

	static void mostrarMenuLibros() {
		System.out.println("----Menu Libros----");
		System.out.println(SALIR + "-Salir");
		System.out.println(INSERTAR_LIBROS + "Insertar libros");
		System.out.println(ELIMINAR_LIBROS + "Eliminar libros");
		System.out.println(MODIFICAR_LIBROS + "Modificar libros");
		System.out.println(VISUALIZAR_LIBROS + "Visualizar libros");
	}

	static void mostrarMenuSocio() {
		System.out.println("----Menu Socio----");
		System.out.println(SALIR +"-Salir");
		System.out.println(INSERTAR_SOCIO + "Insertar socio");
		System.out.println(ELIMINAR_SOCIO + "Eliminar socio");
		System.out.println(MODIFICAR_SOCIO + "Modificar socio");
		System.out.println(VISUALIZAR_SOCIO + "Visualizar socio");
	}

	static void mostrarMenuPrestamo() {
		System.out.println("----Menu Prestamo----");
		System.out.println(SALIR + "-Salir");
		System.out.println(INSERTAR_PRESTAMO + "Insertar prestamo");
		System.out.println(ELIMINAR_PRESTAMO + "Eliminar prestamo");
		System.out.println(MODIFICAR_PRESTAMO + "Modificar prestamo");
		System.out.println(VISUALIZAR_PRESTAMO + "Visualizar prestamo");
	}
	
	static void mensajeSalir() {
		System.out.println("SALIENDO DEL PROGRAMA");
	}

}