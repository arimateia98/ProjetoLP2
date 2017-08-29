package trackingThings;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import itens.Item;

/**
 * @author Jose de Arimateia
 *
 */

public class Emprestimo implements Serializable {
	private Usuario usuarioDono;
	private Usuario usuarioEmprestimo;
	private Item item;
	private int diasEmprestimo;
	private int diasAtrasados;
	private boolean emprestimoFinalizado; // variavel que mostra se o emprestimo já foi finalizado ou não
	private String dataInicial;
	private String dataDevolucao;
	
	public Emprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		this.usuarioDono = usuarioDono;
		this.usuarioDono.addReputacao(item.getValor() * 0.10);
		this.usuarioEmprestimo = usuarioEmprestimo;
		this.emprestimoFinalizado = false;
		this.item = item;
		this.item.setEstadoEmprestimo(true); ;
		this.dataInicial = dataInicial;
		this.dataDevolucao = "Emprestimo em andamento";
		this.diasEmprestimo = diasEmprestimo;
		
	}
	
	/**
	 * o metodo vai realizar a devolucao do item 
	 * @param dataDev
	 */
	public void devolverItem(String dataDev){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/M/yyyy");
		LocalDate dateIni = LocalDate.parse(this.dataInicial, fmt);
		LocalDate dataDev1 = LocalDate.parse(dataDev, fmt);
		int diasPassados = (int) ChronoUnit.DAYS.between(dateIni, dataDev1);
		this.diasAtrasados = diasPassados - diasEmprestimo;
		this.calculaReputacao(this.diasAtrasados);
		this.item.setEstadoEmprestimo(false);
		this.dataDevolucao = dataDev;
	}
	
	public String getDataDevolucao() {
		return dataDevolucao;
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
		if (this.emprestimoFinalizado) {
			return "EMPRESTIMO - De: " + this.usuarioDono.getNome() + ", Para: " + this.usuarioEmprestimo.getNome() + ", " + this.item.getNome() + ", " +  this.dataInicial + ", " + this.diasEmprestimo + " dias, ENTREGA: " + this.dataDevolucao;
		}
		return "EMPRESTIMO - De: " + this.usuarioDono.getNome() + ", Para: " + this.usuarioEmprestimo.getNome() + ", " + this.item.getNome() + ", " +  this.dataInicial + ", " + this.diasEmprestimo + " dias, ENTREGA: Emprestimo em andamento";
	}
	public int getDiasAtrasado() {
		return this.diasAtrasados;
	}

	/** 
	 * Muda a quantidade de dias de atraso e altera a reputacao do usuario emprestimo
	 * @param diasAtraso
	 */
	public void calculaReputacao(int diasAtrasados) {
		if (diasAtrasados > 0) {
			this.usuarioEmprestimo.removeReputacao(this.item.getValor() * diasAtrasados * 0.01);//se o usuario entregou o item com atraso, a reputacao a ser adicionada vai ser negativa
		}else if(diasAtrasados <= 0){
			this.usuarioEmprestimo.addReputacao(item.getValor()*0.05);
		}
		
	}
	
	
	
	
	

}
