package exam01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShoppingFrame extends JFrame {
   
   JTextField food;
   JTextField count;
   JTextField val;
   JButton btn;
   
   public ShoppingFrame() {
      food=new JTextField(20);
      count=new JTextField(20);
      val=new JTextField(20);
      btn=new JButton("확인");
      
      setLayout(new FlowLayout());
      add(new JLabel("음식:"));
      add(food);
      add(new JLabel("개수:"));
      add(count);
      add(new JLabel("가격:"));
      add(val);
      add(btn);
      
      setSize(250,300);
      setResizable(false);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      btn.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            String fodd=food.getText();
            int countt=Integer.parseInt(count.getText());
            int vall=Integer.parseInt(val.getText());
            
            try {
               String sql="insert into shopping values('"+fodd+"',"+countt+","+vall+")";
               Class.forName("oracle.jdbc.driver.OracleDriver");
               Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##sist","sist");
               Statement stmt=conn.createStatement();
               int re=stmt.executeUpdate(sql);
               if(re>0) {
            	   System.out.println("완료");
               }
               else {
            	   System.out.println("실패");
               }
               stmt.close();
               conn.close();
            } catch (Exception e2) {
            	
            }
            
         }
      });
   }
   public static void main(String[] args) {
      new ShoppingFrame();
   }

}