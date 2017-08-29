package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.BluRay;
import itens.BluRayFilme;
import itens.JogoEletronico;
import itens.JogoTabuleiro;

public class ItemTest {
	
	BluRay filme;
	JogoEletronico jogoEletronico;
	JogoTabuleiro jogoTabuleiro;
	

	@Before
	public void setUp() throws Exception {
		filme = new BluRayFilme("Os gatoes", 15.00, 90, "LIVRE", "COMEDIA", 2000);
		jogoEletronico = new JogoEletronico("Cobrinha", 0.50, "SmartPhone");
		jogoTabuleiro = new JogoTabuleiro("Tapa na Cara", 50.00);
		filme.setEstadoEmprestimo(true);
	}

	@Test
	public void testGetNome() {
		assertEquals(filme.getNome(), "Os gatoes");
		assertEquals(jogoEletronico.getNome(), "Cobrinha");
		assertEquals(jogoTabuleiro.getNome(), "Tapa na Cara");
	}
	
	@Test
	public void testGetValor() {
		assertEquals(filme.getValor(), 15.00, 15.0);
		assertEquals(jogoEletronico.getValor(), 0.50, 0.5);
		assertEquals(jogoTabuleiro.getValor(), 50.00, 50.0);
	}
	
	@Test
	public void testGetEstado() {
		assertEquals(filme.getEmprestado(), "Emprestado");
		assertEquals(jogoEletronico.getEmprestado(), "Nao emprestado");
		assertEquals(jogoTabuleiro.getEmprestado(), "Nao emprestado");
	}

}
