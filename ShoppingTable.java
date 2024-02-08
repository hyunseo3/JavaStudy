package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShoppingTable extends JFrame {
	JTable table;
	Vector<String> colName;
	Vector<Vector<String>> rowData;
	JButton btn_print;
	JButton btn_del;
	
	public ShoppingTable() {
		btn_print=new JButton("출력");
		btn_del=new JButton("삭제");
		JPanel btn=new JPanel();
		btn.setLayout(new FlowLayout());
		btn.add(btn_print);
		btn.add(btn_del);
		
		colName=new Vector<String>();
		rowData=new Vector<Vector<String>>();
		colName.add("음식");
		colName.add("개수");
		colName.add("가격");
		table=new JTable(rowData,colName);
		JScrollPane jsp=new JScrollPane(table);
		add(jsp, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		btn_print.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					String sql="select * from shopping";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url="jdbc:oracle:thin:@localhost:1521:XE";
					String user="c##sist";
					String pwd="sist";
					Connection conn=DriverManager.getConnection(url,user,pwd);
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						String food=rs.getString(1);
						int count=rs.getInt(2);
						int val=rs.getInt(3);
						
						Vector<String> v=new Vector<String>();
						v.add(food);
						v.add(count+"");
						v.add(val+"");
						rowData.add(v);
					}
					table.updateUI();
					rs.close();
					stmt.close();
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		btn_del.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ShoppingTable();
	}

}
