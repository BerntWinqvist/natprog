package Client;

import java.io.*;
import java.net.*;

import javax.swing.*;


public class Client {
	private Socket socket;
	private JPanel gp;

	public Client(String host, String userName,JPanel gp) {
		this.gp = gp;
		connect(host, userName);
	}

	public void connect(String host, String userName) {

		
		
		try {
			socket = new Socket(host, 31337);		
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
		ClientReceiveThread receive = new ClientReceiveThread("Receive-Thread",socket,gp);
		send.start();
		receive.start();
	
	}
	
//	public static void main(String args[]){
//		
//		new Client(args[0],args[1],args[2]);
//	}
//	
	

}
