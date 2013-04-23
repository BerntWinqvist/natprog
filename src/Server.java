import java.io.IOException;
import java.net.*;
import java.util.*;


public class Server {
	
	public static void main(String args[]){
		
		Vector<User> users = new Vector<User>();
		Mailbox box = new Mailbox();
		MailboxReader reader = new MailboxReader(users,box);
		reader.start();
		try {
			ServerSocket serverSocket = new ServerSocket(30000);
			
			while(true){				
				Socket clientSocket = serverSocket.accept();
				UserThread user = new UserThread(clientSocket, users,box);
				user.start();				
			}
			
		} catch (IOException e) {
			

			e.printStackTrace();
		}
		
	}
	
	

}
