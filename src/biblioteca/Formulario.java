package biblioteca;

import java.util.Scanner;

import clases.Libro;
import clases.Socio;

public class Formulario {
	static Scanner scan = new Scanner(System.in);

	//Pedir datos para hacer el insert
	public static Libro pedirDatosLibro(Scanner scan) {
		Libro libro = new Libro();

		System.out.println("Introduce el titulo del libro:");
		libro.setTitulo(scan.next());
		
		System.out.println("Introduce el autor del libro:");
		libro.setAutor(scan.next());

		System.out.println("Introduce el numero de paginas:");
		libro.setNumPag(scan.nextInt());

		return libro;
	}
	
	public static Socio pedirDatosSocio(Scanner scan) {
		Socio socio = new Socio();
		
		System.out.println("Inserte el nombre del socio:");
        socio.setNombre(scan.next());
       
        System.out.println("Inserte el apellido del socio:");
        socio.setApellido(scan.next());
        
        System.out.println("Inserte la direccion del socio:");
        socio.setDireccion(scan.next());
       
        System.out.println("Inserte la poblacion del socio:");
        socio.setPoblacion(scan.next());
       
        System.out.println("Inserte la provincia del socio:");
        socio.setProvincia(scan.next());
        
        System.out.println("Inserte el dni del socio:");
        socio.setDni(scan.next());
		
        return socio;
	}

	static Libro modificarDatosLibro(Libro libro, Scanner scan) {
        System.out.println("Inserte el nuevo titulo del libro:");
        libro.setTitulo(scan.next());
       
        System.out.println("Inserte el nuevo autor del libro:");
        libro.setAutor(scan.next());
        
        System.out.println("Inserte el nuevo numero de paginas del libro");
        libro.setNumPag(Integer.parseInt(scan.next()));
       
        System.out.println("Ha actualizado los datos");
        return libro;
	}
	
	static Socio modificarDatosSocio(Socio socio, Scanner scan) {
        System.out.println("Inserte el nuevo nombre del socio:");
        socio.setNombre(scan.next());
       
        System.out.println("Inserte el nuevo apellido del socio:");
        socio.setApellido(scan.next());
        
        System.out.println("Inserte la nueva direccion del socio:");
        socio.setDireccion(scan.next());
       
        System.out.println("Inserte la nueva poblacion del socio:");
        socio.setPoblacion(scan.next());
       
        System.out.println("Inserte la nueva provincia del socio:");
        socio.setProvincia(scan.next());
        
        System.out.println("Inserte el nuevo dni del socio:");
        socio.setDni(scan.next());
       
        System.out.println("Ha actualizado los datos");
        return socio;
	}

	static int pedirIdLibro(Scanner scan) {

		System.out.println("Introduce la id del libro:");
		int id = scan.nextInt();
		return id;

	}

	static int pedirIdSocio(Scanner scan) {

		System.out.println("Introduce la id del socio:");
		int id = scan.nextInt();
		return id;

	}
	
	static String pedirTituloLibro(Scanner scan) {
		System.out.println("Introduce el titulo del libro");
		String titulo = scan.next();
		return titulo;	
	}
	
	static String pedirDniSocio(Scanner scan) {
		System.out.println("Introduzca su DNI:");
		String dni = scan.next();
		return dni;
	}
}
