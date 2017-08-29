package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.BluRay;
import itens.BluRayFilme;
import itens.BluRayShow;

public class BluRayTest {
	
	BluRay filme;
	BluRay show;
	BluRay temporada;

	@Before
	public void setUp() throws Exception {
		
		filme = new BluRayFilme("LALALAND", 15.50, 150, "DEZESSEIS ANOS", "MUSICAL", 2099);
		show = new BluRayShow("van halen no brasil", 15, 160, 13, "Van Halen", "QUATORZE ANOS");
		temporada = new BluRayFilme("piratas do caribe", 20, 170, "DOZE ANOS", "EROTICO", 2005);
	}

	@Test
	public void testDuracao() {
		
		assertEquals(150, filme.getDuracao());
		assertEquals(160, show.getDuracao());
		assertEquals(170, temporada.getDuracao());		
	}
	
	@Test
	public void testClassificacao() {
		
		assertEquals("DEZESSEIS ANOS", filme.getClassificacao());
		assertEquals("QUATORZE ANOS", show.getClassificacao());
		assertEquals("DOZE ANOS", temporada.getClassificacao());
	}
	
	@Test
	public void testEquals() {
		
		BluRay LalaLandPirata = new BluRayFilme("LALALAND", 2, 100, "DEZ ANOS", "Terror", 2098);
		assertEquals(true, LalaLandPirata.equals(filme));
		
		BluRay LalaLandFalso = new BluRayFilme("la la landy", 15.50, 150, "DEZESSEIS ANOS", "MUSICAL", 2099);
		assertEquals(false, LalaLandFalso.equals(filme));
	}	
 
}
