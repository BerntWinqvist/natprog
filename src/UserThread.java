import java.net.*;


public class UserThread extends Thread {
	private Socket socket;

	
	public UserThread(Socket socket){		
		this.socket = socket;
	}
	
	
	public void run(){
		
	}
}
