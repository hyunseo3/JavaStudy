package exam01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Food extends JPanel {
	String []arr= {"한식","중식","양식","일식"};
	JCheckBox []jcb=new JCheckBox[arr.length];
	JLabel jlb;
	
	public Food() {
		jlb=new JLabel();
		for(int i=0;i<arr.length;i++) {
			jcb[i]=new JCheckBox(arr[i]);
			add(jcb[i]);
			
			jcb[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String cmd="";
					for(int j=0;j<arr.length;j++) {
						if(jcb[j].isSelected()) {
						cmd+=jcb[j].getText()+",";
						}
					}
					cmd=cmd.substring(0, cmd.length()-1);
					jlb.setText(cmd);
				}
			});
			add(jlb);
		}
	}
}
