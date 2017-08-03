package trackingThings;

public class Emprestimo {
	private Usuario usuarioDono;
	private Usuario usuarioEmprestimo;
	private Item item;
	private int diasEmprestimo;
	private String dataInicial;
	private String dataDevolucao;
	
	public Emprestimo(Usuario usuarioDono,Usuario usuarioEmprestimo,Item item,String dataInicial,int diasEmprestimo){
		this.usuarioDono = usuarioDono;
		this.usuarioEmprestimo = usuarioEmprestimo;
		this.item = item;
		this.item.alterarEstadoEmprestimo(true); 
		this.dataInicial = dataInicial;
		this.diasEmprestimo = diasEmprestimo;
	}
	
	public void devolverItem(){
		item.alterarEstadoEmprestimo(false);
	}
	
	public Usuario getUsuarioDono(){
		return this.usuarioDono;
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
