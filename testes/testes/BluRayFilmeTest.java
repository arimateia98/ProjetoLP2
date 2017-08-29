package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.BluRayFilme;

public class BluRayFilmeTest {

	BluRayFilme filme1;
	BluRayFilme filme2;
	BluRayFilme filme3;
	
	@Before
	public void setUp() throws Exception {
		
		filme1 = new BluRayFilme("Xmen", 15, 180, "DOZE_ANOS", "Comedia", 2003);
		filme2 = new BluRayFilme("Uma noite no museu", 20.99, 150, "LIVRE", "EROTICO", 2015);
		filme3 = new BluRayFilme("LALALAND - Pirata", 1.50, 118, "DEZ_ANOS", "Musical", 2016);
	}

	@Test
	public void testGetGenero() {
		
		assertEquals("Comedia", filme1.getGenero());
		assertEquals("EROTICO", filme2.getGenero());
		assertEquals("Musical", filme3.getGenero());
	}

	@Test
	public void testGetAnoDeLancamento() {
		
		assertEquals(2003, filme1.getAnoDeLancamento());
		assertEquals(2015, filme2.getAnoDeLancamento());
		assertEquals(2016, filme3.getAnoDeLancamento());
	}

	@Test
	public void testToString() {
		
		assertEquals("FILME: Xmen, R$ 15.0, Nao emprestado, 180 min, DOZE_ANOS, Comedia, 2003", filme1.toString());
		assertEquals("FILME: Uma noite no museu, R$ 20.99, Nao emprestado, 150 min, LIVRE, EROTICO, 2015", filme2.toString());
		assertEquals("FILME: LALALAND - Pirata, R$ 1.5, Nao emprestado, 118 min, DEZ_ANOS, Musical, 2016", filme3.toString());
	}

}
