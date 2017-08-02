package trackingThings;

import java.util.Set;

public class JogoTabuleiro extends Item{
	
	private Set<String> pecasPerdidas;

	public JogoTabuleiro(String nome, int valor, Set<String> pecasPerdidas) {
		super(nome, valor);
		this.pecasPerdidas = pecasPerdidas;
	}

	public boolean equals(JogoTabuleiro jogo) {
		if (this.nome.equals(jogo.nome)) {
			if (this.pecasPerdidas.equals(jogo.pecasPerdidas)) {
				return true;
			}
			return false;
		}
		return false;
	}

}
