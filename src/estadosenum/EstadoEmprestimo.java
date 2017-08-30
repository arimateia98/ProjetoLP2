package estadosenum;

public enum EstadoEmprestimo {
	EMPRESTADO("Emprestado"),NEMPRESTADO("Nao emprestado");
	
	private final String mensagem;
	
	private EstadoEmprestimo(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem(){
		return this.mensagem;
	}

}
