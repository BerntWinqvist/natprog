package Client;

import java.io.*;
import java.net.*;


public class Client {
	private Socket socket;
	

	public Client(String host, String port, String userName) {

		connect(host, port, userName);
	}

	public void connect(String host, String port, String userName) {

		
		int i = Integer.parseInt(port);
		try {
			socket = new Socket(host, i);		
			if (socket.isConnected()) {
				System.out.println("Connected to the server");
				OutputStream out = socket.getOutputStream();
				String name = userName + "\n";					//ska komma som input från gui sen
				out.write(name.getBytes());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ClientSendThread send = new ClientSendThread("Send-thread",socket);
		ClientReceiveThread receive = new ClientReceiveThread("Receive-Thread",socket);
		send.start();
		receive.start();
	
	}
	
	public static void main(String args[]){
		
		new Client(args[0],args[1],args[2]);
	}
	
	

}
