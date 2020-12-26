import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ComboBoxTemplate extends JLabel{//maybe add actionlistener?
	
	JComboBox<String> comboBox;
	JButton selectButton;
	JButton defaultButton;
	
	ComboBoxTemplate(String[] values){
		initBox(values);
	}
	
	public String getVal(){
	return comboBox.getSelectedItem().toString();
	}
	
	private void initBox(String [] values){
		setLayout(new FlowLayout());
		comboBox=new JComboBox<>(values);
		selectButton=new JButton("Select");
		defaultButton=new JButton("Default");
		add(comboBox);
		add(selectButton);
		add(defaultButton);
	}
}