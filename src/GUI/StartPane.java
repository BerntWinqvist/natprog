package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Client.Client;
import General.MulticastRequest;

public class StartPane extends JPanel {
	private JList serverList;
	private DefaultListModel serverListModel;
	private JLabel label;
	private JTextField field;
	private GridBagLayout layout;
	private GridBagConstraints c;
	private String selectedServer;
	private JTabbedPane tabbedPane;
	private HashMap<String, String> servers;
	private JFrame frame;

	public StartPane(JTabbedPane tabbedPane, JFrame frame) {
		this.frame = frame;
		this.tabbedPane = tabbedPane;
		layout = new GridBagLayout();
		c = new GridBagConstraints();
		this.setLayout(layout);

		// RAD 0
		label = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		label.setFont(new Font("Quickz", Font.PLAIN, 8));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.ipady = 25;
		c.gridy = 0;
		add(label, c);

		// RAD 1
		label = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		label.setFont(new Font("Quickz", Font.PLAIN, 8));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 1;
		add(label, c);
		label = new JLabel("Welcome to Quickz!");
		c.fill = GridBagConstraints.HORIZONTAL;
		label.setFont(new Font("Quickz", Font.PLAIN, 20));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 1;
		c.gridy = 1;
		add(label, c);

		label = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		label.setFont(new Font("Quickz", Font.PLAIN, 8));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 1;
		add(label, c);

		// RAD 2
		label = new JLabel("Username: ");
		label.setFont(new Font("Quickz", Font.PLAIN, 14));
		c.anchor = GridBagConstraints.LINE_START;
		c.ipady = 5;
		c.gridy = 2;
		c.gridx = 0;
		add(label, c);

		JComponent login = loginPane();
		c.fill = GridBagConstraints.HORIZONTAL;
		login.setLayout(new GridLayout(0, 2));
		c.weightx = 0;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 2;
		add(login, c);

		// RAD 3
		label = new JLabel("Select a server: ");
		label.setFont(new Font("Quickz", Font.PLAIN, 14));
		c.anchor = GridBagConstraints.LINE_START;
		c.ipady = 0;
		c.gridy = 3;
		c.gridx = 1;
		add(label, c);

		// RAD 4
		JComponent servers = createServerList();
		c.fill = GridBagConstraints.HORIZONTAL;
		servers.setLayout(new GridLayout(0, 1));
		servers.setSize(50, 50);
		c.gridx = 1;
		c.gridy = 4;
		c.ipady = 100;
		getServers();
		add(servers, c);

		JButton refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionHandler2());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.ipady = 1;
		c.gridx = 1;
		c.gridy = 5;
		add(refresh, c);

		JButton button = new JButton("Connect");
		button.addActionListener(new ActionHandler());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.ipady = 10;
		c.gridx = 1;
		c.gridy = 6;
		add(button, c);

		// RAD 5
		label = new JLabel(" ");
		c.fill = GridBagConstraints.HORIZONTAL;
		label.setFont(new Font("Quickz", Font.PLAIN, 8));
		c.weightx = 0;
		c.weighty = 0;
		c.ipady = 130;
		c.gridx = 0;
		c.gridy = 6;
		add(label, c);
	}

	public JComponent createServerList() {
		serverListModel = new DefaultListModel();
		serverList = new JList(serverListModel);
		serverList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		serverList.setPrototypeCellValue("123456789012");
		serverList.addListSelectionListener(new ServerSelectionListener());
		JScrollPane scrollPane = new JScrollPane(serverList);
		JPanel panel = new JPanel();
		panel.add(scrollPane);
		return panel;
	}

	// Här ska koden för att koppla ihop existerande servar till Listan finnas
	public void getServers() {
		servers = new HashMap<String, String>();
		MulticastRequest mcr = new MulticastRequest(serverListModel, servers);
		mcr.start();

	}

	public JComponent loginPane() {
		final JTextField field = new JTextField("", 30);
		field.setEditable(true);
		field.setSize(10, 10);
		field.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				field.setText("");
			}
		});
		this.field = field;
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(label, BorderLayout.WEST);
		p.add(field, BorderLayout.EAST);
		return p;
	}

	// Här kommer vilken man väljer, skrivs ut 2ggr, en för när man trycker ner,
	// och en när man släpper knappen.
	class ServerSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			selectedServer = (String) serverList.getSelectedValue();
		}
	}

	class ActionHandler implements ActionListener {
		@Override
		// När man trycker på Connect, här defineras vad som händer.
		public void actionPerformed(ActionEvent event) {
			String userName = field.getText();
			String host = getHost();
			if (host != null && !userName.equals("")) {
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				tabbedPane.setEnabledAt(0, false);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(2, true);
				tabbedPane.setSelectedIndex(2);
				Client client = new Client(host, userName,
						(JPanel) tabbedPane.getComponentAt(2));
				((GamePane) tabbedPane.getComponentAt(2)).clearUser();
				((GamePane) tabbedPane.getComponentAt(2)).setPoints("0");
				((GamePane) tabbedPane.getComponentAt(2)).setUserName(userName);
				((GamePane) tabbedPane.getComponentAt(2)).clearChatText();
				((GamePane) tabbedPane.getComponentAt(2)).setChatText("Välkommen " + userName + ", du är uppkopplad.");
				serverListModel.clear();
			} else {
				JOptionPane dialog = new JOptionPane();
				dialog.showMessageDialog(null,
						"Must choose a server and/or a username");
			}
		}
	}

	class ActionHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			getServers();
		}
	}

	public String getHost() {
		return servers.get(selectedServer);
	}
}