import org.junit.Assert;
import org.junit.Test;

public class TestMapa {
	
	Mapa mapa = Mapa.getInstance();
	
	@Test
	public void testDijkstra() throws Exception {
		
		mapa.cargarArchivo("C:/Users/User/Documents/4.txt");
		
		Assert.assertEquals("{1=null, 2=1, 3=1, 4=3, 5=3, 6=5, 7=6, 8=7, 9=7, 10=9}", mapa.dijkstra("1").toString());
	}
	

	@Test
	public void testDestino() throws Exception {
		
		mapa.cargarArchivo("C:/Users/User/Documents/4.txt");
		String destino = mapa.getDestino();
		Assert.assertEquals("9",destino);
	}
	
	@Test
	public void testOrigen() throws Exception {
		
		mapa.cargarArchivo("C:/Users/User/Documents/4.txt");
		String origen = mapa.getOrigen();
		Assert.assertEquals("1",origen);
	}
	
	/*@Test 
	public void testCargarArchivo() throws Exception { 
		mapa.cargarArchivo("C:/Users/User/Documents/4.txt");
		
	}*/

}
