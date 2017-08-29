package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.JogoTabuleiro;

public class JogoTabuleiroTest {
	JogoTabuleiro jogoTabuleiro1;
	JogoTabuleiro jogoTabuleiro2;
	JogoTabuleiro jogoTabuleiro3;

	@Before
	public void setUp() throws Exception {
		jogoTabuleiro1 = new JogoTabuleiro("War", 160.00);
		jogoTabuleiro2 = new JogoTabuleiro("Banco Imobiliario", 200);
		jogoTabuleiro3 = new JogoTabuleiro("Jogo da Vida", 150);
		jogoTabuleiro1.adicionarPecaPerdida("Canhao");
	}

	@Test
	public void testVerificaSeHaPecasPerdidas() {
		assertEquals(jogoTabuleiro1.seHaPecasPerdidas(), "COM PECAS PERDIDAS");
		assertEquals(jogoTabuleiro2.seHaPecasPerdidas(), "COMPLETO");
	}

	@Test
	public void testToString() {
		assertEquals(jogoTabuleiro1.toString(), "JOGO DE TABULEIRO: War, R$ 160.0, Nao emprestado, COM PECAS PERDIDAS");
		assertEquals(jogoTabuleiro2.toString(), "JOGO DE TABULEIRO: Banco Imobiliario, R$ 200.0, Nao emprestado, COMPLETO");
		assertEquals(jogoTabuleiro3.toString(), "JOGO DE TABULEIRO: Jogo da Vida, R$ 150.0, Nao emprestado, COMPLETO");
	}


}
