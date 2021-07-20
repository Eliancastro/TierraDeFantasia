
public class Distancia implements Comparable<Distancia> {

	private String nombre;
	private Double distancia;
	
	/*
	 * pre: se debe crear la distancia entre pueblos.
	 * post: guarda la distancia entre los pueblos.
	 */
	public Distancia(String nombre, Double distancia) {
		
		this.nombre = nombre;
		this.distancia = distancia;
	}
	
    /*
     * pre: se debe conocer el nombre del pueblo para reconocerlos.
     * post: nos devuelve el nombre del pueblo.
     */	
	public String obtenerNombreDelPoblado() {
		return this.nombre;
	}
	
	/*
	 * pre: se debe saber la distancia que separa un pueblo del otro.
	 * post: devuelve esta distancia.
	 */
	public Double obtenerDistancia() {
		
		return this.distancia;
	}
	
	/*
	 * pre: se deben conparar todas las distancia para luego conocer el camino minimo.
	 * post: compara las distancias entre si.
	 */
	@Override
	public int compareTo(Distancia otra) {
		
		return this.distancia.compareTo(otra.distancia);
	}
}