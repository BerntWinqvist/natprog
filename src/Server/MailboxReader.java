package Server;

import java.io.*;
import java.util.*;

public class MailboxReader extends Thread {
	private Mailbox box;
	private Vector<User> users;
	private OutputStream out;
	private boolean isAlive;

	public MailboxReader(Vector<User> users, Mailbox box) {
		this.users = users;
		this.box = box;
		isAlive = true;
	}

	public void run() {
		String s;
		while (isAlive) {
			s = box.getContent() + "\n";
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

	public void kill() {
		isAlive = false;
	}
}
