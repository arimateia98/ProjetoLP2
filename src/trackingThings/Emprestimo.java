package trackingThings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Jose de Arimateia
 *
 */

public class Emprestimo {
	private Usuario usuarioDono;
	private Usuario usuarioEmprestimo;
	private Item item;
	private int diasEmprestimo;
	private int diasAtrasado;
	private DateTimeFormatter fmt;
	private LocalDate dataInicial;
	private LocalDate dataDevolucao;
	
	public Emprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		this.usuarioDono = usuarioDono;
		this.usuarioDono.addReputacao(item.getValor() * 0.10);
		this.usuarioEmprestimo = usuarioEmprestimo;
		if (this.usuarioEmprestimo.getCartao().equals("Caloteiro")){
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}
		this.item = item;
		this.item.setEstadoEmprestimo(true); 
		this.fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dataInicial, fmt);
		this.dataInicial = date;
		this.diasEmprestimo = diasEmprestimo;
		
	}
	
	/**
	 * o metodo vai realizar a devolucao do item 
	 * @param dataDev
	 */
	public void devolverItem(String dataDev){
		LocalDate data = LocalDate.parse(dataDev, fmt);
		this.dataDevolucao = data;
		int diasPassados = (int) ChronoUnit.DAYS.between(dataInicial, dataDevolucao);
		this.diasAtrasado = diasPassados - diasEmprestimo;
		this.calculaReputacao();
		this.item.setEstadoEmprestimo(false);
	}
	
	public boolean getEstadoItem(){
		return this.item.getEstadoEmprestimo();
	}
	
	public Usuario getUsuarioDono(){
		return this.usuarioDono;
	}
	
	public int getDiasEmprestimo(){
		return this.diasEmprestimo;
	}
	
	public Usuario getUsarioEmprestimo(){
		return this.usuarioEmprestimo;
	}
	
	public Item getItem(){
		return this.item;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((usuarioDono == null) ? 0 : usuarioDono.hashCode());
		result = prime * result + ((usuarioEmprestimo == null) ? 0 : usuarioEmprestimo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (usuarioDono == null) {
			if (other.usuarioDono != null)
				return false;
		} else if (!usuarioDono.equals(other.usuarioDono))
			return false;
		if (usuarioEmprestimo == null) {
			if (other.usuarioEmprestimo != null)
				return false;
		} else if (!usuarioEmprestimo.equals(other.usuarioEmprestimo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		if (this.item.getEstadoEmprestimo()) {
			return "EMPRESTIMO - De: " + this.usuarioDono.toString() + ", Para: " + this.usuarioEmprestimo.toString() + ", " + this.item.toString() + ", " +  this.dataInicial + ", " + this.diasEmprestimo + ", ENTREGA: " + this.dataDevolucao;
		}
		return "EMPRESTIMO - De: " + this.usuarioDono.toString() + ", Para: " + this.usuarioEmprestimo.toString() + ", " + this.item.toString() + ", " +  this.dataInicial + ", " + this.diasEmprestimo + ", ENTREGA: Emprestimo em andamento";
	}
	public int getDiasAtrasado() {
		return this.diasAtrasado;
	}

	/** 
	 * Muda a quantidade de dias de atraso e altera a reputacao do usuario emprestimo
	 * @param diasAtraso
	 */
	public void calculaReputacao() {
		if (diasAtrasado > 0) {
			this.usuarioEmprestimo.removeReputacao(1000);//se o usuario entregou o item com atraso, a reputacao a ser adicionada vai ser negativa
		}else {
			this.usuarioEmprestimo.addReputacao(item.getValor()*0.05);
		}
		
	}
	
	
	
	
	

}
