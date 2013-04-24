package GUI;
import javax.swing.*;

public class GUI {
	
	
	public GUI(){
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.setVisible(true);
		StartFrame sf = new StartFrame();
		frame.add(sf);
	}
	
	
	public static void main(String args[]){
		
		GUI gui = new GUI();
		
		
	}

}
