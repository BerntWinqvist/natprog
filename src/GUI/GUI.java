package GUI;

import java.awt.BorderLayout;

import javax.swing.*;


public class GUI {
private JTabbedPane tabbedPane;
	public GUI() {
		JFrame frame = new JFrame();
		
		//Tabbarna
		tabbedPane = new JTabbedPane();
//		
		StartPane sf = new StartPane();	
		tabbedPane.addTab("Startpane", sf);
		
		ServerPane sp = new ServerPane();
		tabbedPane.addTab("Serverpane",sp);
		
		GamePane gp = new GamePane();
		tabbedPane.addTab("GamePane", gp);
		
		tabbedPane.setSelectedIndex(0);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		
	}

	public static void main(String args[]) {
		GUI gui = new GUI();
	}
}
