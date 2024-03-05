package exam01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest extends JFrame {
	JTextField jtf;
	String []arr= {"1","2","3","+",
			"4","5","6","-",
			"7","8","9","/",
			"0","C","=","*"};
	JButton[] btn=new JButton[arr.length];
	int a1;
	int a2;
	String a;
	
	public CalTest() {
		JPanel p1=new JPanel();
		setLayout(new BorderLayout());
		p1.setLayout(new GridLayout(4,4));
		jtf=new JTextField();
		add(jtf,BorderLayout.NORTH);
		for(int i=0;i<arr.length;i++) {
			btn[i]=new JButton(arr[i]);
			p1.add(btn[i]);
			
			btn[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String cmd=e.getActionCommand();
					if(cmd.equals("+")||cmd.equals("-")||cmd.equals("/")||cmd.equals("*")) {
						a1=Integer.parseInt(jtf.getText());
						a=cmd;
						jtf.setText("");
					}
					if(cmd.equals("=")) {
						a2=Integer.parseInt(jtf.getText());
						switch(cmd) {
						case "+": a1+=a2;break;
						case "-": a1=a1-a2;break;
						case "/": a1=a1/a2;break;
						case "*": a1=a1*a2;break;
						}
					}
					jtf.setText(a1+"");
					
				}
			});
		}
		add(p1, BorderLayout.CENTER);
		setSize(200,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		new CalTest();
	}

}
