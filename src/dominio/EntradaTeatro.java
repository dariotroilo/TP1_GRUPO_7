package dominio;

import java.util.Arrays;

public class EntradaTeatro extends Entrada implements ICosto {
	
	@Override
	public String toString() {
		return "EntradaTeatro [genero=" + genero + ", artistas=" + Arrays.toString(artistas) +" Costo: "+costo+ "]";
	}

	private final static double valorEntrada = 1350.50;
	private String genero;
	private String artistas[];
	private double costo;
	
	public EntradaTeatro(String nombre, String genero, String artistas[], Fecha fecha, int duracion, char Tipo) {
		super(nombre, fecha, duracion);
		this.costo = devolverCosto(Tipo);
		
		if (validarArtistas(artistas)) {
			setArtistas(artistas);
		} else {
			System.out.println("Se excedi� el numero de artistas principales");
			System.exit(0);
		}
		
		if (validaGenero(genero)) {
			this.genero = genero;
		}
		else {
			System.out.println("G�nero no existente para la entrada de teatro");
			System.exit(0);
		}
	}

	
	private boolean validarArtistas(String[] artistas) {
		return (artistas.length<=3);
		
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String[] getArtistas() {
		return artistas;
	}

	public void setArtistas(String[] artistas) {
		this.artistas = artistas;
	} 
	
	public boolean validaGenero(String nombreGenero) {
		boolean existe = existeGenero(nombreGenero) != -1 ? true : false;
		return existe;
	}
	
	public int existeGenero(String busqueda) {
		String generos[] = {"Drama","Teatro","Comedia"};

		for (int i = 0; i < generos.length ; i++) {
			if (busqueda.toUpperCase().equals(generos[i].toUpperCase())) {
		      return i;
		    }
		}
		return -1;
	}


	@Override
	public double devolverCosto(double dato) {

		return valorEntrada;
	}
	
}
