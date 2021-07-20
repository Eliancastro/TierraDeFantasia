
public abstract class Raza extends Guerrero{
	
	/*
	 * pre: se debe crear la raza de los guerreros con su salud, danio basico, inicializar esAliado,
	 * inicializar estaHerido, inicializar descansado.
	 * post: se crea la raza con la salud, el danio basico, se inicializa es aliado, estaHerido y descansado.
	 */
	Raza(int salud, int danioBasico) {
		this.salud = salud;
		this.danioBasico = danioBasico;
		this.esAliado = false;
		this.estaHerido = false;
		this.descansado = false;
	}
	
	/*
	 * pre: se debe crear la raza de los guerreros con su salud, danio basico, si es propio o no, inicializar esAliado,
	 * inicializar estaHerido, inicializar descansado.
	 * post: se crea la raza con la salud, el danio basico, si es propio o no, se inicializa es aliado, estaHerido y descansado.
	 */
	Raza(int salud, int danioBasico, boolean esPropio) {
		this.salud = salud;
		this.danioBasico = danioBasico;
		this.esAliado = esPropio;
		this.estaHerido = false;
		this.descansado = false;
	}
	/*
	 * pre: se debe obtener el guerrero.
	 * post: se devuelve el guerrero.
	 */
	public Guerrero getGuerrero() {
		return this;
	}
	
	/*
	 * pre: se debe modificar la salud.
	 * post: se modifica la salud del guerrero.
	 */
	public void setSalud(int salud) {
		this.salud = salud;
	}
}
