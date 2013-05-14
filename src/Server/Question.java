package Server;

import java.util.*;

public class Question {
	private ArrayList<String> quest;
	private ArrayList<String> answer;
	private int lastIndex;
	private long startTime;

	public Question() {
		quest = new ArrayList<String>();
		answer = new ArrayList<String>();
		fillQuestion();
		fillAnswer();
	}

	public String getQuestion() {
		int a = quest.size();
		Random rand = new Random();
		lastIndex = rand.nextInt(a);
		startTime = System.currentTimeMillis();
		return quest.get(lastIndex);
	}

	public String getAnswer() {
		return answer.get(lastIndex);
	}

	public boolean isCorrect(String a) {
		return getAnswer().equalsIgnoreCase(a);
	}

	public int getPoints() {
		long elapsed = System.currentTimeMillis() - startTime;
		return (int) (100 - elapsed / 100);
	}

	private void fillQuestion() {
		quest.add("Hur många fingrar har en människa?");
		quest.add("Vad heter Bart Simpsons pappa i förnamn?");
		quest.add("Hur många protoner har en väteatom?");
		quest.add("Vad heter Sveriges fjärde största stad?");
		quest.add("Vad har guld för kemisk beteckning?");
		quest.add("Vad heter Batmans sidekick?");
		quest.add("Vilken färg får man om man blandar gult och blått?");
		quest.add("Vad heter alla i Göteborg?");
		quest.add("Vad är 17+16?");
		quest.add("Vad heter prinsessan i Super Mario spelen?");
		quest.add("Vad heter Trollkarlen i Sagan om rignen filmerna?");
		quest.add("Hur många bokstäver finns det i alfabetet?");
		quest.add("Vad heter företaget som har utvecklat bland annat World of Warcraft?");
		quest.add("Vad heter Facebooks grundare?");
		quest.add("Vad är tredje roten av 27?");
		quest.add("Vilket år skönk Titanic?");
		quest.add("Vilken är kurskoden för Nätverksprogrammering?");
		quest.add("Vem är upphovsmannen till kärnan i Linux?");
		quest.add("Vad heter Sveriges högsta berg?");
		quest.add("Vid vilken temperatur (Celsius) är vatten som tyngst?");
		quest.add("Vad dricker kon?");
		quest.add("Vad heter huvudstaden i USA?");
		quest.add("Vilken är världens folkrikaste stad?");
		quest.add("Vem har regisserat Sagan om Ringen-trilogin?");
		quest.add("Vad nickade Sveriges genom tiderna mest berömda Counter-Strike-spelare?");
		quest.add("Vad är titeln på den låt som fått mest views på Youtube?");
		quest.add("Från vilket land kommer skaparna av Angry Birds?");
		quest.add("Vad heter Googles berömda hvuudkontor?");
		quest.add("Vilken knapp sitter längst ned i vänstra hörnet på ett QWERTY-tangentbord?");
		quest.add("Hur många Shift-tangenter finns det på ett QWERTY-tangentbord?");
		quest.add("I vilket programmeringsspråk är detta program skrivet?");
		quest.add("Förstår du apelsin?");
		quest.add("Hur många kanter har en hexagon?");
		quest.add("Vad heter Windows tablet-modell?");
		quest.add("Vad heter huvudstaden i Luxemburg?");
		quest.add("Översätt den finska frasen Ei saa peittää");
		quest.add("Vem gjorde låten Millennium 2?");
		quest.add("I hur många år kan en snigel sova?");
		quest.add("Vem utbrister BOOM när han lyckas lösa en matteuppgift?");
		quest.add("Hur många poäng är en civilingenjörsutbildning?");
		quest.add("Hur många kort finns det i en kortlek med 3 jokrar?");
		quest.add("Vad heter redskapet du lyfter i bänkpress?");
		quest.add("Vilket näringsämne är uppbyggt av aminosyror?");
		quest.add("I vilken stad skedde händelsen som utlöste Första Världskriget?");
		quest.add("I vilket land föddes Hitler?");
		quest.add("När, enligt USA startades Andra Världskriget?");
		quest.add("Vilket datum kröntes Gustav Vasa 1523? (YYMMDD)");
		quest.add("Vad hette typen av soldater som användes flitigt runt Carl XII:s tid?");
		quest.add("Ungefär hur många älgar skjuts det varje år i Sverige?");
		quest.add("Vilket år blev Skåne Svenskt?");
		quest.add("Vad blir sin(PI / 2)");
		quest.add("Var i Göteborg köper man fesk?");
		quest.add("Can you do it now?");
		quest.add("Can you do it on the examen?");
		quest.add("Vem har gjort hitlåten bajs i bastun?");
		quest.add("Vem har huvudrollen i Terminator filmerna?");
		quest.add("Vad heter den stora bergodalbanan i trä på Liseberg?");
		quest.add("Vilken gud står som staty högst up på avenyn i Göteborg?");
		quest.add("Vad kallas det när man klättrar utan rep, på lägre höjder (oftast stenblock)?");
		quest.add("Vem sjunger om splitternya blåa sockiplast?");
		quest.add("Vad heter den svenska motsvarigheten till Dvorak?");
		quest.add("Vem var programledare för Jeopardy?");
		quest.add("Vem drar Mot oändligheten och vidare!?");
		quest.add("Vem spelade huvudrollen i de första 8 säsongerna av Two and a half men?");
		quest.add("Vilken är huvudingrediensen i potatismos?");
		quest.add("Vad är 15 * 15?");
		quest.add("Hur många pappor finns det i C11?");
		quest.add("Svart eller vitt?");
		quest.add("Vilken datorsal i E-huset ligger mellan Hacke och Ravel?");
		quest.add("Fortsätt Anders Kjelléns uttryck: Kör upp den i [...] ");
		quest.add("Hur många prickar finns det på en tärning?");

	}

	private void fillAnswer() {
		answer.add("10");
		answer.add("Homer");
		answer.add("1");
		answer.add("Uppsala");
		answer.add("Au");
		answer.add("Robin");
		answer.add("Grönt");
		answer.add("Glenn");
		answer.add("33");
		answer.add("Peach");
		answer.add("Gandalf");
		answer.add("29");
		answer.add("Blizzard");
		answer.add("Mark Zuckerberg");
		answer.add("3");
		answer.add("1912");
		answer.add("EDA095");
		answer.add("Linus Torvalds");
		answer.add("Kebnekaise");
		answer.add("4");
		answer.add("Vatten");
		answer.add("Washington DC");
		answer.add("Tokyo");
		answer.add("Peter Jackson");
		answer.add("HeatoN");
		answer.add("Gangnam Style");
		answer.add("Finland");
		answer.add("GooglePlex");
		answer.add("Ctrl");
		answer.add("2");
		answer.add("Java");
		answer.add("Ja");
		answer.add("6");
		answer.add("Surface");
		answer.add("Luxemburg");
		answer.add("Får ej övertäckas");
		answer.add("Markoolio");
		answer.add("3");
		answer.add("Mergim");
		answer.add("300");
		answer.add("55");
		answer.add("Skivstång");
		answer.add("Protein");
		answer.add("Sarajevo");
		answer.add("Österrike");
		answer.add("1942");
		answer.add("230606");
		answer.add("Karoliner");
		answer.add("100000");
		answer.add("1658");
		answer.add("1");
		answer.add("Feskekyrkan");
		answer.add("no");
		answer.add("yes");
		answer.add("Tunnan och Moroten");
		answer.add("Arnold schwarzenegger");
		answer.add("Balder");
		answer.add("Poseidon");
		answer.add("bouldering");
		answer.add("Björn Rosenström");
		answer.add("svorak");
		answer.add("Magnus Härenstam");
		answer.add("buzz lightyear");
		answer.add("Charlie Sheen");
		answer.add("Potatis");
		answer.add("225");
		answer.add("3");
		answer.add("Svart");
		answer.add("Panter");
		answer.add("Exponenten");
		answer.add("21");
	}
}
