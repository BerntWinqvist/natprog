package Server;

import java.io.*;
import java.util.*;

public class QuestionReader extends Thread {
	private QuestionMailbox qBox;
	private Vector<User> users;
	private OutputStream out;

	public QuestionReader(Vector<User> users, QuestionMailbox qBox) {
		this.users = users;
		this.qBox = qBox;

	}

	public void run() {

		String s;
		while (true) {
			s = qBox.getContent() + "\n";
			byte[] b = s.getBytes();
			try {
				for (int i = 0; i < users.size(); i++) {
					out = users.get(i).getSocket().getOutputStream();
					out.write(b);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}