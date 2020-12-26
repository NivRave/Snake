import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Menu extends JPanel implements ActionListener{
	JLabel titleLabel;
	JButton exitButton;//exit game
	JButton mainMenuButton;//main menu
	JButton undoButton;//undo actions - revert to default MAYBE CHANGE TO DEFAULT SETTINGS
	JButton saveButton;//save changes CHANGE TO NEW GAME
	static int c=0;
	
	public Menu(String title){
		initTitle(title);
		initButtons();
		if(c==0){
			drawButtons();
			c++;
		}
		exitButton.addActionListener(this);
		mainMenuButton.addActionListener(this);
	}
	
	private void initTitle(String title){
		titleLabel=new JLabel();
		titleLabel.setText(title);
		titleLabel.setFont(new Font(null,Font.BOLD, 40));
	}
	
	private void initButtons(){
		initExit();
		initUndo();
		initSave();
		initPrev();
	}
	
	private void initExit(){
		exitButton=new JButton("Exit and close the game");
	}
	
	private void initUndo(){
		undoButton=new JButton("INACTIVE");
	}
	
	private void initSave(){
		saveButton=new JButton("INACTIVE");//maybe find a general command
	}
	private void initPrev(){
		mainMenuButton=new JButton("Main menu");
	}
	
	private void drawButtons(){
		setLayout(new FlowLayout());
		add(mainMenuButton);
		add(undoButton);
		add(saveButton);
		add(exitButton);
	}
	
	@Override //override actionPerformed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitButton) {
			int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
			if (dialogButton==JOptionPane.YES_OPTION) System.exit(0);
			else remove(dialogButton);
	}
		if(e.getSource()==mainMenuButton) {
		//algorithm to save last menu?
		}
		if(e.getSource()==undoButton){
		//algorithm to undo changes
		}
		if(e.getSource()==saveButton){
		//algorithm to save changes
		}
}
}