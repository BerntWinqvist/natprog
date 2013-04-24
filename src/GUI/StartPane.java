package GUI;
import java.awt.*;
import javax.swing.*;

public class StartPane extends JPanel {
	
	public StartPane(){
		
		
		
		
		Font font = new Font("Quickz", Font.PLAIN,30);
		JComponent top = new JLabel("Welcome to Quickz");
		top.setFont(font);
		add(top);
		
		
		
		
	}
	
	public JComponent test1(){
		
		JTextField field = new JTextField();
		return field;
		
	}
	
	


}
