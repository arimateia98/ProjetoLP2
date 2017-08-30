package controllers;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import itens.Item;
import keys.EmprestimoKey;
import trackingThings.Emprestimo;
import trackingThings.Usuario;

/**
 * @author Jose de Arimateia
 *
 */
public class ControllerEmprestimo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<EmprestimoKey,Emprestimo> emprestimos;
	
	public ControllerEmprestimo(){
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
		usuarioDono.getItem(item.getNome()).getEmprestimosOcorridos().add(emprestimo);
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

	public void lerEmprestimos() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emprestimos.txt"));
		try {
			while(true) {
				
				Emprestimo emprestimo = (Emprestimo) ois.readObject();
				emprestimos.put(new EmprestimoKey(emprestimo.getUsuarioDono(), emprestimo.getUsarioEmprestimo(), emprestimo.getItem()), emprestimo);
			}
		}
		catch(EOFException e) {
			
		}
		
		ois.close();
			}

	public void salvarEmprestimos() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("emprestimos.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Emprestimo emprestimo : emprestimos.values()) {
			try {
				oos.writeObject(emprestimo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
