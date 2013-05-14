package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GamePane extends JPanel {
	public static JTextArea chatText = null;
	public static JTextArea questionText = null;
	public static JTextField chatLine = null;
	private JList userList;
	private DefaultListModel userListModel;
	private String chatLineText;
	private JLabel yourName;
	private JLabel yourScore;
	private JTabbedPane tabbedPane;
	private boolean host;
	private JFrame frame;

	public GamePane(JTabbedPane tabbedPane, JFrame frame) {
		this.frame = frame;
		host = false;
		chatLineText = "";
		this.tabbedPane = tabbedPane;
		setLayout(new BorderLayout());
		JPanel chatPane = new JPanel(new BorderLayout());
		chatText = new JTextArea(20, 50);
		chatText.setLineWrap(true);
		chatText.setEditable(false);
		chatText.setForeground(Color.BLACK);
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

		westPanel.add(chatPane, BorderLayout.WEST);
		add(westPanel, BorderLayout.WEST);

		JPanel eastPanel = new JPanel();
		JPanel eastNorthPanel = new JPanel();

		JLabel label = new JLabel("Connected users");
		eastPanel.setLayout(new GridLayout(4, 0));
		eastNorthPanel.setLayout(new BorderLayout());
		eastNorthPanel.add(label, BorderLayout.NORTH);
		JComponent list = createUserList();
		eastNorthPanel.add(list, BorderLayout.CENTER);

		eastPanel.add(eastNorthPanel);
		yourName = new JLabel("Your user name: ");

		yourScore = new JLabel("Your score: ");
		JPanel bPanel = new JPanel();
		eastPanel.add(yourName);
		eastPanel.add(yourScore);
		eastPanel.add(bPanel);

		JButton button = new JButton("Disconnect");
		button.addActionListener(new ActionHandler2());
		bPanel.add(button);
		add(eastPanel);
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

	// Metod för att fylla listan med inloggade users
	public void setUser(String userName) {
		userListModel.addElement(userName);
	}

	public void removeUser(String userName) {
		userListModel.removeElement(userName);
	}

	public void setChatText(String s) {
		chatText.append(s + "\n");
		chatText.setCaretPosition(chatText.getText().length());
	}

	public String scanNextLine() {
		if (chatLineText.isEmpty()) {
			return "§§§§§§§§§§";
		} else {
			String temp = chatLineText;
			chatLineText = "";
			return temp;
		}
	}

	public void setUserName(String userName) {
		yourName.setText("<html>Your user name: <br/>" + userName + "</html>");
	}

	public void setPoints(String points) {
		yourScore.setText("<html>Your Score: <br/>" + points + "</html>");
	}

	class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			chatLineText = chatLine.getText();
			chatLine.setText("");
		}
	}

	class ActionHandler2 implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			tabbedPane.setSelectedIndex(0);
			tabbedPane.setEnabledAt(2, false);
			tabbedPane.setEnabledAt(0, true);
			tabbedPane.setEnabledAt(1, true);
			userListModel.clear();
			setPoints("0");
			chatText.setText("");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			if (isHost()) {
				chatLineText = "hostquit";
				((ServerPane) tabbedPane.getComponentAt(1)).stopServer();
			} else {
				chatLineText = "quit";
			}
		}
	}

	public boolean isHost() {
		return host;
	}

	public void setHost() {
		host = true;
	}

	public void quit() {
		chatText.setText("");
		tabbedPane.setSelectedIndex(0);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setEnabledAt(1, true);
		chatLineText = "quit";
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}