package exam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("���� ������ ���");
			
			while(true) {
				Socket sock = serverSocket.accept();
				System.out.println("client ����, ip : " + sock.getInetAddress());
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	
	
}
