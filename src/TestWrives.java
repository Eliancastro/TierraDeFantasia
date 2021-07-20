
import org.junit.*;

public class TestWrives {
	
	Wrives wr = new Wrives();
	Reralopes rera = new Reralopes();
	Radaiteran rada = new Radaiteran();
	Nortaichian nort = new Nortaichian();
	
	Enemigo en = new Enemigo();
	
	@SuppressWarnings("unused")
	@Test
	public void prueba001() { // crea un Wrives.
 		Wrives wrprueba = new Wrives();
	}
	
	@Test
	public void prueba002() { // salud
		Assert.assertEquals(108, (int)wr.getSalud());
	}
	
	@Test
	public void prueba003() { // ataque
		Assert.assertEquals(113, wr.atacar());
	}
	
	@Test
	public void prueba004() { // ataca a un enemigo
		en.recibirDanio(wr.atacar());
		Assert.assertEquals(387, (int)en.getSalud());
	}
	
	@Test
	public void prueba005() { // despues del segundo ataque, ataca con doble de daño.
		en.recibirDanio(wr.atacar());
		en.recibirDanio(wr.atacar());
		en.recibirDanio(wr.atacar());
		
		Assert.assertEquals(48, (int)en.getSalud());
	}
	
	@Test
	public void prueba006() { // como no lleva armadura recibe el doble de daño.
		wr.recibirDanio(en.atacar());
		
		Assert.assertEquals(88, (int)wr.getSalud());
	}
	
	@Test
	public void prueba007() { // descansa y se niega a atacar (En realidad ataca pero su daño es 0, se podría cambiar.)
		wr.descansar();
		en.recibirDanio(wr.atacar());
		
		Assert.assertEquals(500, (int)en.getSalud());
	}
	
	@SuppressWarnings("unused")
	@Test
	public void prueba008() { // crea un Wrives aliado
		Wrives wrives = new Wrives(true);
	}
	
	@Test
	public void prueba009() {
		Assert.assertEquals("[Wrives: salud=108]", wr.toString());	
	}
}