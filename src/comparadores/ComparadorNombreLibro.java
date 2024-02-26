package comparadores;

import java.util.Comparator;

import clases.Libro;

public interface ComparadorNombreLibro extends Comparator<Libro> {

	@Override
	default int compare(Libro o1, Libro o2) {
		return o1.getTitulo().compareTo(o2.getTitulo());
	}

}
