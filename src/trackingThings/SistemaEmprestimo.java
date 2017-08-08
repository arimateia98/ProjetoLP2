package trackingThings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class SistemaEmprestimo {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
	
	public void registrarEmprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		EmprestimoKey emprestimoKey = new EmprestimoKey(usuarioDono, usuarioEmprestimo, item);
		
		if (emprestimos.containsKey(emprestimoKey)){
			throw new IllegalArgumentException("Emprestimo ja existe");
		}
		if(emprestimos.get(emprestimoKey).getEstadoItem()){
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
		if (emprestimos.get(emprestimoKey).getEstadoItem()){
			throw new IllegalArgumentException("Item emprestado no momento");
		}
		
		
		LocalDate date = LocalDate.parse(dataInicial, formatter);
		Emprestimo emprestimo = new Emprestimo(usuarioDono,usuarioEmprestimo,item,date,diasEmprestimo);
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
			LocalDate date = LocalDate.parse(dataDevolucao, formatter);
			emprestimos.get(emprestimoKey).devolverItem(date);
		}else{
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
		
		
		
	}
	
}
