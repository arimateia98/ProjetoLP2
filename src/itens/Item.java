package itens;

import java.io.Serializable;
import java.util.ArrayList;

import trackingThings.Emprestimo;

/**
 * @author Jose Ramon
 *
 */
public abstract class Item implements Serializable{
	
	
	protected String nome;
	protected double valor;
	protected boolean estadoEmprestimo;
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
		this.estadoEmprestimo = false;
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
	public boolean getEstadoEmprestimo(){
		return this.estadoEmprestimo;
	}
	
	public void setEstadoEmprestimo(boolean estado){
		this.estadoEmprestimo = estado;
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
		if (!estadoEmprestimo){
			return "Nao emprestado";
		}
		else{
			return "Emprestado";
		}
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
