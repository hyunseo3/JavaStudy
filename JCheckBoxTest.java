package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxTest extends JFrame implements ActionListener{
	JCheckBox jcb_apple;
	JCheckBox jcb_grape;
	JLabel result;
	
	public JCheckBoxTest() {
		jcb_apple=new JCheckBox("사과");
		jcb_grape=new JCheckBox("포도");
		result=new JLabel();
		jcb_apple.addActionListener(this);
		jcb_grape.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(jcb_apple);
		add(jcb_grape);
		add(result);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new JCheckBoxTest();

	}

	public void actionPerformed(ActionEvent e) {
		boolean ap=jcb_apple.isSelected();
		boolean gr=jcb_grape.isSelected();
		String result1="";
		if(ap==true&&gr==false) {
			result1="사과를 선택하셨습니다";
		}
		else if(ap==false&&gr==true) {
			result1="포도를 선택하셨습니다";
		}
		else if(ap==false&&gr==false) {
			result1="선택하지 않았습니다";
		}
		else if (ap==true&&gr==true) {
			result1="둘 다 선택하셨습니다";
		}
		result.setText(result1);
	}

}
