package Server;

import java.io.*;
import java.util.*;


public class MailboxReader extends Thread {
	private Mailbox box;
	private Vector<User> users;
	private OutputStream out;
	
	public MailboxReader(Vector<User> users,Mailbox box){
		this.users = users;
		this.box=box;
		
	}
	
	public void run(){
		
		String s; 
		while(true){
		s=box.getContent() +"\n";
		byte[] b = s.getBytes();
		try{
			for(int i=0;i<users.size();i++){
				out =users.get(i).getSocket().getOutputStream();
				out.write(b);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		
	}
	
	

	
	
	

}
