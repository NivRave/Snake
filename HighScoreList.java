import java.io.*;
/*import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class HighScoreList extends JPanel{
	ArrayList<JLabel> scores = new ArrayList<JLabel>();
	
	HighScoreList(){
		//scores = new JLabel();
		readHighScoreList("High scores.txt");
		setLayout(new GridLayout(0,1));
		addScores();
	}
	
	public void addScores(){
		for(JLabel jl:scores){
			this.add(jl);	
		}
	}
	
	public void readHighScoreList(String fileName){	
	 try {
	 	 String textLine="";
	 	 FileReader reader = new FileReader(fileName);
	 	 int data = reader.read();
	 	 while(data != -1) {
	 	 	 if(data!=10)textLine=textLine+(char)data;
	 	 	 else {
	 	 	 	scores.add(new JLabel(textLine));
	 	 	 	textLine="";	
	 	 	 }
	 	 }
	 	 	 data = reader.read();
   	  	 
   reader.close();
   //return textLine;//return the read text
  } catch (FileNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 // return textLine;
 }
}*/