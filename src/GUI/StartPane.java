package GUI;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class StartPane extends JPanel {
	
	private JList serverList;
	private DefaultListModel serverListModel;
	
	private String selectedServer; // Här läggs vald server från JListan
	
	public StartPane(){
		
		 setLayout(new BorderLayout());
		
		
		Font font = new Font("Quickz", Font.PLAIN,30);
		JComponent top = new JLabel("Welcome to Quickz");
		top.setFont(font);		
		add(top,BorderLayout.NORTH);
		
		JComponent servers = createServerList();
		add(servers,BorderLayout.LINE_END);
		getServers(); // Kallar på metod som hämtar aktuella servrar.
		
		JComponent login = loginPane(); 
		add(login);
		
		
	}
	
	public JComponent createServerList(){
		
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
	public void getServers(){
		for(int i =0;i<10;i++){
			serverListModel.addElement("String-Server" + i);
			
		}
		
	}
	
	public JComponent loginPane(){
		JLabel label = new JLabel("Username");
		JTextField field = new JTextField();
		field.setEditable(true);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(label,BorderLayout.LINE_START);
		p.add(field,BorderLayout.LINE_END);
		
		return p;
		
	}
	//Här kommer vilken man väljer, skrivs ut 2ggr, en för när man trycker ner, och en när man släpper knappen. 
	class ServerSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			selectedServer =(String) serverList.getSelectedValue();
			System.out.println(selectedServer);
			
		}
		
		
	}
	
	


}
