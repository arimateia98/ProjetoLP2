package trackingThings;

import java.util.ArrayList;

import easyaccept.EasyAccept;
import easyaccept.EasyAcceptException;
public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> testes = new ArrayList<>();
		testes.add("us", "us1_test.txt");
		testes.add("us", "us2_test.txt");
		testes.add("us", "us3_test.txt");
		testes.add("us", "us4_test.txt");
		EasyAccept.executeEasyAcceptTests("trackingThings.Facade", testes);
	}
}
