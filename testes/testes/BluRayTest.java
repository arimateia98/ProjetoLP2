package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.BluRay;
import trackingThings.BluRayFilme;

public class BluRayTest {
	
	BluRay filme;
	BluRay show;
	BluRay temporada;

	@Before
	public void setUp() throws Exception {
		
		filme = new BluRayFilme("LALALAND", 15.50, 150, "MUSICAL", "DEZESSEIS_ANOS", 2099);
		show = new BluRayFilme("LALALAND", 15.50, 150, "MUSICAL", "DEZESSEIS_ANOS", 2099);
		temporada = new BluRayFilme("LALALAND", 15.50, 150, "MUSICAL", "DEZESSEIS_ANOS", 2099);

	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
