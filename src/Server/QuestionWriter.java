package Server;

public class QuestionWriter extends Thread {
	private QuestionMailbox qbox;
	private Question quest;

	public QuestionWriter(QuestionMailbox qbox, Question quest) {
		this.qbox = qbox;
		this.quest = quest;
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
				int temp = i+1;
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
			qbox.setContent("VINNAREN ÄR ...... vi får fixa detta sen, poäng, namn osv");
			qbox.setContent("NÄSTA RUNDA BÖRJAR OM 5S");
		}
	}
}
