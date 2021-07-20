import java.util.HashSet;

public class Pueblo {

	private Ejercito pueblo;
	private boolean esAliado;
	private HashSet<Camino> caminosAdyacentes;
	
	/*
	 * pre: se debe crear el pueblo sabiendo si es aliado o no y con sus caminos adyacentes. 
	 * post: se crea el pueblo, los caminos adyacentes y se inicializa esAliado con el valor de verdad que llega por parametro.
	 */
	public Pueblo(boolean esAliado) {
		this.caminosAdyacentes = new HashSet<>();
		this.esAliado = esAliado;
		this.pueblo = new Ejercito();
	}
	
	/*
	 * pre: crear Radaiteran.
	 * post: se crean la cantidad de guerreros recibidos por parametro.
	 */
	public void agregarRadaiteran(int cantidadDeGuerreros) {
		
		for(int i = cantidadDeGuerreros; i > 0; i--) {
			pueblo.agregar(new Radaiteran());
		}
	}
	
	/*
	 * pre: crear Wrives.
	 * post: se crea la cantidad de Wrives recibidos por parametro.
	 */
	public void agregarWrives(int cantidadDeGuerreros) {
		
		for(int i = cantidadDeGuerreros; i > 0; i--) {
			pueblo.agregar(new Wrives());
		}
	}
	
	/*
	 * pre: crear Nortaichian.
	 * post: se crea la cantidad de Nortaichian recibidos por parametro.
	 */
	public void agregarNortaichian(int cantidadDeGuerreros) {
		
		for(int i = cantidadDeGuerreros; i > 0; i--) {
			pueblo.agregar(new Nortaichian());
		}
	}
	
	/*
	 * pre: crear Reralopes.
	 * post: se crea la cantidad de Reralopes recibidos por parametro.
	 */
	public void agregarReralopes(int cantidadDeGuerreros) {
		
		for(int i = cantidadDeGuerreros; i > 0; i--) {
			pueblo.agregar(new Reralopes());
		}
	}
	
	/*
	 * pre: se deben obtener los caminos adyacentes.
	 * post: se retornan los caminos adyacentes.
	 */
	public HashSet<Camino> obtenerCaminosAdyacentes() {

		return this.caminosAdyacentes;
	}
	
	public void agregarCamino(Camino camino) {

		this.caminosAdyacentes.add(camino);
	}

	public boolean esAliado() {

		return this.esAliado;
	}

	@Override
	public String toString() {

		return this.caminosAdyacentes.toString();
	}
	
	
	/*
	 * Este metodo sirve para el combate contra el ejercito del pueblo.
	 */
	public void combate(Ejercito e1) {

		while(e1.hayGuerreros() && this.pueblo.hayGuerreros()) {
			Guerrero g1 = e1.getGuerrero();
			Guerrero g2 = this.pueblo.getGuerrero();

			if(g1 != null && g2 != null) {
				while(g1.getSalud() > 0 && g2.getSalud() > 0) {


					if(g1.getSalud() > 0)
						g2.recibirDanio(g1.atacar());

					if(g2.getSalud() > 0)
						g1.recibirDanio(g2.atacar());
				}

				if(g1.getSalud() > 0) {
					e1.agregarColaDeHeridos(g1);
					this.pueblo.getGuerrero();
				} else {
					this.pueblo.agregarColaDeHeridos(g2);
					e1.getGuerrero();
				}
			}
		}
	}
	
	/*
	 * pre: el ejercito alido debe unirse al ejercito propio.
	 * post: el aliado se une al ejercito propio.
	 */
	public void unirse(Ejercito ejercitoPropio) {

		ejercitoPropio.agregar(pueblo);

	}
	
	/*
	 * pre: se debe descansar al ejercito.
	 * post:se descansa al ejercito para el proximo combate.
	 */
	public void descansar(Ejercito ejercitoPropio) {
		ejercitoPropio.descansar();
	}
}

