import java.util.ArrayList;

public class Snake{
	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();
	//private int x[];
	//private int y[];
	private int snakeSize =10;	


	Snake(int x0, int y0)		
	{
		/*x=new int[SnakePanel.CELLS];
		y=new int[SnakePanel.CELLS];
		x[0]=x0;
		y[0]=y0;*/
		
		//Arraylist
		//x.add(x0);
		//y.add(y0);
		initSnakeBody(x0, y0);
	}
	
	
	public void initSnakeBody(int x0, int y0){
		for(int i=0;i<snakeSize;i++){
			x.add(x0);
			y.add(y0);
		}
	}
	
	public int getSize(){
		return snakeSize;
	}
	
	public int getX(int i){
		//return x[i];
		return x.get(i);
	}
	
	public int getY(int i){
		//return y[i];
		return y.get(i);
	}
	
	public int getHeadX(){
		//return x[0];
		return x.get(0);
	}
	
	public int getHeadY(){
		//return y[0];
		return y.get(0);
	}
	
	public void eat(){
		x.add(x.get(snakeSize-1));
		y.add(y.get(snakeSize-1));
		snakeSize++;
	}
	
	/*public void moveSnake(char d){
		for(int i = snakeSize-1;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(d) {
		case 'U':
			if(y[0] <= 0) y[0] = SnakePanel.MAP_HEIGHT;
			else y[0] = y[0] - SnakePanel.CELL_SIZE;
			break;
		case 'D':
			if(y[0] >= SnakePanel.MAP_HEIGHT) y[0]=0;
			else y[0] = y[0] + SnakePanel.CELL_SIZE;
			break;
		case 'L':
			if(x[0] <= 0) x[0] = SnakePanel.MAP_WIDTH;
			else x[0] = x[0] - SnakePanel.CELL_SIZE;
			break;
		case 'R':
			if(x[0] >= SnakePanel.MAP_WIDTH) x[0] = 0;
			else x[0] = x[0] + SnakePanel.CELL_SIZE;
			break;
		}		
	}*/
	
	//ArrayList change to <= =>
	public void moveSnake(char d){
		for(int i = snakeSize-1;i>0;i--) {
			x.set(i,x.get(i-1));
			y.set(i,y.get(i-1));
		}
		switch(d) {
		case 'U':
			if(getHeadY() == 0) y.set(0,SnakePanel.getMapHeight());
			else y.set(0,y.get(0) - SnakePanel.getCellSize());
			break;
		case 'D':
			if(getHeadY() == SnakePanel.getMapHeight()) y.set(0,0);
			else y.set(0,y.get(0) + SnakePanel.getCellSize());
			break;
		case 'L':
			if(getHeadX() == 0) x.set(0,SnakePanel.getMapWidth());
			else x.set(0,x.get(0) - SnakePanel.getCellSize());
			break;
		case 'R':
			if(getHeadX() == SnakePanel.getMapWidth()) x.set(0,0);
			else x.set(0,x.get(0) + SnakePanel.getCellSize());
			break;
		}		
	}
	
}