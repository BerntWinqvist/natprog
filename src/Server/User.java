package Server;

import java.net.*;

public class User {
	private String userName;
	private Socket socket;
	private int points;
	private boolean hasAnswered;
	private int id;
	private boolean betweenRounds;

	public User(String name, Socket socket, int id) {
		userName = name;
		this.socket = socket;
		this.id=id;
		resetPoints();
		hasAnswered = false;
		betweenRounds = true;
	}

	public String getName() {
		return userName;
	}
	public int getId(){
		return id;
	}

	public Socket getSocket() {
		return socket;
	}

	public void addPoints(int newPoint) {
		if (!hasAnswered) {
			points += newPoint;
			hasAnswered = true;
		}
	}

	public int getPoints() {
		return points;
	}

	public void resetPoints() {
		points = 0;
	}

	public boolean hasAnswered() {
		return hasAnswered;
	}

	public void setHasAnsweredToFalse() {
		hasAnswered = false;
	}
	public boolean isBetweenRounds() {
		return betweenRounds;
	}
	public void setBetweenRounds(boolean b) {
		betweenRounds = b;
	}
}
