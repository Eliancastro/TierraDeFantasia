
import java.util.HashMap;
import java.util.Stack;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		
		Mapa mapa = Mapa.getInstance();
		Ejercito ejercitoPropio = new Ejercito();
		
		mapa.cargarArchivo("C:/Users/User/Documents/8.txt");
		
		System.out.println(mapa);  // imprime el mapa
		
		System.out.println("-----------");
		
		System.out.println(mapa.dijkstra(mapa.getOrigen()));  // imprime los caminos minimos.
		
		System.out.println();
		
		HashMap<String, String> caminos = mapa.dijkstra(mapa.getOrigen());
	
		String destino = mapa.getDestino();;
		Stack<String> pila = new Stack<String>();
		
		while(destino != null) {
			pila.add(destino);
			destino = caminos.get(destino);
		}
		
		mapa.getMapa().get(pila.pop()).unirse(ejercitoPropio);
		
		String pueblo = null;
		while(ejercitoPropio.hayGuerreros() && !pila.isEmpty()) {
			pueblo = pila.pop();
			if(mapa.getMapa().get(pueblo).esAliado()) {
				ejercitoPropio.descansar();
				mapa.getMapa().get(pueblo).unirse(ejercitoPropio);				
			} else
				mapa.getMapa().get(pueblo).combate(ejercitoPropio);			
		}


		if(ejercitoPropio.hayGuerreros())
			System.out.println("Victoria! Se llegó con " + ejercitoPropio.getCantidadDeGuerreros() + " guerreros y este viaje se hizo en un total de " + mapa.getDias() + " días");
		else
			System.out.println("Derrota! No se logró pasar del pueblo " + pueblo);
	}
}