import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ejercito extends Guerrero{

	private PriorityQueue<Guerrero> ejercito;
	private Queue<Guerrero> colaHeridos;
	
	/*
	 * Constructor Necesario porque daba error al agregar un ejercito
	 * por carecer este mismo de salud
	 */
	public Ejercito() {
		this.salud = Integer.MAX_VALUE;
		this.ejercito = new PriorityQueue<Guerrero>(new Comparador());
		this.colaHeridos = new LinkedList<Guerrero>();
	}
    
	/*
	 * pre: se debe agregar guerrero al ejercito.
	 * post: se agrega el guerrero al ejercito.
	 */
	public void agregar(Guerrero guerrero) {
		
		ejercito.add(guerrero);
	}
	
	/*
	 * pre: se debe agregar los guerreros heridos a la cola de heridos.
	 * post: se agrega al guerrero a la cola de heridos.
	 */
	public void agregarColaDeHeridos(Guerrero guerrero) {
		
		Ejercito e = null;
		
		if(guerrero.estaHerido) {

			if(ejercito.isEmpty())         // Cuando el ejercito está vacío y un guerrero de la colaHeridos sale victorioso 
				colaHeridos.poll();        // Se lo saca y al final del método se lo vuelve a agregar para que quedé detrás de la cola
			
			if(!ejercito.isEmpty() && ejercito.peek().getSalud() != Integer.MAX_VALUE)  // Lo siento, he pecado. Acá lo que hice es una comparación implícita porque si no lo hago quita al ejercitoAliado.
				ejercito.poll();														// Basicamente lo que hace este método es quitar al guerrero del ejercito para agregarlo a la cola de heridos.
			
			if(ejercito.peek() != null && ejercito.peek().getSalud() == Integer.MAX_VALUE) {
				e = (Ejercito)ejercito.peek();
				e.ejercito.poll();
				if(e.ejercito.isEmpty())
					ejercito.poll();
			}
			
			
			
			colaHeridos.add(guerrero);		
		}
		
	}
	
	/*
	 * pre: se debe saber si quedan guerreros para el combate.
	 * post: devuelve si quedan querreros sin desmayarse.
	 */
	public boolean hayGuerreros() {
		
		return !ejercito.isEmpty() || !colaHeridos.isEmpty();
	}
	
	/*
	 * pre: se debe acceder a los guerreros.
	 * post: este metodo permite el acceso a los guerreros.
	 */
	public Guerrero getGuerrero() {
		Guerrero g = null;
		
		if(!ejercito.isEmpty()) {		
			
			if(ejercito.peek().getSalud() <= 0) // Este if sirve cuando el guerrero está "desmayado".
				return ejercito.poll();		 	// lo saca de la cola.
			
			g = ejercito.peek().getGuerrero();  // Esta inicialización sirve para que se active el método recursivo, es decir, si en la cola hay un ejercitoAliado se llama recursivamente.
			
			if(g == null) {          							// este if sirve cuando el ejercitoAliado se queda sin guerreros
				ejercito.poll();								 // como devuelve un null hago un ejercito.poll para quitar al ejercitoAliado
				if(!ejercito.isEmpty())
					g = ejercito.peek().getGuerrero(); 				// Y meto en la variable g al guerrero que le sigue.				
			}

			return g;
		}

		if(!colaHeridos.isEmpty()) {

			if(colaHeridos.peek().getSalud() <= 0)
				return colaHeridos.poll();
			
			return colaHeridos.peek().getGuerrero();		
		}	
		
		return null;
	}

	@Override
	public String toString() {
		
		String guerreros = "[";
		
		for (Guerrero guerrero : ejercito) {
			guerreros += guerrero.toString() + " ";
		}
		
		for (Guerrero guerrero : colaHeridos) {
			guerreros += guerrero.toString() + " ";
		}
		
		return guerreros + "]";
	}
  
	/*
	 * pre: se debe saber la cantidad de guerreros en pie.
	 * post: devuelve la cantidad de guerreros  en pie.
	 */
	public int getCantidadDeGuerreros() {
		
		Ejercito e = null;
		int total = 0;
		
		while(ejercito.peek() != null && ejercito.peek().getSalud() == Integer.MAX_VALUE) {
			e = (Ejercito) ejercito.poll();
			total += e.ejercito.size();
		}
		total += ejercito.size() + colaHeridos.size();
		
		return total;
	}

	/*
	 * pre: el ejercito debe descansar.
	 * post: el ejercito descansa para el siguiente combate.
	 */
	public void descansar() {
		
		for(Guerrero g : ejercito)
			g.descansar();
		
		for(Guerrero g : colaHeridos)
			g.descansar();
	}
	
}
