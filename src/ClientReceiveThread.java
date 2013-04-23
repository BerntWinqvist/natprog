import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class ClientReceiveThread extends Thread {
	private Socket socket;
	private BufferedReader in;	
	public ClientReceiveThread(String name ,Socket socket){
		super(name);		
		this.socket = socket;
		
	}
	
	
	public void run(){
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			while (true) {

				String s;
				while ((s = in.readLine()) != null) {					
					System.out.println(s);
				}
			}

		} catch (IOException e) {

		}
		
	}

}
