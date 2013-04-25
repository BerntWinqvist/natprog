package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerPane extends JPanel {
	private JLabel status;
	private JTextField[] fields;

	public ServerPane() {

		fields = new JTextField[2];
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;		
		setLayout(layout);	
		
		JComponent comp;
		
		Font font = new Font("Quickz", Font.PLAIN,30);
		JComponent top = new JLabel("Welcome to Quickz");
		top.setFont(font);		
		c.weightx = 1;
		c.weighty=1;
		c.gridwidth = 1000000;
		c.gridx=2;
		c.gridy=0;
		c.ipadx=10;
		
		
		add(top,c);
		
		
		
		comp= inputPane("Server name");
		c.weightx = 20;
		c.weighty=1;
		c.gridx=1;
		c.gridwidth = 2;
		c.gridy=1;
		add(comp,c);
		
		
		comp= inputPane("Port number");
		c.fill = GridBagConstraints.HORIZONTAL;		
		c.weightx = 20;
		c.weighty=1;
		c.gridwidth = 2;
		c.gridx=1;
		c.gridy=2;
		add(comp,c);
		System.out.println(fields[0]);
		
		JButton button = new JButton("Create server");
		c.fill = GridBagConstraints.HORIZONTAL;		
		c.weightx=0;
		c.weighty=0;
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 3;
		button.addActionListener(new ActionHandler());
		add(button,c);
		
		status = new JLabel("Server not running");
		c.fill = GridBagConstraints.HORIZONTAL;		
		c.weightx=20;
		c.weighty=1;
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 4;
		add(status,c);
		
		status = new JLabel("                            ");
		c.fill = GridBagConstraints.HORIZONTAL;		
		c.weightx=50;
		c.weighty=1;
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 1;
		add(status,c);
		
		
				
	}


	public JComponent inputPane(String text){
		int i =0;
		JLabel label = new JLabel(text +"   ");
		JTextField field = new JTextField(text,10);
		field.setEditable(true);			
		JPanel p = new JPanel();		
		p.setLayout(new BorderLayout());
		p.add(label,BorderLayout.WEST);
		p.add(field,BorderLayout.CENTER);
		fields[i] = field;
		i++;
		return p;
		
	}
	 
	// Vad som händer när du trycker på knapps
	class ActionHandler implements ActionListener{
	int i =0;
		@Override
		public void actionPerformed(ActionEvent event) {
			i++;
			System.out.println("Knapp-tryck HEHE");
			System.out.println(fields[0].getText());
			
			
		}
		
		
	}

}
