package trackingThings;

<<<<<<< HEAD
import java.util.ArrayList;

=======
import java.io.File;
import java.util.ArrayList;
>>>>>>> cf6a0b1b9538197c5b69ec106d0db170d98fd6e6
import easyaccept.EasyAccept;


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
