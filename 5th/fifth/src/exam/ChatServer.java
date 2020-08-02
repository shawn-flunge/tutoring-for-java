package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ChatServer {

	private ServerSocket serverSocket;
	private Socket socket;
	
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String name;
	
	
	public void createSocket() {
		
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("create server");
			
			System.out.print("이름을 입력하세요 : ");
			name= new BufferedReader(new InputStreamReader(System.in)).readLine();
			
			while(true) {
				socket = serverSocket.accept();
				
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
				
				System.out.println("연결");
				
				createReadThread();
				createWriteThread();			
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void createReadThread() {
		
		Thread readThread = new Thread(new Runnable() {		
			public void run() {
				while (socket.isConnected()) {
					try {
						byte[] readBuffer = new byte[200];
						int num = inputStream.read(readBuffer);
						
						if (num > 0) {
							byte[] arrayBytes = new byte[num];
							System.arraycopy(readBuffer, 0, arrayBytes, 0, num);
							String receivedMsg = new String(arrayBytes, "UTF-8");
							
							System.out.println(receivedMsg);
						} else {
							notify();
						}
						;

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		});
		
		readThread.setPriority(Thread.MAX_PRIORITY);
		readThread.start();
	}
	
	public void createWriteThread() {
		Thread writeThread = new Thread() {
			public void run() {

				while (socket.isConnected()) {
					try {
						BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
						sleep(100);					
						
						String typedMsg =   inputReader.readLine();
						
						if(typedMsg.equals("exit"))
							System.exit(0);
										
						typedMsg = name + " : " + typedMsg;
						
						
						if (typedMsg != null && typedMsg.length() > 0) {
							synchronized (socket) {
								outputStream.write(typedMsg.getBytes("UTF-8"));
								sleep(100);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		};
		writeThread.setPriority(Thread.MAX_PRIORITY);
		writeThread.start();

	}	
	
	
	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		chatServer.createSocket();
	}
	
	
}
