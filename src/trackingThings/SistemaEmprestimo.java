package trackingThings;


import java.util.HashMap;

/**
 * @author Jose de Arimateia
 *
 */
public class SistemaEmprestimo {
	
	private HashMap<EmprestimoKey,Emprestimo> emprestimos;
	
	public SistemaEmprestimo(){
		emprestimos = new HashMap<EmprestimoKey,Emprestimo>();
	}
	
	/**
	 * Realiza o cadastro de emprestimos ao obter os parametros
	 * @param usuarioDono
	 * @param usuarioEmprestimo
	 * @param item
	 * @param dataInicial
	 * @param diasEmprestimo
	 */
	
	public void registrarEmprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item, String dataInicial,int diasEmprestimo){
		EmprestimoKey emprestimoKey = new EmprestimoKey(usuarioDono, usuarioEmprestimo, item);
		usuarioDono.adicionaEmEmprestados(item);
		Emprestimo emprestimo = new Emprestimo(usuarioDono,usuarioEmprestimo,item,dataInicial,diasEmprestimo);
		usuarioDono.getItem(item.getNome()).emprestimosOcorridos.add(emprestimo);
		usuarioDono.AdicionaEmEmprestando(emprestimo);
		usuarioEmprestimo.adicionaEmEmprestimosPego(emprestimo);
		emprestimos.put(emprestimoKey, emprestimo);
	}
	
	/**
	 * Altera o estado do emprestimo ao obter os parametros
	 * @param usuarioDono
	 * @param usuarioEmprestimo
	 * @param item
	 * @param dataInicial
	 * @param dataDevolucao
	 */
	
	public void devolverItem(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,String dataDevolucao){
		EmprestimoKey emprestimoKey = new EmprestimoKey(usuarioDono, usuarioEmprestimo, item);
		if (emprestimos.containsKey(emprestimoKey)){
			emprestimos.get(emprestimoKey).devolverItem(dataDevolucao);
		}else{
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
		
		usuarioDono.removeEmEmprestados(item);
		
	}

	public HashMap<EmprestimoKey, Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(HashMap<EmprestimoKey, Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
}
