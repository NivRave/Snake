import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MenuMain extends Menu{
	public JButton startButton;
	public JButton graphicsSetButton;
	public JButton snakeSetButton;
	public JButton levelSetButton;

	MenuMain(){
		super(new String("Main menu"));
		initButtons();
		setLayout(new GridLayout(0,1));
		add(startButton);
		add(graphicsSetButton);
		add(snakeSetButton);
		add(levelSetButton);
		startButton.addActionListener(this);
	}
	
	private void initButtons(){//set as abstract in parent and override @override
		initStartButton();
		initGraphicsButton();
		initSnakeButton();
		initLevelButton();
	}
	
	private void initStartButton(){
		startButton = new JButton();
		startButton.setText("New Game");
		startButton.setFont(new Font(null,Font.BOLD, 40));
		startButton.setSize(100, 100);
		startButton.setLocation(SnakePanel.getMapWidth()/2,SnakePanel.getMapHeight()/2);
	}
	
	private void initGraphicsButton(){
		graphicsSetButton=new JButton();
		graphicsSetButton.setText("Graphics settings");
		graphicsSetButton.setFont(new Font(null,Font.BOLD, 40));
		graphicsSetButton.setSize(100, 100);
		graphicsSetButton.setLocation(SnakePanel.getMapWidth()/2,SnakePanel.getMapHeight()/2);
	}
	
	private void initSnakeButton(){
		snakeSetButton=new JButton();
		snakeSetButton.setText("Snake settings-NOT WORKING");
		snakeSetButton.setFont(new Font(null,Font.BOLD, 40));
		snakeSetButton.setSize(100, 100);
		snakeSetButton.setLocation(SnakePanel.getMapWidth()/2,SnakePanel.getMapHeight()/2);
	}
	
	private void initLevelButton(){
		levelSetButton=new JButton();
		levelSetButton.setText("General settings");
		levelSetButton.setFont(new Font(null,Font.BOLD, 40));
		levelSetButton.setSize(100, 100);
		levelSetButton.setLocation(SnakePanel.getMapWidth()/2,SnakePanel.getMapHeight()/2);
	}
	
	@Override //override actionPerformed
	public void actionPerformed(ActionEvent e) {//maybe change to switch case
		if(e.getSource()==graphicsSetButton) {
		
		}
	}
	
	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}*/
	
}