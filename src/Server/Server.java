package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread {
	private ServerSocket serverSocket;
	private int id;
	private String serverName;
	
	public Server(String serverName) {
		
		id = 0;
		try {
			serverSocket = new ServerSocket(31337);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.serverName = serverName;
	}

	public void run() {
		
		MulticastThread MT = new MulticastThread(serverName);
		
		

		Vector<User> users = new Vector<User>();
		Mailbox box = new Mailbox();
		MailboxReader mReader = new MailboxReader(users, box);
		QuestionMailbox qBox = new QuestionMailbox();
		Question quest = new Question();
		QuestionWriter qWrite = new QuestionWriter(qBox, quest, users);
		QuestionReader qReader = new QuestionReader(users, qBox);
		MT.start();
		mReader.start();
		qWrite.start();
		qReader.start();
		try {
			boolean firstUser = true;
			boolean serverRunning = true;
			while (serverRunning) {
				Socket clientSocket = serverSocket.accept();
				UserThread user = new UserThread(clientSocket, users, box,
						quest, id);
				id++;
				user.start();
				System.out.println(users.isEmpty());
				if(users.isEmpty() && !firstUser){
					serverRunning=false;
				}
				firstUser=false;
			}
			

		} catch (IOException e) {
			MT.kill();
			mReader.kill();
			qWrite.kill();
			qReader.kill();
		}

	}
	
	public void stopServer(){
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
