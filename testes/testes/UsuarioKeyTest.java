package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.UsuarioKey;

public class UsuarioKeyTest {
	
	UsuarioKey usuarioKey1;
	UsuarioKey usuarioKey2;
	UsuarioKey usuarioKey3;

	@Before
	public void setUp() throws Exception {
		usuarioKey1 = new UsuarioKey("zezinho","2678390213");
		usuarioKey2 = new UsuarioKey("ramones","536747829");
		usuarioKey3 = new UsuarioKey("katiau","3467721124");
	}

	@Test
	public void testToString() {
		assertEquals(usuarioKey1.toString(), "zezinho2678390213");
		assertEquals(usuarioKey2.toString(), "ramones536747829");
		assertEquals(usuarioKey3.toString(), "katiau3467721124");
	}

}
