package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class db{
   public static Connection loaddb() {
      Connection conn=null;
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url="jdbc:oracle:thin:@localhost:1521:XE";
         String user="c##sist";
         String pwd="sist";
         conn=DriverManager.getConnection(url, user, pwd);
      } catch (Exception e) {
      }
      return conn;
   }
   public static void close(ResultSet rs, Statement stmt, Connection conn){
      try {
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public static void close(Statement stmt, Connection conn) {
      try {
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}

public class StudentFrame extends JFrame {
   
   JTable table;
   Vector<String> colName;
   Vector<Vector<String>> rowData;
   JTextField jtf_name;
   JTextField jtf_kor;
   JTextField jtf_eng;
   JTextField jtf_math;
   JButton input;
   JButton update;
   JButton del;
   
   
   public StudentFrame() {
      input=new JButton("등록");
      update=new JButton("수정");
      del=new JButton("삭제");
      
      jtf_name=new JTextField(5);
      jtf_kor=new JTextField(5);
      jtf_eng=new JTextField(5);
      jtf_math=new JTextField(5);
      colName=new Vector<String>();
      rowData=new Vector<Vector<String>>();
      colName.add("이름");
      colName.add("국어");
      colName.add("영어");
      colName.add("수학");
      colName.add("총점");
      colName.add("평균");
      
      readStudent();
      
      JPanel bottom=new JPanel();
      bottom.setLayout(new BorderLayout());
      JPanel text=new JPanel();
      text.setLayout(new FlowLayout());
      text.add(new JLabel("이름"));
      text.add(jtf_name);
      text.add(new JLabel("국어"));
      text.add(jtf_kor);
      text.add(new JLabel("영어"));
      text.add(jtf_eng);
      text.add(new JLabel("수학"));
      text.add(jtf_math);
      
      JPanel btn=new JPanel();
      btn.setLayout(new FlowLayout());
      btn.add(input);
      btn.add(update);
      btn.add(del);
      
      bottom.add(text, BorderLayout.CENTER);
      bottom.add(btn, BorderLayout.SOUTH);
      
      table=new JTable(rowData,colName);
      JScrollPane jsp=new JScrollPane(table);
      setLayout(new BorderLayout());
      add(jsp, BorderLayout.CENTER);
      add(bottom, BorderLayout.SOUTH);
      
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
            int row=table.getSelectedRow();
            Vector<String> v=rowData.get(row);
            jtf_name.setText(v.get(0));
            jtf_kor.setText(v.get(1));
            jtf_eng.setText(v.get(2));
            jtf_math.setText(v.get(3));
         }
      });
      
      setSize(400,300);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   public void readStudent() {
      String sql="select *from student";
      try {
         Connection conn=db.loaddb();
         Statement stmt=conn.createStatement();
         ResultSet rs=stmt.executeQuery(sql);
         while(rs.next()) {
            String name=rs.getString(1);
            int kor=rs.getInt(2);
            int eng=rs.getInt(3);
            int math=rs.getInt(4);
            int total=kor+eng+math;
            int avg=total/3;
            
            Vector<String> v=new Vector<String>();
            v.add(name);
            v.add(kor+"");
            v.add(eng+"");
            v.add(math+"");
            v.add(total+"");
            v.add(avg+"");
            
            rowData.add(v);
            table.updateUI();
         }
         db.close(stmt, conn);
         
      } catch (Exception e) {
         // TODO: handle exception
      }
      
      
   }
   
   public static void main(String[] args) {
      new StudentFrame();
   }

}