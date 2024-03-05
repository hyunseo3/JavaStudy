package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class ImageTest extends JFrame {
	String title[]= {"사과","바나나","포도","복숭아","감"};
	String []img= {"apple.png","banana.jpg","grape.png","peach.png","persimmon.jpeg"};
	JRadioButton []jrb=new JRadioButton[title.length];
	JLabel jlb;
	HashMap<String, String> map;
	ImageIcon icon;
	
	public ImageTest() {
		ButtonGroup bg=new ButtonGroup();
		jlb=new JLabel(icon);
		map=new HashMap<String, String>();
		setLayout(new FlowLayout());
		for(int i=0;i<title.length;i++) {
			jrb[i]=new JRadioButton(title[i]);
			map.put(title[i], img[i]);
			bg.add(jrb[i]);
			add(jrb[i]);
			
			jrb[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String key=((JRadioButton)e.getSource()).getText();
					String fname=map.get(key);
					icon=new ImageIcon(fname);
					jlb.setIcon(icon);
				}
			});
		}
		add(jlb);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ImageTest();
	}

}
