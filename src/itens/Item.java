package itens;

import java.io.Serializable;
import java.util.ArrayList;

import estadosenum.EstadoEmprestimo;
import trackingThings.Emprestimo;

/**
 * @author Jose Ramon
 *
 */
public abstract class Item implements Serializable{
	
	
	protected String nome;
	protected double valor;
	protected EstadoEmprestimo estadoEmprestimo;
	protected ArrayList <Emprestimo> emprestimosOcorridos;
	protected String donoItem;


	/**
	 * Cada item tem um nome e um valor
	 * @param nome
	 * @param valor
	 */
	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.estadoEmprestimo = EstadoEmprestimo.NEMPRESTADO;
		emprestimosOcorridos = new ArrayList<>();
	}

	/**
	 * @return nome do item
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return estado do item
	 */
	
	public void setEstadoEmprestimo(boolean estado){
		if(estado){
			this.estadoEmprestimo = EstadoEmprestimo.EMPRESTADO;
		}else{
			this.estadoEmprestimo = EstadoEmprestimo.NEMPRESTADO;
		}
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return valor do item
	 */
	public double getValor() {
		return this.valor;
	}
	
	/** 
	 * Diz se o item esta emprestado ou nao
	 * @return
	 */
	public String getEmprestado(){
		return this.estadoEmprestimo.getMensagem();
	
	}

	/**
	 * Adquire os emprestimos feitos desse item
	 * @return lista de todos os emprestimos daquele item
	 */
	public ArrayList<Emprestimo> getEmprestimosOcorridos() {
		return emprestimosOcorridos;
	}

	/**
	 * @return nome do dono do item
	 */
	public String getDonoItem() {
		return donoItem;
	}

	public void setDonoItem(String donoItem) {
		this.donoItem = donoItem;
	}

}
