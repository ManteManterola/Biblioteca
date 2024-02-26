package biblioteca;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import clases.Libro;
import clases.Prestamo;
import clases.Socio;

public class GestorBBDD extends Conector {

	public void instertarLibro(Libro libro) {
		String sentenciaInsert = "INSERT INTO `libros` (`titulo`, `autor`, `num_pag`) VALUES (?, ?, ?)";
		PreparedStatement preparedSt;
		
		try {
			preparedSt = con.prepareStatement(sentenciaInsert);
			preparedSt.setString(1, libro.getTitulo());
			preparedSt.setString(2, libro.getAutor());
			preparedSt.setInt(3, libro.getNumPag());
			
			preparedSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarSocio(Socio socio) {
		String sentenciaInsert = "INSERT INTO `socios` (`nombre`, `apellido`, `direccion`, `poblacion`, `provincia`, `dni`) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedSt;
		
		try {
			preparedSt = con.prepareStatement(sentenciaInsert);
			preparedSt.setString(1, socio.getNombre());
			preparedSt.setString(2, socio.getApellido());
			preparedSt.setString(3, socio.getDireccion());
			preparedSt.setString(4, socio.getPoblacion());
			preparedSt.setString(5, socio.getProvincia());
			preparedSt.setString(6, socio.getDni());
			
			preparedSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarPrestamo(int idLibro, int idSocio) {
		String sentenciaInsert = "INSERT INTO `prestamos` (`id_libro`, `id_socio`, `fecha`, `devuelto`) VALUES (?, ?, ?, ?)";
		PreparedStatement preparedSt;
		Date fechaActual = new Date(Calendar.getInstance().getTime().getTime());
		
		try {
			preparedSt = con.prepareStatement(sentenciaInsert);
			preparedSt.setInt(1, idLibro);
			preparedSt.setInt(2, idSocio);
			preparedSt.setDate(3, fechaActual);
			preparedSt.setBoolean(4, false);
			
			preparedSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarLibro(int id, Libro libro) {
		String sentenciaUpdate = "UPDATE libros SET titulo=?, autor=?, num_pag=? WHERE id=?";
		PreparedStatement preparedSt;
		try {
			preparedSt = con.prepareStatement(sentenciaUpdate);
			preparedSt.setString(1, libro.getTitulo());
			preparedSt.setString(2, libro.getAutor());
			preparedSt.setInt(3, libro.getNumPag());
			preparedSt.setInt(4, id);
			
			preparedSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modificarSocio(int id, Socio socio) {
		String sentenciaUpdate = "UPDATE socios SET nombre=?, apellido=?, direccion=?, poblacion=?, provincia=?, dni=? WHERE id=?";
		PreparedStatement preparedSt;
		try {
			preparedSt = con.prepareStatement(sentenciaUpdate);
			preparedSt.setString(1, socio.getNombre());
			preparedSt.setString(2, socio.getApellido());
			preparedSt.setString(3, socio.getDireccion());
			preparedSt.setString(4, socio.getPoblacion());
			preparedSt.setString(5, socio.getProvincia());
			preparedSt.setString(6, socio.getDni());
			preparedSt.setInt(7, id);
			
			preparedSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void devolverPrestamo(int idLibro, int idSocio) {
		String sentenciaUpdate = "UPDATE prestamos SET devuelto=? WHERE id_libro=? AND id_socio=?";
		PreparedStatement preparedSt;
		
		try {
			preparedSt = con.prepareStatement(sentenciaUpdate);
			preparedSt.setBoolean(1, true);
			preparedSt.setInt(2, idLibro);
			preparedSt.setInt(3, idSocio);
			
			preparedSt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarLibro(int id) {
		String sentenciaDelete = "DELETE FROM libros WHERE id = ?";
		try {
			PreparedStatement preparedSt = con.prepareStatement(sentenciaDelete);
			int idLibro = id;
			preparedSt.setInt(1, idLibro);
			preparedSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarSocio(int id) {
		String sentenciaDelete = "DELETE FROM socios WHERE id = ?";
		PreparedStatement preparedSt;
		try {
			preparedSt = con.prepareStatement(sentenciaDelete);
			int idSocio = id;
			preparedSt.setInt(1, idSocio);
			preparedSt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Libro> getLibros() {
		String sentenciaSelect = "SELECT * FROM libros";
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			Statement st = getCon().createStatement();
			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Libro libro = new Libro();
				libro.setId(resultado.getInt("id"));
				libro.setTitulo(resultado.getString("titulo"));
				libro.setAutor(resultado.getString("autor"));
				libro.setNumPag(resultado.getInt("num_pag"));

				libros.add(libro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public ArrayList<Socio> getSocios() {
		String sentenciaSelect = "SELECT * FROM socios";
		ArrayList<Socio> socios = new ArrayList<Socio>();
		try {
			Statement st = getCon().createStatement();
			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Socio socio = new Socio();
				socio.setId(resultado.getInt("id"));
				socio.setNombre(resultado.getString("nombre"));
				socio.setApellido(resultado.getString("apellido"));
				socio.setDireccion(resultado.getString("direccion"));
				socio.setPoblacion(resultado.getString("poblacion"));
				socio.setProvincia(resultado.getString("provincia"));
				socio.setDni(resultado.getString("dni"));

				socios.add(socio);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socios;
	}
	
	public ArrayList<Prestamo> getPrestamosDeSocio(int idSocio) {
		String sentenciaSelect = "SELECT * FROM prestamos WHERE id_socio = ?";
		ArrayList <Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			PreparedStatement preparedSt = con.prepareStatement(sentenciaSelect);
			preparedSt.setInt(1, idSocio);
			ResultSet resultado = preparedSt.executeQuery();
			
			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdLibro(resultado.getInt("id_libro"));
				prestamo.setIdSocio(resultado.getInt("id_socio"));
				prestamo.setFecha(resultado.getDate("fecha"));
				prestamo.setDevuelto(resultado.getBoolean("devuelto"));
				
				prestamos.add(prestamo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prestamos;
		
	}

	public Libro getLibro(int id) {
		String sentenciaSelect = "SELECT * FROM libros WHERE id = ? ";
		Libro libro = new Libro();
		try {
			PreparedStatement preparedSt = con.prepareStatement(sentenciaSelect);
			int idLibro = id;
			preparedSt.setInt(1, idLibro);
			ResultSet resultado = preparedSt.executeQuery();

			if (resultado.next()) {
				libro.setId(resultado.getInt("id"));
				libro.setTitulo(resultado.getString("titulo"));
				libro.setAutor(resultado.getString("autor"));
				libro.setNumPag(resultado.getInt("num_pag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libro;

	}
	
	public Socio getSocio(int id) {
		String sentenciaSelect = "SELECT * FROM socios WHERE id = ? ";
		Socio socio = new Socio();
		try {
			PreparedStatement preparedSt = con.prepareStatement(sentenciaSelect);
			preparedSt.setInt(1, id);
			ResultSet resultado = preparedSt.executeQuery();

			if (resultado.next()) {
				socio.setId(resultado.getInt("id"));
				socio.setNombre(resultado.getString("nombre"));
				socio.setApellido(resultado.getString("apellido"));
				socio.setDireccion(resultado.getString("direccion"));
				socio.setPoblacion(resultado.getString("poblacion"));
				socio.setProvincia(resultado.getString("provincia"));
				socio.setDni(resultado.getString("dni"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socio;

	}
	
	
	
	public int getIdConTitulo(String titulo) {
		int id = 0;
		String sentenciaSelect = "SELECT id FROM libros WHERE titulo = ? ";
		
		try {
			PreparedStatement preparedSt = con.prepareStatement(sentenciaSelect);
			String tituloLibro = titulo;
			preparedSt.setString(1, tituloLibro);
			ResultSet resultado = preparedSt.executeQuery();
			
			if (resultado.next()) {
				id = resultado.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;	
	}
	
	public int getIdConDni(String dni) {
		String sentenciaSelect = "SELECT id FROM socios WHERE dni = ? ";
		int id = 0;
		try {
			PreparedStatement preparedSt = con.prepareStatement(sentenciaSelect);
			preparedSt.setString(1, dni);
			ResultSet resultado = preparedSt.executeQuery();
			
			if (resultado.next()) {
				id = resultado.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
