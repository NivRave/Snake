import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GameSettings extends Menu{
	//difficulty/speed/borders/etc...
	ComboBoxTemplate difficultyBox;
	ComboBoxTemplate bordersBox;
	ComboBoxTemplate speedBox;
	ComboBoxTemplate keysBox;//arrows or wasd
	
	String[] difOptions={"Easy","Medium","Professional"};//maybe add other?
	String[] borderOptions={"With borders","Without borders"};
	String[] speedOptions={"Fast","Normal","Slow", "Super slow"};
	String[] keyOptions={"Arrow keys","W-A-S-D keys"};
	
	GameSettings(){
	super("Level settings");
	setLayout(new GridLayout(0,1));
		difficultyBox=new ComboBoxTemplate(difOptions);
		bordersBox=new ComboBoxTemplate(borderOptions);
		speedBox=new ComboBoxTemplate(speedOptions);
		keysBox=new ComboBoxTemplate(keyOptions);
		//setListeners(new screenListener()); SET LISTENERS
		speedBox.selectButton.addActionListener(new levelListener());
		keysBox.selectButton.addActionListener(new levelListener());
		add(selectComboBoxTitle("difficulty NOT WORKINGGGG"));
		add(difficultyBox);
		add(selectComboBoxTitle("borders NOT WORKINGGGG"));
		add(bordersBox);
		add(selectComboBoxTitle("speed"));
		add(speedBox);
		add(selectComboBoxTitle("keys"));
		add(keysBox);
	}
	
	private JLabel selectComboBoxTitle(String type){
		String title = new String("Choose " + type + " settings:");
		JLabel label = new JLabel(title, JLabel.CENTER);
		label.setFont(new Font(null,Font.BOLD,40));
		return label;
	}
	
	private void setSpeed(){//maybe change to return static int and discard the stataic int delay in snakepanel
		int delay=50;//set for default to avoid problems
		String c = speedBox.getVal();
		switch (c){//add default?
		case "Fast":
			delay=25;
			break;
		case "Normal":
			delay=35;
			break;
		case "Slow":
			delay=50;
			break;
		case "Super slow":
			delay=75;
			break;
		}
		SnakePanel.setDelay(delay);
	}
	
	private void setKeys(){
		String c = keysBox.getVal();
		char ch='a';
		switch(c){//add default?
			case "Arrow keys":
			ch='a';
			break;
			case "W-A-S-D keys":
			ch='w';
			break;
		}
		SnakePanel.setKeysMethod(ch);
	}
	
	public class levelListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==speedBox.selectButton){
				setSpeed();
			}
			if(e.getSource()==keysBox.selectButton){
				setKeys();
			}
		}
	}
}