package GUI;

import javax.swing.*;

import java.awt.*;

public class ServerPane extends JPanel {

	public ServerPane() {

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;		
		setLayout(layout);
		JComponent comp;
		comp= inputPane("Server name");
		c.weightx = 40;
		c.weighty=1;
		c.gridx=1;
		c.gridy=1;
		add(comp,c);
		
		
		comp= inputPane("Port number");
		c.weightx = 40;
		c.weighty=1;
		c.gridx=1;
		c.gridy=2;
		add(comp,c);
		
		
		comp = new JButton("NR2");
		c.weightx=2;
		c.weighty=10;
		c.gridx = 100;
		c.gridy = 100;
		add(comp,c);
		
		JComponent input1 = inputPane("Port number");
	
				


		
	}

	public void makeComponent(JComponent comp, GridBagLayout gridbag,
			GridBagConstraints c) {		
		
		

	}
	
	
	public JComponent inputPane(String text){
		JLabel label = new JLabel(text);
		JTextField field = new JTextField(text,30);
		field.setEditable(true);
		field.setSize(10, 10);
		
		
		JPanel p = new JPanel();
		
		p.setLayout(new BorderLayout());
		p.add(label,BorderLayout.WEST);
		p.add(field,BorderLayout.CENTER);
		
		return p;
		
	}

}
