
import org.junit.*;

public class TestNortaichian {
	
	Nortaichian nortaichian = new Nortaichian();
	Enemigo enemigo = new Enemigo();
	
	@SuppressWarnings("unused")
	@Test
	public void prueba001() { // crea un Nortaichian
		Nortaichian nortaichian = new Nortaichian();
	}
	
	@Test
	public void prueba002() { // salud
		Assert.assertEquals(66, (int)nortaichian.getSalud());
	}
	
	@Test
	public void prueba003() { // ataque
		Assert.assertEquals(18, (int)nortaichian.atacar());
	}
	
	@Test
	public void prueba004() { // No se cura porque tiene salud maxima
		nortaichian.atacar();
		Assert.assertEquals(66, (int)nortaichian.getSalud());
	}
	
	@Test
	public void prueba005() { // recibe daño, ataca y se cura.
		nortaichian.recibirDanio(enemigo.atacar());
		nortaichian.atacar();		
		Assert.assertEquals(58, (int)nortaichian.getSalud());
	}
	@Test 
	public void prueba006() { // recibe daño 
		nortaichian.recibirDanio(enemigo.atacar());
		Assert.assertEquals(36, nortaichian.atacar());
	}
	
	@Test
	public void prueba007() { // descansa, se vuelve piedra y reduce el daño recibido a la mitad por 2 turnos.
		nortaichian.descansar();
		nortaichian.recibirDanio(enemigo.atacar());
		nortaichian.recibirDanio(enemigo.atacar());
		nortaichian.recibirDanio(enemigo.atacar());
		Assert.assertEquals(46, (int)nortaichian.getSalud());
	}
	@Test
	public void prueba008() { // descansa y no puede atacar.
		nortaichian.descansar();
		enemigo.recibirDanio(nortaichian.atacar());
		Assert.assertEquals(500, (int)enemigo.getSalud());
	}
}