package trackingThings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Jose de Arimateia, Katson Matheus
 *
 */
public class Emprestimo {
	private Usuario usuarioDono;
	private Usuario usuarioEmprestimo;
	private Item item;
	private int diasEmprestimo;
	private int diasAtraso;
	private DateTimeFormatter fmt;
	private LocalDate dataInicial;
	private LocalDate dataDevolucao;
	
	public Emprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		this.usuarioDono = usuarioDono;
		this.usuarioEmprestimo = usuarioEmprestimo;
		this.item = item;
		this.item.setEstadoEmprestimo(true); 
		this.fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dataInicial, fmt);
		this.dataInicial = date;
		this.diasEmprestimo = diasEmprestimo;
	}
	
	public void devolverItem(String dataDev){
		LocalDate data = LocalDate.parse(dataDev, fmt);
		this.dataDevolucao = data;
		int diasPassados = (int) ChronoUnit.DAYS.between(dataInicial, dataDevolucao);
		this.diasAtraso = diasPassados - diasEmprestimo;
		this.item.setEstadoEmprestimo(false);
	}
	
	public boolean getEstadoItem(){
		return item.getEstadoEmprestimo();
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
	
	
	
	
	

}
