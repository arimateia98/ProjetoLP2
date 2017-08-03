package trackingThings;

import java.util.HashSet;

public class SistemaEmprestimo {
	
	private HashSet<Emprestimo> emprestimos;
	
	public SistemaEmprestimo(){
		emprestimos = new HashSet<Emprestimo>();
	}
	
	public void registrarEmprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		Emprestimo emprestimo = new Emprestimo(usuarioDono, usuarioEmprestimo, item, dataInicial, diasEmprestimo);
		if (emprestimos.contains(emprestimo)){
			throw new IllegalArgumentException("Emprestimo já existe");
		}
		emprestimos.add(emprestimo);
	}
	
	public void devolverItem(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		
	}
	
}
