package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Client.Client;
import GUI.StartPane.ServerSelectionListener;

public class GamePane extends JPanel {
	private JViewport pane;
	public static JTextArea chatText = null;
	public static JTextArea questionText = null;
	public static JTextField chatLine = null;
	private JList userList;
	private DefaultListModel userListModel;
	private String chatLineText;
	
	public GamePane() {
		
		chatLineText="";
		
		setLayout(new BorderLayout());
		JPanel chatPane = new JPanel(new BorderLayout());
		chatText = new JTextArea(20, 50);
		chatText.setLineWrap(true);
		chatText.setEditable(false);
		chatText.setForeground(Color.blue);
		JScrollPane chatTextPane = new JScrollPane(chatText,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatLine = new JTextField();
		chatLine.setEnabled(true);
		chatLine.addActionListener(new ActionHandler());
		chatPane.add(chatLine, BorderLayout.SOUTH);
		chatPane.add(chatTextPane, BorderLayout.CENTER);
		chatPane.setPreferredSize(new Dimension(530, 430));
		JPanel westPanel = new JPanel();
		
		westPanel.add(chatPane,BorderLayout.WEST);	
		add(westPanel,BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		JPanel eastNorthPanel = new JPanel();
		
		JLabel label = new JLabel("Connected users");
		eastPanel.setLayout(new GridLayout(3,0));
		eastNorthPanel.add(label);		
		JComponent list = createUserList();		
		eastNorthPanel.add(list);		
		
		eastPanel.add(eastNorthPanel);
		JLabel yourName = new JLabel("Your user name: ");
		JLabel yourScore = new JLabel("Your score: ");
		eastPanel.add(yourName);
		eastPanel.add(yourScore);
		add(eastPanel);
		getUser();
		
		

	}
	
	
	// Skapar listan som ska fyllas med users 
	public JComponent createUserList() {
		userListModel = new DefaultListModel();
		userList = new JList(userListModel);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setPrototypeCellValue("123456789012");
		
		JScrollPane scrollPane = new JScrollPane(userList);
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		return panel;
	}
	
	//Metod för att fylla listan med inloggade users
	public void getUser(){
		for (int i = 0; i < 10; i++) {
			userListModel.addElement("User " + i);
		}
	}
	
	public void setChatText(String s){
		chatText.append(s + "\n");
		chatText.setCaretPosition(chatText.getText().length());
		
		
	}
	public String scanNextLine(){
		if(chatLineText.isEmpty()){
			return "§§§§§§§§§§";				
			
		}else{
			String temp = chatLineText;
			chatLineText="";
			return temp;
		}
	}
	
	
	
	class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			chatLineText = chatLine.getText();
			chatLine.setText("");
		}

	}
	
	

}