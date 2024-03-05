package exam01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Gender extends JPanel {
	JRadioButton man;
	JRadioButton woman;
	JLabel label;
	public Gender() {
		man= new JRadioButton("남자");
		woman= new JRadioButton("여자");
		label=new JLabel();
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(man);
		bg.add(woman);
		add(man);
		add(woman);
		add(label);
		
		man.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				label.setText("남자입니다");
			}
		});
		woman.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				label.setText("여자입니다");
			}
		});
		
	}
}
