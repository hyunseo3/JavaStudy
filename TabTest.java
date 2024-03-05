package exam01;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TabTest extends JFrame {
	Gender gender;
	Food food;
	JTabbedPane pane;
	
	public TabTest () {
		gender=new Gender();
		food=new Food();
		pane=new JTabbedPane();
		
		pane.addTab("성별", gender);
		pane.addTab("음식", food);
		
		add(pane);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new TabTest();
	}

}
