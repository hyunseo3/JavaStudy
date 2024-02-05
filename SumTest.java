package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SumTest extends JFrame implements ActionListener{
	JLabel jlb;
	JTextField jtf;
	JButton btn;
	
	public SumTest() {
		jlb=new JLabel();
		jtf=new JTextField(5);
		btn=new JButton("확인");
		jtf.addActionListener(this);
		btn.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(new JLabel("숫자 입력: "));
		add(jtf);
		add(btn);
		add(new JLabel("결과: "));
		add(jlb);
		
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		int n=Integer.parseInt(jtf.getText());
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		jlb.setText(sum+"");
		
	}
	public static void main(String[] args) {
		new SumTest();
	}

}
