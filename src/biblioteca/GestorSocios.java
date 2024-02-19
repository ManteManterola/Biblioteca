package biblioteca;

import java.util.Scanner;

import clases.Socio;

public class GestorSocios {
	public static Scanner scan = new Scanner(System.in);
	
	public static void run() {
		int opcion;
		int id =0;
		Socio socio = new Socio();
		GestorBBDD gestorBBDD = new GestorBBDD();
		do {
			Menu.mostrarMenuSocios();
			opcion = scan.nextInt();
			switch (opcion) {
			case Menu.SALIR:
				Menu.mensajeSalir();
				break;
				
			case Menu.VISUALIZAR_SOCIOS:
				gestorBBDD.Conectar();
				Visor.mostrarSocios(gestorBBDD.getSocios());
				break;
				
			case Menu.VISUALIZAR_SOCIO:
				gestorBBDD.Conectar();
				Visor.mostrarSocio(gestorBBDD.getSocio(Formulario.pedirIdSocio(scan)));
				break;
				
			case Menu.ELIMINAR_SOCIO:
				gestorBBDD.Conectar();
				gestorBBDD.eliminarSocio(Formulario.pedirIdSocio(scan));
				break;
				
			case Menu.MODIFICAR_SOCIO:
				id = Formulario.pedirIdSocio(scan);
				gestorBBDD.Conectar();
				socio = gestorBBDD.getSocio(id);
				socio = Formulario.modificarDatosSocio(socio, scan);
				gestorBBDD.modificarSocio(id, socio);
				gestorBBDD.cerrar();
				break;
				
			case Menu.INSERTAR_SOCIO:
				gestorBBDD.Conectar();
				gestorBBDD.insertarSocio(Formulario.pedirDatosSocio(scan));
				gestorBBDD.cerrar();
				break;
				
			default:
				Menu.mensajeNoDisponible();
				break;
			}
		} while (opcion!=Menu.SALIR);
	}
}
