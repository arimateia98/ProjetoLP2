package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trackingThings.*;

public class SistemaTest {
	
	Sistema sistema;

	@Before
	public void setUp() throws Exception {
		
		sistema = new Sistema();
		sistema.cadastrarUsuario("Arizinho", "9900-6660","arizinho100%lindo@bol.com.br");
		sistema.cadastrarUsuario("Ramones", "9955-2222","ramon100%cancer@gmail.com");
		sistema.cadastrarUsuario("zezinho", "9988-8889", "zevinicin@yahoo.com.br");
		sistema.cadastrarUsuario("katiau", "9912-3456","katiau@gmail.com");
		// Adicionando para Arizinho 9900-6660
		sistema.cadastrarBluRayFilme("Arizinho", "9900-6660", "X-men", 29.99, 120, "Acao", "DEZESSEIS_ANOS", 2002);
		sistema.cadastrarBluRaySerie("Arizinho", "9900-6660", "Thw Walking Dead", 25.50, "zumbis", 160, "DOZE_ANOS", "Suspense", 2);
		sistema.cadastrarBluRayShow("Arizinho", "9900-6660", "RBD", 45.99, 90, 15, "REBELDES", "DOZE_ANOS");
		sistema.cadastrarJogoTabuleiro("Arizinho", "9900-6660", "damas", 0.99);
		sistema.cadastrarEletronico("Arizinho", "9900-6660", "Mario bros", 1.25, "NINTENDO");
		// Adicionando para Ramones 9955-2222
		sistema.cadastrarBluRayFilme("Ramones", "9955-2222", "Pirata dos caribes", 50.00, 120, "Acao", "DEZESSEIS_ANOS", 2015);
		sistema.cadastrarBluRaySerie("Ramones", "9955-2222", "Game of Thrones", 35.00, "lutas epicas", 180, "DEZESSEIS_ANOS", "Suspense", 6);
		sistema.cadastrarBluRayShow("Ramones", "9955-2222", "LS", 99.00, 90, 15, "Luan Santana", "DEZ_ANOS");
		sistema.cadastrarJogoTabuleiro("Ramones", "9955-2222", "xadrez", 100.00);
		sistema.cadastrarEletronico("Ramones", "9955-2222", "mario world", 1.00, "NINTENDO");
		// Adicionando para zezinho 9988-8889
		sistema.cadastrarBluRayFilme("zezinho", "9988-8889", "Brasileirinhas", 69.00, 60, "EROTICO", "DEZOITO_ANOS", 2013);
		sistema.cadastrarBluRaySerie("zezinho", "9988-8889", "Vikings", 99.00, "mitologia nordica", 120, "DOZE_ANOS", "Suspense", 3);
		sistema.cadastrarBluRayShow("zezinho", "9988-8889", "Los Hermanos", 99.00, 90, 15, "Losers manos", "LIVRE");
		sistema.cadastrarJogoTabuleiro("zezinho", "9988-8889", "Django", 24.00);
		sistema.cadastrarEletronico("zezinho", "9988-8889", "sonic", 1.00, "MEGA DRIVE");
		// Adicionando para katiau 9912-3456
		sistema.cadastrarBluRayFilme("katiau", "9912-3456", "Simpsons XXX", 50.00, 120, "EROTICO", "DEZOITO_ANOS", 2000);
		sistema.cadastrarBluRaySerie("katiau", "9912-3456", "Mr Robot", 86.00, "hacker", 160, "DEZESSEIS_ANOS", "Drama", 2);
		sistema.cadastrarBluRayShow("katiau", "9912-3456", "Ramones", 10.00, 60, 5, "Ramonetmal", "DEZ_ANOS");
		sistema.cadastrarJogoTabuleiro("katiau", "9912-3456", "War", 120.00);
		sistema.cadastrarEletronico("katiau", "9912-3456", "Bomba Patch", 1.00, "PS2");
						
				
	}
	
	@Test
	public void testGetInfoUsuario() {
		assertEquals("", "");
	}

}
