package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ShoppingName extends JFrame {
	JTextArea jta;
	JButton btn;
	
	public ShoppingName() {
		jta=new JTextArea(20,20);
		btn=new JButton("출력");
		
		setLayout(new FlowLayout());
		add(jta);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="select food from shopping";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						String food=rs.getString(1);
						jta.append(food);
					}
					rs.close();
					stmt.close();
					conn.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		setSize(250,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new ShoppingName();
	}

}
