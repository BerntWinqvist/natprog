package GUI;

import java.awt.BorderLayout;

import javax.swing.*;


public class GUI {
private JTabbedPane tabbedPane;
	public GUI() {
		//fönstret
		JFrame frame = new JFrame();
		tabbedPane = new JTabbedPane();
		
		//Tabbarna
		StartPane sf = new StartPane();		
		tabbedPane.addTab("Startpane", sf);
		ServerPane sp = new ServerPane();
		tabbedPane.addTab("Serverpane",sp);
		GamePane gp = new GamePane();
		tabbedPane.addTab("GamePane", gp);
		tabbedPane.setSelectedIndex(0);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		frame.setSize(500, 400);
		frame.setVisible(true);
		
		
		
	}

	public static void main(String args[]) {
		GUI gui = new GUI();
	}
}
