package Server;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
	
	public static void main(String args[]){
		
		Vector<User> users = new Vector<User>();
		Mailbox box = new Mailbox();
		MailboxReader mReader = new MailboxReader(users,box);
		QuestionMailbox qBox = new QuestionMailbox();
		Question quest = new Question();
		QuestionWriter qWrite = new QuestionWriter(qBox, quest, users);
		QuestionReader qReader = new QuestionReader(users, qBox);
		mReader.start();
		qWrite.start();
		qReader.start();
		try {
			ServerSocket serverSocket = new ServerSocket(30000);
			
			while(true){				
				Socket clientSocket = serverSocket.accept();
				UserThread user = new UserThread(clientSocket, users,box, quest);
				user.start();				
			}
			
		} catch (IOException e) {
			

			e.printStackTrace();
		}
		
	}
	
	

}
