package trackingThings;

import java.io.File;
import java.util.ArrayList;
import easyaccept.EasyAccept;


public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> testes = new ArrayList<>();
		testes.add("us" + File.separator + "us1_test.txt");
		testes.add("us" + File.separator + "us2_test.txt");
		testes.add("us" + File.separator + "us3_test.txt");
		testes.add("us" + File.separator + "us4_test.txt");
		EasyAccept.executeEasyAcceptTests("trackingThings.Facade", testes);
	}
}
