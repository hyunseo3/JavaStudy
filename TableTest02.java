package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TableTest02 extends JFrame {
	JTable table;
	Vector<String> title;
	Vector<Vector<String>> data;
	JTextField name;
	JTextField age;
	JButton addd;
	JButton update;
	JButton del;
	
	public TableTest02() {
		title=new Vector<String>();
		title.add("이름");
		title.add("나이");
		data=new Vector<Vector<String>>();
		table=new JTable(data,title);
		name=new JTextField();
		age=new JTextField();
		addd=new JButton("추가");
		update=new JButton("수정");
		del=new JButton("삭제");
		
		setLayout(new BorderLayout()); 	

		JPanel down=new JPanel();
		down.setLayout(new BorderLayout()); 	
		
		JPanel text=new JPanel();
		text.setLayout(new GridLayout(2,2));
		text.add(new JLabel("이름: "));
		text.add(name);
		text.add(new JLabel("나이: "));
		text.add(age);
		
		JPanel btn=new JPanel();
		btn.setLayout(new FlowLayout());
		btn.add(addd);
		btn.add(update);
		btn.add(del);
		
		down.add(text, BorderLayout.CENTER);
		down.add(btn, BorderLayout.SOUTH);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				Vector<String> v=data.get(row);
				name.setText(v.get(0));
				age.setText(v.get(1));
			}
		});
		
		addd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Vector<String> v=new Vector<String>();
				v.add(name.getText());
				v.add(age.getText());
				data.add(v);
				table.updateUI();
				name.setText("");
				age.setText("");
			}
		});
		
		update.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Vector<String> v=new Vector<String>();
				v.add(name.getText());
				v.add(age.getText());
				int row=table.getSelectedRow();
				data.set(row, v);
				table.updateUI();
			}
		});
		del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				
				int re=JOptionPane.showConfirmDialog(null, "삭제");
				if(re==0) {
					data.remove(row);
					table.updateUI();
				}
			}
		});
		
		add(table, B
				orderLayout.CENTER);
		add(down,BorderLayout.SOUTH);
		
		
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TableTest02();
	}

}
