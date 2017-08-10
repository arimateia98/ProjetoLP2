package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.JogoEletronico;

public class JogoEletronicoTest {
	
	JogoEletronico jogoEletronico1;
	JogoEletronico jogoEletronico2;
	JogoEletronico jogoEletronico3;

	@Before
	public void setUp() throws Exception {
		jogoEletronico1 = new JogoEletronico("Skyrim", 120.00, "PC");
		jogoEletronico2 = new JogoEletronico("Fifa", 79.00, "Ps4");
		jogoEletronico3 = new JogoEletronico("Barbie World", 123.00, "Nintendinho");
	}

	@Test
	public void testGetPlataforma() {
		assertEquals(jogoEletronico1.getPlataforma(), "PC");
		assertEquals(jogoEletronico2.getPlataforma(), "Ps4");
		assertEquals(jogoEletronico3.getPlataforma(), "Nintendinho");
	}
	
	@Test
	public void testToString() {
		assertEquals(jogoEletronico1.toString(), "JOGO ELETRONICO: Skyrim, R$ 120.0, Nao emprestado, PC");
		assertEquals(jogoEletronico2.toString(), "JOGO ELETRONICO: Fifa, R$ 79.0, Nao emprestado, Ps4");
		assertEquals(jogoEletronico3.toString(), "JOGO ELETRONICO: Barbie World, R$ 123.0, Nao emprestado, Nintendinho");
	}

}
