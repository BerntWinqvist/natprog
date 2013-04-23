import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;


public class UserThread extends Thread {
	private Socket socket;
	private Vector<User> users;
	private PrintWriter out;
	private BufferedReader in;

	
	public UserThread(Socket socket, Vector<User> users ){		
		this.socket = socket;
		this.users = users;
	}
	
	
	public void run(){
		try{
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));	
		String userName = in.readLine();
		User user = new User(userName, socket);
		users.add(user);
		while(true){
			
		}
		
		}catch(IOException e){			
			e.printStackTrace();
		}
		
	}
	
	
	
}
