package Server;

import java.util.*;

public class QuestionWriter extends Thread {
	private QuestionMailbox qbox;
	private Question quest;
	private Vector<User> users;
	private boolean isAlive;

	public QuestionWriter(QuestionMailbox qbox, Question quest,
			Vector<User> users) {
		this.qbox = qbox;
		this.quest = quest;
		this.users = users;
		isAlive = true;
	}

	public void run() {
		while (isAlive) {
			qbox.setContent("\n Nästa runda börjar om 20s");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			qbox.setContent("\n Nästa runda börjar om 5s");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			qbox.setContent("\n" + "Ny runda" + "\n");
			String ques = quest.getQuestion();
			for (int i = 0; i < 5; i++) {
				for (int e = 0; e < users.size(); e++) {
					users.get(e).setBetweenRounds(false);
				}
				int temp = i + 1;
				String q = "Fråga " + temp + ": ";
				q += ques;
				qbox.setContent(q);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				String a = "Rätt svar: ";
				a += quest.getAnswer();
				qbox.setContent(a);
				ques = quest.getQuestion();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			qbox.setContent("Rundan är avslutad");
			qbox.setContent("Resultat:");
			int hPoints = 0;
			String hPointsResult = "";
			// här preseneteras alla resultat dessutom kollas vem som har högst
			// poäng...
			for (int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				int points = u.getPoints();
				String p = Integer.toString(points);
				p += "P";
				String result = u.getName();
				result += ": ";
				result += p;
				qbox.setContent(result);
				if (points > hPoints) {
					hPoints = points;
					hPointsResult = u.getName();
					hPointsResult += " med ";
					hPointsResult += p;
				}
			}
			for (int i = 0; i < users.size(); i++) {
				users.get(i).resetPoints();
				users.get(i).setBetweenRounds(true);
			}
			qbox.setContent("VINNAREN ÄR: " + hPointsResult);
		}
	}

	public void kill() {
		isAlive = false;
	}
}
