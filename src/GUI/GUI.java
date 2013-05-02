package GUI;

import java.awt.BorderLayout;

import javax.swing.*;


public class GUI {
private JTabbedPane tabbedPane;
	public GUI() {
		JFrame frame = new JFrame();
		
		//Tabbarna
		tabbedPane = new JTabbedPane();
		
		StartPane sf = new StartPane(tabbedPane, frame);	
		tabbedPane.addTab("Startpane", sf);
		
		ServerPane sp = new ServerPane(tabbedPane,frame);
		tabbedPane.addTab("Serverpane",sp);
		
		GamePane gp = new GamePane(tabbedPane,frame);
		tabbedPane.addTab("GamePane", gp);
		
		tabbedPane.setSelectedIndex(0);
		tabbedPane.setEnabledAt(2,false);

		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

	public static void main(String args[]) {
		GUI gui = new GUI();
	}
}
