package testes;

import org.junit.Before;

import trackingThings.*;

import org.junit.Test;

public class SistemaEmprestimoTest {
	Sistema sistema;
	SistemaEmprestimo sistemaEmprestimo;
	
	@Before
	public void setUp(){
		sistema = new Sistema();
		sistemaEmprestimo = new SistemaEmprestimo();
		sistema.cadastrarUsuario("Ronaldinho, O bruxo", "6900-1099", "ronaldinhogaucho@gmail.com");
		sistema.cadastrarUsuario("Menino Neymar", "1066-6822", "neymarzete@gmail.com");
		sistema.cadastrarUsuario("Romario","8888-5555", "peixe@gmail.com");
		sistema.cadastrarJogoTabuleiro("Ronaldinho, O bruxo", "6900-1099", "Banco imobiliario", 50.00);
		sistema.registrarEmprestimo("Ronaldinho, O bruxo", "6900-1099", "Menino Neymar", "1066-6822", "Banco imobiliario", "10/08/2017", 7);
	}
	
	//Teste para emprestimo ja existente
	@Test(expected = IllegalArgumentException.class)
	public void test1(){
		sistema.registrarEmprestimo("Ronaldinho, O bruxo", "6900-1099", "Menino Neymar", "1066-6822", "Banco imobiliario", "18/08/2017", 7);	
	}
	
	//Teste para item ja emprestado
	@Test(expected = IllegalArgumentException.class)
	public void test2(){
		sistema.registrarEmprestimo("Ronaldinho, O bruxo", "6900-1099", "Romario", "8888-5555", "Banco imobiliario", "10/08/2017", 7);
	}
	
	//Teste para item não existente
	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		sistema.registrarEmprestimo("Ronaldinho, O bruxo", "6900-1099", "Menino Neymar", "1066-6822", "War", "10/08/2017", 7);
	}
	
	//Teste para usuario(s) nao cadastrado(s)
	@Test(expected = NullPointerException.class)
	public void test4(){
		sistema.registrarEmprestimo("Ronaldinho", "6900-1099", "Menino", "1066-6822", "Banco imobiliario", "10/08/2017", 7);
	}
	
	//Teste para devolver item nao existente
	@Test(expected = IllegalArgumentException.class)
	public void test5(){
		sistema.registrarEmprestimo("Ronaldinho, O bruxo", "6900-1099", "Menino Neymar", "1066-6822", "War", "10/08/2017", 7);
	}
}
