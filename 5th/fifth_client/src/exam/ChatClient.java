package exam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {

	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	
	public void createSocket() {
		try {
			socket = new Socket("localHost", 9999);
			System.out.println("¿¬°á");
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			createReadThread();
			createWriteThread();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createReadThread() {
		Thread readThread = new Thread() {
			public void run() {
				while (socket.isConnected()) {
					try {
						byte[] readBuffer = new byte[200];
						int num = inputStream.read(readBuffer);

						if (num > 0) {
							byte[] arrayBytes = new byte[num];
							System.arraycopy(readBuffer, 0, arrayBytes, 0, num);
							String recvedMessage = new String(arrayBytes, "UTF-8");
							System.out.println("Received message :" + recvedMessage);
						}
					}catch (Exception e){
						e.printStackTrace();
					}

				}
			}
		};
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
						String typedMessage = inputReader.readLine();
						if (typedMessage != null && typedMessage.length() > 0) {
							synchronized (socket) {
								outputStream.write(typedMessage.getBytes("UTF-8"));
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
	
	
	public static void main(String[] args){
		
		ChatClient myChatClient = new ChatClient();
		myChatClient.createSocket();

	}

	
}
