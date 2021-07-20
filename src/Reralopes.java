
public class Reralopes extends Raza{
	
	public int turnosDeAtaqueDoble = 0;
	public int cantidadDeAtaquesDados = 0;
	
	/*
	 * pre: crear el guerrero con los valores por defecto.
	 * post: crea el guerrero con los valores por defecto.
	 */
	public Reralopes() {
		super(53,27);
	}
	
	/*
	 * pre: crear el guerrero con los valores por defecto y si es aliado o no.
	 * post: crea el guerrero con los valores por defecto e inidica si es aliado o no.
	 */
	public Reralopes(boolean b) {
		super(53,27,b);
	}
	
	/*
	 * pre: se debe atacar al enemigo.
	 * post: se ataca al enemigo con su ataque especial en caso de que corresponda.
	 */
	public int atacar() {
		cantidadDeAtaquesDados++;
		
		if(cantidadDeAtaquesDados % 2 == 0) {
			return 0;
		}
		
		if(turnosDeAtaqueDoble > 0) {
			return super.atacar()*2;
			
		}
		
		return super.atacar();
	}
	
	/*
	 * pre: se debe restar de la salud el danio recibido.
	 * post: se resta de la salud el danio recibido por el enemigo.
	 */
	public void recibirDanio(int danio) {
		turnosDeAtaqueDoble = 0;
		super.recibirDanio(danio);
	}
	
	/*
	 * pre: debe descansar.
	 * post: descansa y pone descansado en true.
	 */
	public void descansar() {
		turnosDeAtaqueDoble = 3;
		descansado = true;
	}
	
	public String toString() {
		
		return "[Reralopes:" + super.toString();
	}
}
