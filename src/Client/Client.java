package Client;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {
	private Socket socket;
	private JPanel gp;

	public Client(String host, String userName, JPanel gp) {
		this.gp = gp;
		connect(host, userName);
	}

	public void connect(String host, String userName) {
		try {
			socket = new Socket(host, 31337);
			if (socket.isConnected()) {
				OutputStream out = socket.getOutputStream();
				String name = userName + "\n";
				out.write(name.getBytes());
				ClientSendThread send = new ClientSendThread("Send-thread",
						socket, gp);
				ClientReceiveThread receive = new ClientReceiveThread(
						"Receive-Thread", socket, gp);
				send.start();
				receive.start();
			}
		} catch (IOException e) {
			JOptionPane dialog = new JOptionPane();
			dialog.showMessageDialog(null, "The server is not longer running");
		}
	}
}
