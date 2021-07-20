
public class Nortaichian extends Raza{
	
	private int TurnosFuria;
	private int TurnosPiedra;
	
	/*
	 * pre: se debe crear el guerrero Nortaichian con los valores por defecto salud y danio basico.
	 * post:crea el guerrero y guarda sus valores de salud, danio basico e inicializa sus poderes furia y piedra.
	 */
	public Nortaichian() {
		super(66,18);
		TurnosFuria = 0;
		TurnosPiedra = 0;
	}
	
	/*
	 * pre: se debe crea el guerrero con los valores por defecto y el valor de verdad si es aliado o no.
	 * post: se crea el guerrero con los valores por defecto, el valor de verdad pasado por parametro y se inicializan sus poderes.
	 */
	public Nortaichian(boolean b) {
		super(66,18, b);
		TurnosFuria = 0;
		TurnosPiedra = 0;
	}
	
	/*
	 * pre: debe atacar comprobando si usa sus poderes y si no esta desmayado.
	 * post:ataca al enemigo con el poder que tenga habilitado si no esta desmayado.
	 */
	public int atacar() {
		
		if(TurnosPiedra > 0)
			return 0;
		
		if(salud < 66)
		salud = (int) (salud + salud*0.04);
		
		if(TurnosFuria > 0)
			return super.atacar() * 2;
		
		return super.atacar();
	}
	
	/*
	 * pre: debe restar el danio recibido por su enemigo.
	 * post: resta de su salud el danio recibido.
	 */
	public void recibirDanio(int danio) {
		if(TurnosPiedra > 0) {
			super.recibirDanio(danio/2);
			TurnosPiedra--;
		} else
		super.recibirDanio(danio);
		TurnosFuria = 2;
	}
	
	/*
	 * pre: debe descansar, activar su poder de piedra y recuperar su salud.
	 * post: activa su poder de piedra, recupera su salud y pone descansado en true.
	 */
	public void descansar() {
		TurnosPiedra = 2;
		salud = 66;
		descansado = true;
	}
	
	public String toString() {
		
		return "[Nortaichian:" + super.toString();
	}

}
