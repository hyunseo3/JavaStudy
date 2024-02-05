package exam04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxTest extends JFrame implements ActionListener{
	String []arr= {"사과","포도","오렌지","수박"};
	JCheckBox []jcb=new JCheckBox[arr.length];
	JLabel jlb;
	
	public CheckBoxTest() {
		jlb=new JLabel();
		setLayout(new FlowLayout());
		for(int i=0;i<arr.length;i++) {
			jcb[i]=new JCheckBox(arr[i]);
			add(jcb[i]);
			jcb[i].addActionListener(this);
		}
		add(jlb);
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CheckBoxTest();
	}

	public void actionPerformed(ActionEvent e) {
		String data="";
		for(int i=0;i<jcb.length;i++) {
			if(jcb[i].isSelected()) {
				data+=jcb[i].getText()+" ,";
			}
		}
		if(!data.equals("")) {
			data=data.substring(0, data.length()-1);
			jlb.setText(data);
		}
		else {
			jlb.setText(data);
		}
		
	}

}
