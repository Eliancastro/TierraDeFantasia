
public abstract class Guerrero implements Comparable<Guerrero>{
	
	protected int salud;
	protected int danioBasico;
	protected boolean esAliado;
	protected boolean estaHerido;
	protected boolean descansado;

	public abstract Guerrero getGuerrero();
	
	/*
	 * pre: se debe conocer la salud del guerrero.
	 * post: devuelve la salud del guerrero.
	 */
	public int getSalud() {
		return this.salud;
	}
	
	/*
     * pre: se debe saber si el guerrero esta herido
     * post:devuelve el valor de verdad si el guerrero esta herido o no.
     */
	public boolean estaHerido() {
		return this.estaHerido;
	}
	
	/*
	 * pre: los ejercitos deben descansar para mejorar su rendimiento.
	 * post: el ejercito descansa.
	 */
	public abstract void descansar();
	
	/*
	 * pre: se debe restar el danio recibido.
	 * post:resta el danio recibido de la salud del guerrero.
	 */
	public void recibirDanio(int danio) {
		salud-=danio;
		estaHerido = true;
	}
	
	/*
	 * pre: se debe atacar a los enemigos.
	 * post: ataca al enemigo.
	 */
	public int atacar() {
		return this.danioBasico;
	}
	
	public String toString() {
		
		return " salud=" + this.salud + "]";
	}
	
	public int compareTo(Guerrero g) {
		
		if(this.esAliado() == false && g.esAliado() == true)
			return 1;
		else
			return -1;
	}
    
	/*
	 * pre: se debe saber si es alido o no.
	 * post: devuelve el valor de verdad de si es aliado o no.
	 */
	private boolean esAliado() {
		
		return this.esAliado;
	}
	
	
}
