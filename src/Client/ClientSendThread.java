package Client;


import java.io.*;
import java.net.*;
import java.util.*;

public class ClientSendThread extends Thread {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Scanner scan;
	
	public ClientSendThread(String name,Socket socket) {
		super(name);
		this.socket= socket;
		scan = new Scanner(System.in);
		
	}
	
	public void run(){
		
		try{			
			out = new PrintWriter(socket.getOutputStream(), true);
		}catch(IOException e1){
			e1.printStackTrace();
		}
		
		while(true){
			String str = scan.nextLine();
//			System.out.println("Your input: " + str);

			try {
				if (!out.checkError()) {
					out.println(str);
					out.flush();
				}else{
				System.out.println("Connection closed");
				break;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

}
