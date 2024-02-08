package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ShoppingTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("음식");
		String food=sc.next();
		System.out.println("개수");
		int count=sc.nextInt();
		System.out.println("가격");
		int val=sc.nextInt();
		
		try {
			//실행할 sql 명령어 생성
			String sql="insert into shopping values('"+food+"',"+count+","+val+")"; 
			
			//1. jdbc 드라이버를 메모리로 로드한다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.DB서버에 연결하기
			Connection conn=null;
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##sist", "sist");
			
			//3.sql 명령을 실행하기 위한 statement 객체 생성
			Statement stmt=conn.createStatement();
			
			//4.sql 명령 실행
			int re=stmt.executeUpdate(sql);
			if(re==1) {
				System.out.println("레코드 추가");
				}else {
					System.out.println("실패");}
			
			//5. 사용했던 자원 닫아줌
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}


