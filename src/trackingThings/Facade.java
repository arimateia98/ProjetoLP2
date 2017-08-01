package trackingThings;


public class Facade {
	
	Sistema sistema;
	
	public void iniciarSistema() {
		sistema = new Sistema();
	}
	
	public void cadastrarUsuario(String nome,String telefone, String email){
		sistema.cadastrarUsuario(nome, telefone, email);
	}
	
	public void removerUsuario(String nome, String telefone){
		sistema.removerUsuario(nome, telefone);
	}
	
	public void atualizarUsuario(String nome,String telefone, String atributo, String email){
		sistema.atualizarUsuario(nome, telefone, atributo, email);
	}

}