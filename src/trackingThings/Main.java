package trackingThings;

import easyaccept.EasyAccept;

public class Main {
	public static void main(String[] args) throws Exception {
		
//			Facade facade = new Facade();
//			facade.iniciarSistema();
//			facade.cadastrarUsuario(nome, telefone, email);
//		
//		
			args = new String[] {"trackingThings.Facade", "us/us1_test.txt", "us/us2_test.txt", "us/us3_test.txt", "us/us4_test.txt"};
			
			EasyAccept.main(args);
	}
}
