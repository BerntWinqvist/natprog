package Server;

import java.util.*;

public class QuestionWriter extends Thread {
	private QuestionMailbox qbox;
	private Question quest;
	private Vector<User> users;

	public QuestionWriter(QuestionMailbox qbox, Question quest,
			Vector<User> users) {
		this.qbox = qbox;
		this.quest = quest;
		this.users = users;
	}

	public void run() {

		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			qbox.setContent("NY RUNDA");
			for (int i = 0; i < 5; i++) {
				int temp = i + 1;
				String q = "FRÅGA " + temp + ": ";
				q += quest.getQuestion();
				qbox.setContent(q);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				String a = "RÄTT SVAR: ";
				a += quest.getAnswer();
				qbox.setContent(a);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			qbox.setContent("RUNDAN ÄR AVSLUTAD");
			qbox.setContent("RESULTAT:");
			int hPoints = 0;
			String hPointsResult="";
			//här preseneteras alla resultat dessutom kollas vem som har högst poäng...
			for (int i = 0; i < users.size(); i++) {	
				User u = users.get(i);
				int points = u.getPoints();
				String p = Integer.toString(points);
				p+="P";
				String result = u.getName();
				result+=": ";
				result+=p;
				qbox.setContent(result);
				if(points>hPoints){
					hPoints = points;
					hPointsResult = u.getName();
					hPointsResult+= " med ";
					hPointsResult+= p;
				}
			}
			qbox.setContent("VINNAREN ÄR: " + hPointsResult);
			qbox.setContent("NÄSTA RUNDA BÖRJAR OM 20S");

		}
	}
}