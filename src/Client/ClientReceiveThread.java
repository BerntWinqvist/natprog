package Client;

import java.io.*;
import java.net.*;

import javax.swing.JPanel;

import GUI.GamePane;


public class ClientReceiveThread extends Thread {
	private Socket socket;
	private BufferedReader in;	
	private GamePane gp;
	public ClientReceiveThread(String name ,Socket socket,JPanel gp){
		super(name);		
		this.socket = socket;
		this.gp= (GamePane)gp;
	}
	
	
	public void run(){
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			while (true) {

				String s;
				while ((s = in.readLine()) != null) {	
					if(s.startsWith("&&&&&")){
						gp.setPoints(s.substring(5));
					}else if(s.startsWith("%%%%%%")){
						gp.setUser(s.substring(6));
					}else if(s.startsWith("hostquit")){
						gp.quit();
					}else if(s.startsWith("¤dropped")){
						gp.removeUser(s.substring(8));
					}else{
						gp.setChatText(s);
					}
				}
			}

		} catch (IOException e) {

		}
		
	}

}
