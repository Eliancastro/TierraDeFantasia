import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Mapa {

	private HashMap<String, Pueblo> mapa;
	private static Mapa map;
	private String origen;
	private String destino;
	private double dias;

	private Mapa() {
		this.mapa = new HashMap<String, Pueblo>();
	}
    
	/*
	 * pre: Es necesario crear una unica instancia de Mapa.
	 * Post: Al crear Mapa solo crea un Mapa de esta instancia.
	 */
	public static Mapa getInstance() {

		if(map == null) {
			map = new Mapa(); 
		}

		return map;
	}
	
	/*
	 * pre: Se necesita conocer el Mapa.
	 * Post: Retorna el Mapa creado.
	 */
	public HashMap<String,Pueblo> getMapa(){

		return mapa;
	}
	
	/*
	 * pre: archivo debe ser distinto de null.
	 * post: procesa el archivo y crea el mapa con sus pueblos y caminos.
	 */
	public void cargarArchivo(String archivo) throws Exception{
		
		if (archivo.equals(null) ) 
			throw new ExceptionArchivoNulo("El archivo pasado es nulo");
			
		try {
			FileReader file = new FileReader(archivo);

			BufferedReader bf = new BufferedReader(file);
			Integer cantidadDePueblos = Integer.parseInt(bf.readLine().trim());
			String[] datos;
			
			
			for(int i = cantidadDePueblos-1; i >= 0; i--) {
				
				datos = bf.readLine().split(" ");
				
				if(datos[3].equalsIgnoreCase("Propio") || datos[3].equalsIgnoreCase("Aliado"))
					mapa.put(datos[0], new Pueblo(true));
				else
					mapa.put(datos[0], new Pueblo(false));
				
				if(datos[2].equalsIgnoreCase("Wrives")) {
					mapa.get(datos[0]).agregarWrives(Integer.parseInt(datos[1])/2);
				}
				
				if(datos[2].equalsIgnoreCase("Radaiteran")) {
					mapa.get(datos[0]).agregarRadaiteran(Integer.parseInt(datos[1])/2);
				}
				
				if(datos[2].equalsIgnoreCase("Reralopes")) {
					mapa.get(datos[0]).agregarReralopes(Integer.parseInt(datos[1])/2);
				}
				
				if(datos[2].equalsIgnoreCase("Nortaichian")) {
					mapa.get(datos[0]).agregarNortaichian(Integer.parseInt(datos[1])/2);
				}
			}
			
			datos = bf.readLine().split("->");
			origen = datos[0].trim();
			destino = datos[1].trim();
			
			String linea;
			while((linea = bf.readLine()) != null) {
				datos = linea.split(" ");
				agregarCamino(datos[0], datos[1], Integer.parseInt(datos[2]));		
			}
				
			bf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * pre: puebloInicial debe ser distinto de null. 
	 * post: retorna un HashMap con todos los caminos con menor peso y sus predecesores.
	 * Ademas guarda los dias que se tarda en llegar al destino.
	 */
	public HashMap<String, String> dijkstra(String puebloInicial) {

		PriorityQueue<Distancia> colaDePrioridad = new PriorityQueue<>();
		HashMap<String, String> predecesores = new HashMap<>();
		HashMap<String, Double> distancias = new HashMap<>();
		HashMap<String, Boolean> estaVisitado = new HashMap<>();

		for (String vertice : mapa.keySet()) {

			distancias.put(vertice, Double.MAX_VALUE);
			predecesores.put(vertice, null);
			estaVisitado.put(vertice, false);
		}

		distancias.put(puebloInicial, 0.0);

		colaDePrioridad.add(new Distancia(puebloInicial, 0.0));

		while (!colaDePrioridad.isEmpty()) {

			Distancia unaDistancia = colaDePrioridad.poll();

			if (!estaVisitado.get(unaDistancia.obtenerNombreDelPoblado())) {

				estaVisitado.put(unaDistancia.obtenerNombreDelPoblado(), true);

				HashSet<Camino> aristas = mapa.get(unaDistancia.obtenerNombreDelPoblado()).obtenerCaminosAdyacentes();

				for (Camino aristaAdyacente : aristas) {

					String verticeAdyacente = aristaAdyacente.destino;

					double nuevaDistancia = (unaDistancia.obtenerDistancia() + aristaAdyacente.peso);

					if (!estaVisitado.get(verticeAdyacente)
							&& nuevaDistancia < distancias.get(verticeAdyacente)) {

						distancias.put(verticeAdyacente, nuevaDistancia);
						predecesores.put(verticeAdyacente, unaDistancia.obtenerNombreDelPoblado());
						colaDePrioridad.add(new Distancia(verticeAdyacente, nuevaDistancia));
					}
				}
			}
		}
		dias = distancias.get(destino);
		return predecesores;
	}
    
	/*
	 * Pre: se deben agregar caminos entre los pueblos.
	 * post: crea los caminos entre estos pueblos.
	 */
	private void agregarCamino(String puebloOrigen, String puebloDestino, double peso) {

		Camino camino = new Camino(puebloDestino, peso);

		mapa.get(puebloOrigen).agregarCamino(camino);
	}

	@Override
	public String toString() {

		String mensaje = mapa.keySet().toString() + "\n";

		for (String vertice : mapa.keySet())
			mensaje += vertice + ": " + mapa.get(vertice).obtenerCaminosAdyacentes() + "\n";

		return mensaje;
	}
    
	/*
	 * pre: es necesario saber de donde se parte en el juego.
	 * post: nos devuelve el origen de partida.
	 */
	public String getOrigen() {
		return origen;
	}
    
	/*
	 * pre: se debe saber a donde se debe ir a conquistar.
	 * post: devuleve el destino que debe ser conquistado.
	 */
	public String getDestino() {
		return destino;
	}
	
	/*
	 * pre: se debe conocer la cantidad de dias que dura esta travesia.
	 * post: devulve la cantidad de dias que se tardo en llegar al destino.
	 */
	public double getDias() {
		return dias;
	}

}
