package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GenderTest extends JFrame implements ActionListener{
	JRadioButton jrb_man;
	JRadioButton jrb_woman;
	JLabel jlb;
	
	public GenderTest() {
		setLayout(new FlowLayout());
		ButtonGroup bg=new ButtonGroup();
		jrb_man=new JRadioButton("남자");
		jrb_woman=new JRadioButton("여자");
		jlb=new JLabel();
		bg.add(jrb_man);
		bg.add(jrb_woman);
		add(jrb_man);
		add(jrb_woman);
		jrb_man.addActionListener(this);
		jrb_woman.addActionListener(this);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new GenderTest();
	}

	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();
		if(cmd.equals("남자")) {
			
		}
	}

}
