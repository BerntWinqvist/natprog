package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread {
	private ServerSocket serverSocket;
	private int id;

	public Server() {
		id = 0;
		try {
			serverSocket = new ServerSocket(31337);
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
			while (true) {
				Socket clientSocket = serverSocket.accept();
				UserThread user = new UserThread(clientSocket, users, box,
						quest, id);
				id++;
				user.start();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
