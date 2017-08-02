package trackingThings;


public class Facade {
	
	Sistema sistema;
	
	public void iniciarSistema() {
		this.sistema = new Sistema();
	}
	
	public void cadastrarUsuario(String nome,String telefone, String email){
		this.sistema.cadastrarUsuario(nome, telefone, email);
	}
	
	public void removerUsuario(String nome, String telefone){
		this.sistema.removerUsuario(nome, telefone);
	}
	
	public void atualizarUsuario(String nome,String telefone, String atributo, String valor){
		this.sistema.atualizarUsuario(nome, telefone, atributo, valor);
	}

}