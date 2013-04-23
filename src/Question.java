import java.util.*;


public class Question {
	private ArrayList<String> quest;
	private ArrayList<String> answer;
	private int lastIndex;
	
	public Question(){
	quest = new ArrayList<String>();
	answer = new ArrayList<String>();
	fillQuestion();
	fillAnswer();
	}

	public String getQuestion(){
		int a =quest.size();
		Random rand = new Random();
		lastIndex = rand.nextInt(a);
		return quest.get(lastIndex);
	}
	
	public String getAnswer(){
		return answer.get(lastIndex);
	}
	
	private void fillQuestion(){
		quest.add("Hur många fingrar har en människa?");
		quest.add("Vad heter Bart Simpsons pappa i förnamn?");
		quest.add("Hur många protoner har en väteatom?");
		quest.add("Vad heter Sveriges fjärde största stad?");
		
	}
	private void fillAnswer(){
		answer.add("10");
		answer.add("Homer");
		answer.add("1");
		answer.add("Uppsala");
	}
}
