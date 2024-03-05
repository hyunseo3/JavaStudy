package exam01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableTestVectorinputFile extends JFrame {
   int row=0;
   protected static final int String = 0;
   JTable table;
   Vector<String> colName;
   Vector<Vector<String>> rowData;
   JTextField name;
   JTextField kor;
   JTextField math;
   JTextField eng;
   JButton update;
   JButton del;
   JButton btn;
   String path;
   
   public JTableTestVectorinputFile() {
      path="c:/temp/ss.txt";
      name=new JTextField(5);
      kor=new JTextField(5);
      math=new JTextField(5);
      eng=new JTextField(5);
      
      colName=new Vector<String>();
      rowData=new Vector<Vector<String>>();
      colName.add("이름");
      colName.add("국어");
      colName.add("영어");
      colName.add("수학");
      colName.add("총점");
      colName.add("평균");
      
      table=new JTable(rowData,colName);
      JScrollPane jsp=new JScrollPane(table);
      add(jsp, BorderLayout.CENTER);

      JPanel p_down=new JPanel();
      JPanel p_input=new JPanel();
      JPanel p_btn=new JPanel();
      
      p_input.setLayout(new GridLayout(4,2));
      p_down.setLayout(new BorderLayout());
      
      p_input.add(new JLabel("이름: "));
      p_input.add(name);
      p_input.add(new JLabel("국어: "));
      p_input.add(kor);
      p_input.add(new JLabel("수학: "));
      p_input.add(math);
      p_input.add(new JLabel("영어: "));
      p_input.add(eng);
      
      JButton prev=new JButton("[이전]");
      btn=new JButton("등록");
      update=new JButton("수정");
      del=new JButton("삭제");
      JButton save=new JButton("저장");
      JButton read=new JButton("읽어오기");
      JButton next=new JButton("[다음]");

      p_btn.add(prev);
      p_btn.add(btn);
      p_btn.add(update);
      p_btn.add(del);
      p_btn.add(save);
      p_btn.add(read);
      p_btn.add(next);
      
      p_down.add(p_input, BorderLayout.CENTER);
      p_down.add(p_btn, BorderLayout.SOUTH);
      
      add(p_down,BorderLayout.SOUTH);
      
      //행을 클릭하면 이름 국영수 칸에 출력되게 해야 함
      table.addMouseListener(new MouseListener() {
         
         public void mouseReleased(MouseEvent e) {
            
         }
         
         public void mousePressed(MouseEvent e) {
            
         }
         
         public void mouseExited(MouseEvent e) {
            
         }
         
         public void mouseEntered(MouseEvent e) {
            
         }
         
         public void mouseClicked(MouseEvent e) {
            int row=table.getSelectedRow();
            Vector<String> v=rowData.get(row);
            name.setText(v.get(0));
            kor.setText(v.get(1));
            math.setText(v.get(2));
            eng.setText(v.get(3));
         }
         
         
      });
      
      btn.addActionListener(new ActionListener() { //등록
         
         public void actionPerformed(ActionEvent e) {
            
            int korr=Integer.parseInt(kor.getText());
            int engg=Integer.parseInt(eng.getText());
            int mathh=Integer.parseInt(math.getText());
            int sum=korr+engg+mathh;
            int avg=sum/3;
                  
            Vector<String> v=new Vector<String>();
            v.add(name.getText());
            v.add(kor.getText());
            v.add(math.getText());
            v.add(eng.getText());
            v.add(sum+"");
            v.add(avg+"");
            rowData.add(v);
            table.updateUI();
            name.setText("");
            kor.setText("");
            eng.setText("");
            math.setText("");
         }
      });
      
      update.addActionListener(new ActionListener() { //수정
         
         public void actionPerformed(ActionEvent e) {
            int korr=Integer.parseInt(kor.getText());
            int engg=Integer.parseInt(eng.getText());
            int mathh=Integer.parseInt(math.getText());
            int sum=korr+engg+mathh;
            int avg=sum/3;
            Vector<String> v=new Vector<String>();
            v.add(name.getText()); //사용자가 입력한 ㅣㅇ름을 가지고 와서 벡타에 담는다
            v.add(kor.getText()); 
            v.add(math.getText()); 
            v.add(eng.getText());
            v.add(sum+"");
            v.add(avg+"");
            
            
            int row=table.getSelectedRow(); //테이블에서 선택된 인덱스를 알아야함
            rowData.set(row, v); //테이블을 위한 벡타 데이터가 rowData였음
            table.updateUI();
            name.setText("");
            kor.setText("");
            eng.setText("");
            math.setText("");
         }
      });
      
      del.addActionListener(new ActionListener() { //삭제
         
         public void actionPerformed(ActionEvent e) {
            int row=table.getSelectedRow();
            
            int re=JOptionPane.showConfirmDialog(null, "정말 삭제하겠습니까?"); //0이면 긍정 1이면 ㄴㄴ
            if(re==0){
               rowData.remove(row);
               table.updateUI();
               name.setText("");
               kor.setText("");
               eng.setText("");
               math.setText("");
            }

         }
      });
      
      save.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            try {
               
               ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("path"));
               oos.writeObject(rowData);
               oos.close();
               JOptionPane.showConfirmDialog(null, "저장");
            } catch (Exception e2) {
               System.out.println(e2.getMessage()); 
            }
         }
      });
      
      read.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            try {
               ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path));
               Vector<Vector<String>> list=(Vector<Vector<String>>)ois.readObject();
               for(Vector<String> list2:list) {
            	   rowData.add(list2);
               }
               table.updateUI();
               ois.close();
               
              Vector<String> r=rowData.get(row);
              name.setText(r.get(0));
              kor.setText(r.get(1));
              eng.setText(r.get(3));
              math.setText(r.get(2));
            } catch (Exception e2) {
               // TODO: handle exception
            }
         }
      });
      
      setSize(600,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args) {
      new JTableTestVectorinputFile();
   }
}