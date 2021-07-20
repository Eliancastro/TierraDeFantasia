
import java.util.Comparator;

public class Comparador implements Comparator<Guerrero> {
	
	/*
	 * Pre: se deben comparar los guerreros.
	 * post: compara guerrero1 con guerrero2.
	 */
	@Override
	public int compare(Guerrero g1, Guerrero g2) {

		return g1.compareTo(g2);
	}


}