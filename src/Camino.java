
public class Camino {

	public final String destino;
	public final double peso;
	
	/*
	 * Pre: es necesario crear los caminos entre los pueblos.
	 * post: crea el camino, guarda el destino y los dias tardados de un pueblo a otro..
	 */
	public Camino(String destino, double peso) {
		
		this.destino = destino;
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		
		return destino + " (" + (int) peso + ")";
	}
}