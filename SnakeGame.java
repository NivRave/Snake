import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
*/
public class SnakeGame extends JFrame implements ActionListener{
	
	SnakePanel game;
	MenuMain menu;
	GraphicsSettings m3;
	Menu m2;
	JPanel master;
	GameSettings gs;
	//HighScoreList hs;
	
	SnakeGame(){
		this.setTitle("Snake game by Niv Rave");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(SnakePanel.getMapWidth(), SnakePanel.getMapHeight());
		this.setResizable(false);
		master=new JPanel(new BorderLayout());
		this.setLocationRelativeTo(null);
		initMenuObjects();
		master.add(m2, BorderLayout.NORTH);
		master.add(menu, BorderLayout.CENTER);
		m2.mainMenuButton.addActionListener(this);
		menu.startButton.addActionListener(this);
		menu.graphicsSetButton.addActionListener(this);
		//menu.snakeSetButton.addActionListener(this); BRING BACK WHEN FIXED
		menu.levelSetButton.addActionListener(this);
		this.getContentPane().add(master);
		this.setVisible(true);
		
	}
	
	public void initMenuObjects(){
	//hs=new HighScoreList(); BRING BACK WHEN FIXED
		m2=new Menu("Test");
		m3=new GraphicsSettings();
		gs=new GameSettings();
		menu=new MenuMain();
	}
	
	private void initGraphicsPage(){
		master.removeAll();
		master.revalidate();
		master.add(m2, BorderLayout.NORTH);
		master.add(m3, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private void initLevelSettingsPage(){
		master.removeAll();
		master.revalidate();
		master.add(m2, BorderLayout.NORTH);
		master.add(gs, BorderLayout.CENTER);
		this.setVisible(true);
	}	
	
	private void initMainMenu(){
		master.removeAll();
		master.revalidate();
		master.add(m2, BorderLayout.NORTH);
		master.add(menu, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	/*public void showHighScores(){
		remove(master);
		master=new JPanel(new BorderLayout());
		master.add(m2, BorderLayout.NORTH);
		master.add(new HighScoreList(), BorderLayout.CENTER); 	BRING BACK WHEN FIXED
		m2.mainMenuButton.addActionListener(this);
		this.getContentPane().add(master);
		this.setVisible(true);
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.startButton){
			this.remove(master);
			game=new SnakePanel();
			game.restartButton.addActionListener(this);
			this.add(game);
			game.requestFocusInWindow();
			SwingUtilities.updateComponentTreeUI(this);
		}
		if(e.getSource()==menu.graphicsSetButton) {
			initGraphicsPage();
			SwingUtilities.updateComponentTreeUI(this);
		}
		if(e.getSource()==menu.levelSetButton) {
			initLevelSettingsPage();
			SwingUtilities.updateComponentTreeUI(this);
		}
		/*if(e.getSource()==menu.snakeSetButton) {
			showHighScores();									BRING BACK WHEN FIXED
			SwingUtilities.updateComponentTreeUI(this);
		}*/
		if(e.getSource()==m2.mainMenuButton) {
			int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to return to the main menu?","WARNING",JOptionPane.YES_NO_OPTION);
			if (dialogButton==JOptionPane.YES_OPTION){//return to main menu
			initMainMenu();
			SwingUtilities.updateComponentTreeUI(this);
			}
			else remove(dialogButton);
		}
	}
}