import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GraphicsSettings extends Menu{
	ComboBoxTemplate screenBox;
	ComboBoxTemplate snakeBox;
	ComboBoxTemplate appleBox;
	
	String[] colors={"Red","Green","Blue","Black","White","Cyan","Pink","Yellow","Custom"};
	//THESE ARE THE COLORS TO BE PASSES TO THE GAME WHEN NEW GAME IS PRESSED - STATIC FOR EASE OF ACCESS
	static Color screenClr=Color.black;
	static Color snakeClr=Color.green;
	static Color appleClr=Color.red;
	
	GraphicsSettings(){
	super("Hey"); 
		setLayout(new GridLayout(0,1));
		initBoxes();
		setListeners(new screenListener());
		add(selectComboBoxTitle("screen"));
		add(screenBox);
		add(selectComboBoxTitle("snake"));
		add(snakeBox);
		add(selectComboBoxTitle("apple"));
		add(appleBox);
	}
	
	private void initBoxes(){
		screenBox=new ComboBoxTemplate(colors);
		screenBox.setBackground(screenClr);
		screenBox.setOpaque(true);
		snakeBox=new ComboBoxTemplate(colors);
		snakeBox.setBackground(snakeClr);
		snakeBox.setOpaque(true);
		appleBox=new ComboBoxTemplate(colors);
		appleBox.setBackground(appleClr);
		appleBox.setOpaque(true);
	}
	
	private void setListeners(screenListener sl){
		screenBox.selectButton.addActionListener(sl);
		screenBox.defaultButton.addActionListener(sl);
		snakeBox.selectButton.addActionListener(sl);
		snakeBox.defaultButton.addActionListener(sl);
		appleBox.selectButton.addActionListener(sl);
		appleBox.defaultButton.addActionListener(sl);
	}
	
	private void setAColor(String color, String part){
		switch (part){
			case "Screen":{
					screenClr=StringToColor.getColor(color);//check if .getColor is the right way
					screenBox.setBackground(screenClr);
					screenBox.setOpaque(true);
					break;
			}
			case "Snake":{
					snakeClr=StringToColor.getColor(color);//check if .getColor is the right way
					snakeBox.setBackground(snakeClr);
					snakeBox.setOpaque(true);
					break;
			}
			case "Apple":{
					appleClr=StringToColor.getColor(color);//check if .getColor is the right way
					appleBox.setBackground(appleClr);
					appleBox.setOpaque(true);
					break;
			}
		}
	}
	
	private JLabel selectComboBoxTitle(String type){
		String title = new String("Choose " + type + " color:");
		JLabel label = new JLabel(title, JLabel.CENTER);
		label.setFont(new Font(null,Font.BOLD,45));
		return label;
	}
		
	public class screenListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==screenBox.selectButton){
			String c = screenBox.getVal();
			String p = "Screen";
			if(c!="Custom"){	
			setAColor(c, p);//set another method for custom input getter
			}
			else setAColor("Blue", p);
			//screenBox.setBackground(screenClr);
			//screenBox.setOpaque(true);
		}
		if(e.getSource()==screenBox.defaultButton){
			String p = "Screen";
			setAColor("black",p);
			//screenBox.setBackground(screenClr);
			//screenBox.setOpaque(true);
		}
		if(e.getSource()==snakeBox.selectButton){
			String c = snakeBox.getVal();
			String p = "Snake";
			if(c!="Custom"){	
			setAColor(c,p);//set another method for custom input getter
			}
			else setAColor("Blue",p);
			//snakeBox.setBackground(snakeClr);
			//snakeBox.setOpaque(true);
		}
		if(e.getSource()==snakeBox.defaultButton){
			String p = "Snake";
			setAColor("Green", p);
			//snakeBox.setBackground(snakeClr);
			//snakeBox.setOpaque(true);
		}
		if(e.getSource()==appleBox.selectButton){
			String c = appleBox.getVal();
			String p = "Apple";
			if(c!="Custom"){	
			setAColor(c,p);//set another method for custom input getter
			}
			else setAColor("Blue",p);
			//appleBox.setBackground(appleClr);
			//appleBox.setOpaque(true);
		}
		if(e.getSource()==appleBox.defaultButton){
			String p = "Apple";
			setAColor("Red", p);
			//appleBox.setBackground(appleClr);
			//appleBox.setOpaque(true);
		}
	}
}
}
