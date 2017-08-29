package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.BluRayFilme;
import itens.JogoEletronico;
import itens.JogoTabuleiro;
import trackingThings.Emprestimo;
import trackingThings.Usuario;

public class EmprestimoTest {
	
	
	Usuario carlos;
	Usuario maria;
	
	Emprestimo emprestimo;
	
	JogoEletronico assassinsCreed;
	
	@Before
	public void setUp() throws Exception {
		
		carlos = new Usuario("Carlos Maia", "96644966", "ramonetmaluco@hotmail.com");
		maria = new Usuario("Maria madaglena", "123123", "maria@bol.com");
		
		assassinsCreed = new JogoEletronico("Assassins Creed 3", 80, "PLAY 2");
		emprestimo = new Emprestimo(carlos, maria, assassinsCreed, "25/11/2017", 3);

	}


	@Test
	public void testDevolverItem() {
		
		assertEquals(true, assassinsCreed.getEstadoEmprestimo());
		emprestimo.devolverItem("26/11/2017");
		assertEquals(false, assassinsCreed.getEstadoEmprestimo());
	}

	@Test
	public void testGetDataDevolucao() {
		
		assertEquals(null, emprestimo.getDataDevolucao());
		emprestimo.devolverItem("26/11/2017");
		assertEquals("26/11/2017", emprestimo.getDataDevolucao());	
	}


	@Test
	public void testGetEstadoItem() {
		
		assertEquals(true, emprestimo.getEstadoItem());
		emprestimo.devolverItem("01/12/2017");
		assertEquals(false, emprestimo.getEstadoItem());
	}

	@Test
	public void testGetUsuarioDono() {
		
		assertEquals(carlos, emprestimo.getUsuarioDono());
	}

	@Test
	public void testGetDiasEmprestimo() {
		
	}

	@Test
	public void testGetUsarioEmprestimo() {
		
		assertEquals(maria, emprestimo.getUsarioEmprestimo());
	}

	@Test
	public void testGetItem() {
		
		assertEquals(assassinsCreed, emprestimo.getItem());
	}

	@Test
	public void testEqualsObject() {
		
		Usuario johnny = new Usuario("johnny", "123", "kkk@kkk.kkk");
		JogoTabuleiro war  = new JogoTabuleiro("War", 180);
		
		Emprestimo emprestimo2 = new Emprestimo(carlos, maria, assassinsCreed, "12/12/2005", 4);
		assertEquals(true, emprestimo.equals(emprestimo2));
		
		Emprestimo emprestimo3 = new Emprestimo(johnny, maria, assassinsCreed, "12/12/2005", 4);
		assertEquals(false, emprestimo.equals(emprestimo3));
		
		Emprestimo emprestimo4 = new Emprestimo(carlos, johnny, assassinsCreed, "12/12/2005", 4);
		assertEquals(false, emprestimo.equals(emprestimo4));

		Emprestimo emprestimo5 = new Emprestimo(carlos, maria, war, "12/12/2005", 4);
		assertEquals(false, emprestimo.equals(emprestimo5));
	}

	@Test
	public void testToString() {
		
		assertEquals("EMPRESTIMO - De: Carlos Maia, Para: Maria madaglena,"
				+ " Assassins Creed 3, 25/11/2017, 3 dias, ENTREGA: "
				+ "Emprestimo em andamento" , emprestimo.toString());
	}

	@Test
	public void testGetDiasAtrasado() {
		
		assertEquals(0,emprestimo.getDiasAtrasado());
		emprestimo.devolverItem("30/11/2017");
		assertEquals(2,emprestimo.getDiasAtrasado());
	}

	@Test
	public void testCalculaReputacao() {
		
		assertEquals(0, 0, maria.getReputacao());
		emprestimo.devolverItem("26/11/2017");
		assertEquals(4, maria.getReputacao(), 0);
		
		Emprestimo emprestimo2 = new Emprestimo(carlos, maria, assassinsCreed, "01/12/2017", 2);
		emprestimo2.devolverItem("04/12/2017");
		assertEquals(3.2, maria.getReputacao(), 0);
	}

}
