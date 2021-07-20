import org.junit.Assert;
import org.junit.Test;



public class TestPueblo {
	
	Mapa mapa = Mapa.getInstance();
	
	@Test
	public void TestCombate() throws Exception {
		mapa.cargarArchivo("C:/Users/User/Documents/4.txt");
		Ejercito e = new Ejercito();
		e.agregar(e);
		
		Pueblo p = new Pueblo(false);
		p.combate(e);
		Assert.assertEquals(1, e.getCantidadDeGuerreros());
	
	}
}
