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
	private int id;

	public UserThread(Socket socket, Vector<User> users, Mailbox box,
			Question quest, int id) {
		this.socket = socket;
		this.users = users;
		this.box = box;
		this.quest = quest;
		this.id = id;
	}

	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// Ta hand om användarnamn
			String userName = in.readLine();
			user = new User(userName, socket, id);
			users.add(user);
			System.out.println(userName);
			boolean quit = false;
			// skicka meddelande
			while (!quit) {
				String s;
				while ((s = in.readLine()) != null) {

					if ((s.startsWith("quit"))) {
						for (int i = 0; i < users.size(); i++) {
							if (users.get(i).getId() == id) {
								users.remove(i);
								quit = true;
							}

						}

					} else if (s.startsWith("E ")) {
						out.println(s.substring(2));
						out.flush();
					} else if (s.startsWith("M ")) {
						box.setContent(s.substring(2));

					} else {
						if (quest.isCorrect(s)) {
							if (!user.hasAnswered()) {
								out.println("DU SVARADE RÄTT");
								user.addPoints(quest.getPoints());
								out.println("&&&&&" + user.getPoints());
								// System.out.println(user.getName() + " :" +
								// user.getPoints());
							} else {
								out.println("DU HAR REDAN SVARAT PÅ DENNA FRÅGAN");
							}

						}

					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
