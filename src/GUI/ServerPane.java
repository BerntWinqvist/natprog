package GUI;

import javax.swing.*;

import Client.Client;
import Server.Server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServerPane extends JPanel {
	private JLabel status;
	private JTextField[] fields;
	private JLabel emptyLabel;
	private int i;
	private JTabbedPane tabbedPane;

	public ServerPane(JTabbedPane tabbedPane) { 
		i=0;
		this.tabbedPane = tabbedPane;
		fields = new JTextField[2];
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		setLayout(layout);

		JComponent comp;

		Font font = new Font("Quickz", Font.PLAIN, 20);
		JComponent top = new JLabel("Create a server");
		top.setFont(font);
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1000000;
		c.gridx = 2;
		c.gridy = 0;
		c.ipadx = 10;

		add(top, c);

		comp = inputPane("Server name");
		c.weightx = 20;
		c.weighty = 1;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		add(comp, c);

		comp = inputPane("User name  ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 20;
		c.weighty = 1;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		add(comp, c);
		System.out.println(fields[0]);

		JButton button = new JButton("Create server");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 3;
		button.addActionListener(new ActionHandler());
		add(button, c);

		status = new JLabel("Server not running");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 20;
		c.weighty = 1;
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 5;
		add(status, c);

		emptyLabel = new JLabel("   ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 50;
		c.weighty = 1;
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 1;
		add(emptyLabel, c);
		
		
		
		
		fields[1].addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				fields[1].setText("");
			}
		});
		fields[0].addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				fields[0].setText("");
			}
		});
		

	}

	public JComponent inputPane(String text) {
		
		JLabel label = new JLabel(text + "   ");
		JTextField field = new JTextField(text, 10);
		field.setEditable(true);
		JPanel p = new JPanel();
	
		p.setLayout(new BorderLayout());
		p.add(label, BorderLayout.WEST);
		p.add(field, BorderLayout.CENTER);
		fields[i] = field;
		i++;
		return p;

	}
	


	// Vad som händer när du trycker på knapps
	class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			String name = fields[1].getText();
			String serverName = fields[0].getText();
			
			if(!serverName.equals("Server name") && !serverName.equals("") && !name.equals("User name  ") && !name.equals("")){

			try {				
				Server serv = new Server(serverName);
				serv.start();
				tabbedPane.setEnabledAt(0,false);
				tabbedPane.setEnabledAt(1,false);
				tabbedPane.setEnabledAt(2,true);
				tabbedPane.setSelectedIndex(2);
				status.setText("Server running");
				emptyLabel.setText("");
				Client client = new Client("localhost", name,
						(JPanel) tabbedPane.getComponentAt(2));			

				((GamePane)	tabbedPane.getComponentAt(2)).setUserName(name);
				((GamePane)	tabbedPane.getComponentAt(2)).setHost();

			} catch (Exception e) {
				e.printStackTrace();		

			}}else{
				JOptionPane dialog = new JOptionPane();
				dialog.showMessageDialog(null,"Must choose a server name and/or a username");
				
			}

		}

	}

}
