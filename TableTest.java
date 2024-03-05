package exam01;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame {
	JTable table;
	public TableTest() {
		String title[]= {"이름","나이"};
		String [][]data= {{"강현서","24"},{"ㄱㄱ","25"},{"ㅇㅇ","27"}};
		table=new JTable(data,title);
		JScrollPane jsp=new JScrollPane(table);
		add(jsp);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TableTest();
		
	}

}
