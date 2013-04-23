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
	private Mailbox box;
	
	public UserThread(Socket socket, Vector<User> users, Mailbox box ){		
		this.socket = socket;
		this.users = users;
		this.box =box;
	}
	
	
	public void run(){
		try{
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		
		//Ta hand om användarnamn
		String userName = in.readLine();
		User user = new User(userName, socket);
		users.add(user);
		System.out.println(userName);
		
		//skicka meddelande
		while(true){
			String s;
			while ((s = in.readLine()) != null) {

				System.out.println(s + " |  Input på serversidan");
				if ((s.startsWith("Q"))) {
					System.out.println("Connection close by client command");
					break;

				} else if (s.startsWith("E")) {
					out.println(s.substring(2));
					out.flush();
				} else if (s.startsWith("M")) {
					box.setContent(s.substring(2));

				}
			}
			
			
			
		}
		
		}catch(IOException e){			
			e.printStackTrace();
		}
		
	}
	
	
	
}
