package GUI;

import java.awt.*;

import javax.swing.*;

import GUI.StartPane.ServerSelectionListener;

public class GamePane extends JPanel {
	private JViewport pane;
	public static JTextArea chatText = null;
	public static JTextArea questionText = null;
	public static JTextField chatLine = null;
	private JList userList;
	private DefaultListModel userListModel;

	public GamePane() {
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
		chatPane.add(chatLine, BorderLayout.SOUTH);
		chatPane.add(chatTextPane, BorderLayout.CENTER);
		chatPane.setPreferredSize(new Dimension(530, 430));
		add(chatPane,BorderLayout.WEST);
		
		JComponent list = createUserList();
		add(list,BorderLayout.EAST);
			
			
		

	}
	
	
	
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
	
	
	

}