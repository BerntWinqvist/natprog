package Server;

import java.io.*;
import java.net.*;
import java.util.*;


public class UserThread extends Thread {
	private Socket socket;
	private Vector<User> users;
	private PrintWriter out;
	private BufferedReader in;
	private Mailbox box;
	private Question quest;
	private User user;
	
	public UserThread(Socket socket, Vector<User> users, Mailbox box, Question quest ){		
		this.socket = socket;
		this.users = users;
		this.box =box;
		this.quest=quest;
	}
	
	
	public void run(){
		try{
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		
		//Ta hand om användarnamn
		String userName = in.readLine();
		user = new User(userName, socket);
		users.add(user);
		System.out.println(userName);
		
		//skicka meddelande
		while(true){
			String s;
			while ((s = in.readLine()) != null) {

//				System.out.println(s + " |  Input på serversidan");
				if ((s.startsWith("quit"))) {							//OBS detta fungerar inte riktigt som det ska......
					System.out.println("Connection close by client command");
					break;

				} else if (s.startsWith("E ")) {
					out.println(s.substring(2));
					out.flush();
				} else if (s.startsWith("M ")) {
					box.setContent(s.substring(2));

				}else{
					if(quest.isCorrect(s)){
						if(!user.hasAnswered()){
							out.println("DU SVARADE RÄTT");						
							user.addPoints(quest.getPoints());
//							System.out.println(user.getName() + " :" + user.getPoints());
						}else{
							out.println("DU HAR REDAN SVARAT PÅ DENNA FRÅGAN");
						}
						
					}
					
				}
			}
			
			
			
		}
		
		}catch(IOException e){			
			e.printStackTrace();
		}
		
	}
	
	
	
}
