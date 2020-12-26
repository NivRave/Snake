import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener{

	static private int mapHeight = 1000;
	static private int mapWidth = 1000;
	static private int cellSize = 25;
	static private int cells = (mapWidth*mapHeight)/(cellSize*cellSize);//REMOVE? IS UNUSED@#!@E!@!!!
	static private int delay = 50;
	static private boolean bordersExist=false;//SET UP A METHOD FOR DEFINING USING OR NOT USING BORDERS
	static private boolean arrowKeysUsed=true;
	
	//Game's snake and apple
	private Snake snake;
	private Apple apple;
	//Other
	private int applesEaten;
	private char direction;
	private boolean gameOver=false;
	Timer clock;//timer for action
	//Timer gameRunTime;//timer for counting time
	public static final Random rand=new Random();
	public JButton restartButton;
	private endGame eg;
	
	SnakePanel(){
		setStartingConditions();
		this.setPreferredSize(new Dimension(getMapWidth(),getMapHeight()));
		this.setLayout(new BorderLayout());
		this.setBackground(GraphicsSettings.screenClr);
		this.setFocusable(true);
		this.addKeyListener(new ChangeDirection());
		setRestartButton();
		eg = new endGame();
		newGame();
	}
	
	static public int getMapHeight(){
		return mapHeight;
	}
	static public int getMapWidth(){
		return mapWidth;
	}
	static public int getCellSize(){
		return cellSize;
	}
	static public int getCells(){
		return cells;
	}
	static public int getDelay(){
		return delay;
	}
	static public void setDelay(int d){
		delay=d;
	}
	
	public void newGame() {
		applesEaten=0;
		apple=new Apple(rand);
		snake=new Snake(getMapWidth()/2,getMapHeight()/2);
		clock = new Timer(getDelay(),this);
		//gameRunTime = new Timer();
		clock.start();
		//gameRunTime.start();//check if need to create
	}
	
	public void restart(){
		gameOver=false;
		newGame();
	}
	
	public void setRestartButton(){
		this.restartButton= new JButton();
		this.restartButton.setText("Restart Game");
		this.restartButton.setSize(200, 100);
		this.restartButton.setFont(new Font(null,Font.BOLD, 24));
		this.restartButton.setLocation(getMapWidth()/2-100, getMapHeight()/2+getCellSize()*4);
		this.restartButton.addActionListener(this);
	}
	
	public void setStartingConditions(){
		//Set a random starting direction
		int i = rand.nextInt(4);
		switch (i){
		case 0:
			setDirection('R');
			break;
    	case 1:
    		setDirection('L');
    		break;
    	case 2:
    		setDirection('U');
    		break;
    	case 3:
    		setDirection('D');
    		break;
    	default://Will never happen, just in case right is the default
    		setDirection('R');
    		break;
        }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if(gameOver==false){
		if(apple.checkApple(snake.getHeadX(),snake.getHeadY())==true){
			snake.eat();
			applesEaten++;
		}
		g.setColor(GraphicsSettings.appleClr);
		g.fillOval(apple.getX(), apple.getY(), getCellSize(), getCellSize());	
		for(int i = 0; i < snake.getSize();i++) {	
			//draw head - MAYBE ADD AN OPTION TO CHOOSE PATTERN
			/*if(i==0){
				g.setColor(new Color(0,100,0));
				g.fillRect(snake.getHeadX(), snake.getHeadY(), CELL_SIZE, CELL_SIZE);
			}
			//draw body
			else{*/
				//g.setColor(new Color(152,251,152));
				g.setColor(GraphicsSettings.snakeClr);
				g.fillRect(snake.getX(i), snake.getY(i), getCellSize(), getCellSize());			
		}	
		printInfo(g);
		}
		else {
			gameOver(g);
		}
		}
	
	private void printInfo(Graphics g){
	g.setColor(Color.white);
	g.setFont(new Font(g.getFont().toString(),Font.BOLD, 40));
	FontMetrics infoMetrics = getFontMetrics(g.getFont());
	g.drawString("Score: "+applesEaten, (getMapWidth() - infoMetrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize()); //add timer from program start
	}
	
	
	
	public void checkClash() {
		for(int i = snake.getSize()-1;i>0;i--) {
			if((snake.getHeadX() == snake.getX(i))&& (snake.getHeadY() == snake.getY(i))) {
				gameOver = true;
			}
		}
		if(gameOver==true) {
			clock.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		//Score
		g.setColor(Color.white);
		g.setFont( new Font(g.getFont().toString(),Font.BOLD, 50));
		FontMetrics scoreMetrics = getFontMetrics(g.getFont());
		g.drawString("Your final score: "+applesEaten, (getMapWidth() - scoreMetrics.stringWidth("Your final score: "+applesEaten))/2, getMapHeight()/2-getCellSize()*3);
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font(g.getFont().toString(),Font.BOLD, 75));
		FontMetrics gameOverMetrics = getFontMetrics(g.getFont());
		g.drawString("Game Over!!", (getMapWidth() - gameOverMetrics.stringWidth("Game Over!!"))/2, getMapHeight()/2);
		//Game exit text
		g.setColor(Color.white);
		g.setFont( new Font(g.getFont().toString(),Font.BOLD, 50));
		FontMetrics endGameMetrics = getFontMetrics(g.getFont());
		g.drawString("Press 'Esc' to exit", (getMapWidth() - endGameMetrics.stringWidth("Press 'Esc' to exit"))/2, getMapHeight()/2+getCellSize()*2);
		//Restart button button listener
		this.add(restartButton);
		//End game key listener
		this.addKeyListener(eg);
	}
	
	@Override //override actionPerformed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==restartButton) {
			this.remove(restartButton);
			this.removeKeyListener(eg);
			this.restart();
			SwingUtilities.updateComponentTreeUI(this);
		  }
		else if(gameOver==false) {
			snake.moveSnake(direction);
			if(apple.checkApple(snake.getHeadX(),snake.getHeadY())==true){
				snake.eat();
				applesEaten++;
		} 
			checkClash();
		}
		repaint();
	}
	
	static public void setKeysMethod(char ch){
		switch(ch){
		case 'a':
			arrowKeysUsed=true;
			break;
		case 'w':
			arrowKeysUsed=false;
			break;
	}
	}
	
	public void setDirection(char c){
		switch (c){
			case 'R':
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case 'L':
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case 'U':
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case 'D':
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			default:
				break;
		}
	}
	
	public class ChangeDirection extends KeyAdapter{//Used for snake movement arrows - change to ChangeDirection1 and add ChangeDirection2 for WASD and define the correct one according to what is defined by input
		@Override
		public void keyPressed(KeyEvent e) {
			if(arrowKeysUsed==true)
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					setDirection('L');
					break;
				case KeyEvent.VK_RIGHT:
					setDirection('R');
					break;
				case KeyEvent.VK_UP:
					setDirection('U');
					break;
				case KeyEvent.VK_DOWN:
					setDirection('D');
					break;
				}
			else
				switch(e.getKeyCode()) {
				case KeyEvent.VK_A:
					setDirection('L');
					break;
				case KeyEvent.VK_D:
					setDirection('R');
					break;
				case KeyEvent.VK_W:
					setDirection('U');
					break;
				case KeyEvent.VK_S:
					setDirection('D');
					break;
			}
		}
	}
	public class endGame extends KeyAdapter{//Used when game over
		@Override
		public void keyPressed(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_ESCAPE && gameOver==true)//NEED TO FIX - WORKS ALL TIMES
				System.exit(0);
		}
	}
}