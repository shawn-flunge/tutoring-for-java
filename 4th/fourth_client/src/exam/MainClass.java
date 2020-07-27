package exam;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket sock = new Socket("127.0.0.1",9999); //localhost == 127.0.0.1
			System.out.println("server¿Í ¿¬°áµÊ");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
