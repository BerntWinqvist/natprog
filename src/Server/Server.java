package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread {
	private ServerSocket serverSocket;

	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void run() {

		Vector<User> users = new Vector<User>();
		Mailbox box = new Mailbox();
		MailboxReader mReader = new MailboxReader(users, box);
		QuestionMailbox qBox = new QuestionMailbox();
		Question quest = new Question();
		QuestionWriter qWrite = new QuestionWriter(qBox, quest, users);
		QuestionReader qReader = new QuestionReader(users, qBox);
		mReader.start();
		qWrite.start();
		qReader.start();
		try {
			System.out.println("Innan while(true) i server");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				UserThread user = new UserThread(clientSocket, users, box,
						quest);
				user.start();
				System.out.println("Inne i while(true) i server");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
