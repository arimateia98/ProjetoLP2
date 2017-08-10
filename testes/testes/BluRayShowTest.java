package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.BluRay;
import trackingThings.BluRayShow;

public class BluRayShowTest {
	
	BluRayShow bluray1;
	BluRayShow bluray2;
	BluRayShow bluray3;

	@Before
	public void setUp() throws Exception {
		
		bluray1 = new BluRayShow("vivaldi na grecia", 15, 150, 20, "Vivaldi", "LIVRE");
		bluray2 = new BluRayShow("Sepultura, so as melhores", 1.99, 100, 13, "Sepultura", "QUATORZE_ANOS");
		bluray3 = new BluRayShow("Wish you were here", 30, 180, 5, "Pink Floyd", "LIVRE");
	}

	@Test
	public void testGetNomeArtista() {
		
		assertEquals("Vivaldi", bluray1.getNomeArtista());
		assertEquals("Sepultura", bluray2.getNomeArtista());
		assertEquals("Pink Floyd", bluray3.getNomeArtista());
		
		assertNotEquals("Ze ramalho", bluray3.getNomeArtista());
	}

	@Test
	public void testGetNumeroDeFaixas() {
		
		assertEquals(20, bluray1.getNumeroDeFaixas());
		assertEquals(13, bluray2.getNumeroDeFaixas());
		assertEquals(5, bluray3.getNumeroDeFaixas());
		
		assertNotEquals(5000, bluray3.getNumeroDeFaixas());
	}

	@Test
	public void testToString() {
		
		assertEquals("SHOW: vivaldi na grecia, R$ 15.0, Nao emprestado, 150 min, LIVRE, Vivaldi, 20 faixas", bluray1.toString());
		assertEquals("SHOW: Sepultura, so as melhores, R$ 1.99, Nao emprestado, 100 min, QUATORZE_ANOS, Sepultura, 13 faixas", bluray2.toString());
		assertEquals("SHOW: Wish you were here, R$ 30.0, Nao emprestado, 180 min, LIVRE, Pink Floyd, 5 faixas", bluray3.toString());
	}

}
