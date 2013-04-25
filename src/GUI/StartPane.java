package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StartPane extends JPanel {

	private JList serverList;
	private DefaultListModel serverListModel;
	private JButton button;
	private JLabel label;
	private GridBagLayout layout;
	private GridBagConstraints c;
	private String selectedServer; // HÃ¤r lÃ¤ggs vald server frÃ¥n JListan

	public StartPane() {

		layout = new GridBagLayout();
		c = new GridBagConstraints();
		this.setLayout(layout);

		c.fill = GridBagConstraints.HORIZONTAL;
		label = new JLabel("");
		label.setFont(new Font("Nitrox-is-a-bit-OP", Font.PLAIN, 8));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 5;
		c.gridy = 0;
		add(label, c);

		label = new JLabel("Welcome to Quickz!");
		label.setFont(new Font("Quickz", Font.PLAIN, 20));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		add(label, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		JComponent login = loginPane();
		login.setLayout(new GridLayout(0, 2));
		c.weightx = 0;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;
		add(login, c);

		JComponent servers = createServerList();
		servers.setLayout(new GridLayout(0, 1));
		servers.setSize(50, 50);
		c.weightx = 50;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 2;
		add(servers, c);
		getServers();

		JButton button = new JButton("Connect");
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 3;
		add(button, c);

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

	// HÃ¤r ska koden fÃ¶r att koppla ihop existerande servar till Listan finnas
	public void getServers() {
		for (int i = 0; i < 10; i++) {
			serverListModel.addElement("Server " + i);

		}

	}

	// FÃ¶rsÃ¶k till att fixa en JLabel och JTextField
	public JComponent loginPane() {
		JLabel label = new JLabel("Username :");
		final JTextField field = new JTextField("......", 30);
		field.setEditable(true);
		field.setSize(10, 10);
		field.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				field.setText("");
			}
		});

		JPanel p = new JPanel();

		p.setLayout(new BorderLayout());
		p.add(label, BorderLayout.WEST);
		p.add(field, BorderLayout.EAST);

		return p;

	}

	// HÃ¤r kommer vilken man vÃ¤ljer, skrivs ut 2ggr, en fÃ¶r nÃ¤r man trycker
	// ner,
	// och en nÃ¤r man slÃ¤pper knappen.
	class ServerSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			selectedServer = (String) serverList.getSelectedValue();
			System.out.println(selectedServer);

		}

	}

}
