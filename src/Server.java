import java.io.IOException;
import java.net.*;
import java.util.*;


public class Server {
	
	public static void main(String args[]){
		
		Vector<User> users = new Vector<User>();
		try {
			ServerSocket serverSocket = new ServerSocket(30000);
			
			while(true){				
				Socket clientSocket = serverSocket.accept();
				UserThread user = new UserThread(clientSocket);
				user.start();
				users.add(new User("namnish",clientSocket));
				
			}
			
			
			
		} catch (IOException e) {
			

			e.printStackTrace();
		}
		
	}
	
	

}
