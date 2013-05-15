package Server;

import java.io.*;
import java.util.*;

public class QuestionReader extends Thread {
	private QuestionMailbox qBox;
	private Vector<User> users;
	private OutputStream out;
	private boolean isAlive;

	public QuestionReader(Vector<User> users, QuestionMailbox qBox) {
		this.users = users;
		this.qBox = qBox;
		isAlive = true;
	}

	public void run() {
		String s;
		while (isAlive) {
			s = qBox.getContent() + "\n";
			byte[] b = s.getBytes();
			try {
				for (int i = 0; i < users.size(); i++) {
					out = users.get(i).getSocket().getOutputStream();
					out.write(b);
					users.get(i).setHasAnsweredToFalse();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void kill() {
		isAlive = false;
	}
}