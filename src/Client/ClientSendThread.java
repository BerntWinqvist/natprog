package Client;


import java.io.*;
import java.net.*;
import java.util.*;

public class ClientSendThread extends Thread {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Scanner scan;
	private boolean quit;
	
	public ClientSendThread(String name,Socket socket) {
		super(name);
		this.socket= socket;
		scan = new Scanner(System.in);
		quit=false;
		
	}
	
	public void run(){
		
		try{			
			out = new PrintWriter(socket.getOutputStream(), true);
		}catch(IOException e1){
			e1.printStackTrace();
		}
		
		while(!quit){
			String str = scan.nextLine();
			
			

			try {
				if (!out.checkError()) {
					out.println(str);
					out.flush();
				}else{
				System.out.println("Connection closed");
				quit=true;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(str.compareTo("quit")==0){
				quit=true;
			}
			
		}
		
	}

}
