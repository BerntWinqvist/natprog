import java.net.*;


public class User {
	private String userName;
	private Socket socket;
	
	public User(String name, Socket socket){
		userName = name;
		this.socket=socket;
	}
	
	public String getName(){
		return userName;
	}
	
	public Socket getSocket(){
		return socket;
	}

}
