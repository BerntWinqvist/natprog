import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Socket socket;
	
	private PrintWriter out;
	private BufferedReader in;

	public Client(String host, String port) {

		connect(host, port);
	}

	public void connect(String host, String port) {

		
		int i = Integer.parseInt(port);
		try {
			socket = new Socket(host, i);		
			if (socket.isConnected()) {
				System.out.println("Connected to the server");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ClientSendThread send = new ClientSendThread("Send-thread",socket);
		ClientReceiveThread receive = new ClientReceiveThread("Receive-Thread",socket);
		send.start();
		receive.start();
	
	}
	
	

}
