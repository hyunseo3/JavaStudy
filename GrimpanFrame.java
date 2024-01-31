package exam03;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import exam01.File;

class GInfo implements Serializable{
	private int x1, y1, x2, y2;
	private int drawType;
	private Color drawColor;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getDrawType() {
		return drawType;
	}
	public void setDrawType(int drawType) {
		this.drawType = drawType;
	}
	public Color getDrawColor() {
		return drawColor;
	}
	public void setDrawColor(Color drawColor) {
		this.drawColor = drawColor;
	}
	public GInfo(int x1, int y1, int x2, int y2, int drawType, Color drawColor) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.drawType = drawType;
		this.drawColor = drawColor;
	}
}

class GrimpanPanel extends JPanel implements MouseListener{

	boolean isNew;
	ArrayList<GInfo> list;
	
	int drawType=0;
	Color drawColor;
	
	public GrimpanPanel() {
		addMouseListener(this);
		list=new ArrayList<GInfo>();
	}
	
	private int x1,y1,x2,y2;
	
	public void paint(Graphics g) {
		super.paint(g);
		for(GInfo info:list) {
			g.setColor(info.getDrawColor());
			int w=info.getX2()-info.getX2();
			int h=info.getY2()-info.getY2();
			int x=info.getX1();
			int y=info.getY2();
			
			if(info.getX1()>info.getX2()) {
				w=info.getX1()-info.getX2();
				x=info.getX2();
			}
			if(info.getY1()>info.getY2()) {
				h=info.getY1()-info.getY2();
				y=info.getY2();
			}
			switch(info.getDrawType()) {
			case 0:
				g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
				break;
			case 1:
				g.drawRect(x, y, w, h);
				break;
			case 2:
				g.drawOval(x, y, w, h);
				break;
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2=e.getX();
		y2=e.getY();
		list.add(new GInfo(x1, y1, x2,  y2, drawType,drawColor));
		isNew=true;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class GrimpanFrame extends JFrame implements ActionListener {
	
	GrimpanPanel pan;
	JColorChooser jcc;
	JFileChooser jfc;
	
	File file;
	
	public GrimpanFrame() {
		setTitle("그림판");
		setSize(600,500);
		pan=new GrimpanPanel();
		add(pan);
		
		jcc=new JColorChooser(Color.black);
		jfc=new JFileChooser("c:/temp");
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file=new JMenu("파일");
		JMenuItem file_new=new JMenuItem("새파일");
		JMenuItem file_open=new JMenuItem("열기");
		JMenuItem file_save=new JMenuItem("저장");
		JMenuItem file_exit=new JMenuItem("종료");
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_exit.addActionListener(this);
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		mn_file.add(file_exit);
		jmb.add(mn_file);
		
		JMenu mn_draw=new JMenu("그리기 도구");
		JMenuItem line=new JMenuItem("선");
		JMenuItem rect=new JMenuItem("사각형");
		JMenuItem oval=new JMenuItem("원");
		line.addActionListener(this);
		rect.addActionListener(this);
		oval.addActionListener(this);
		
		mn_draw.add(line);
		mn_draw.add(rect);
		mn_draw.add(oval);
		
		jmb.add(mn_draw);
		
		JMenu mn_color=new JMenu("색상");
		JMenuItem other=new JMenuItem("색상 팔레트");
		other.addActionListener(this);
		mn_color.add(other);
		jmb.add(mn_color);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd=e.getActionCommand();
		System.out.println(cmd);
		switch(cmd) {
		case "선": pan.drawType=0;break;
		case "사각형": pan.drawType=1;break;
		case "원": pan.drawType=2;break;
		
		case "색상 팔레트":pan.drawColor=jcc.showDialog(this, "색상 선택", Color.black);
		
		case "종료": 
			System.exit(0);
			break;
		}
		
	}
	public static void main(String[] args) {
		new GrimpanFrame();
	}


}
