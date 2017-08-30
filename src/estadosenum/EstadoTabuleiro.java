package estadosenum;

public enum EstadoTabuleiro {
	COMPLETO("COMPLETO"),INCOMPLETO("COM PECAS PERDIDAS");
	
	private final String mensagem;
	
	private EstadoTabuleiro(String mensagem){
		this.mensagem = mensagem;
	}
	
	public String getMensagem(){
		return this.mensagem;
	}

}
