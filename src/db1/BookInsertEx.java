package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookInsertEx {
    public static void main(String[] args) {
        try {
            //JDBC Driver 클래스의 객체 생성 런타임시 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 주소, 사용자 계정, 패스워드 문자열 설정
            String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone=UTC";
            String user = "root";
            String pwd = "1234";

            // DB 연결하기 위한 객체 생성
            // DriverManager를 통해 Connection 객체 생성
            // MySQL 서버 연결 : 주소, 사용자 계정, 패스워드 전송
            Connection con = DriverManager.getConnection(url, user, pwd);

            // DB 연결 완료

            // 저장할 데이터
            String bookNo = "1016";
            String bookName = "알고리즘";
            String bookAuthor = "김철수";
            int bookPrice = 25000;
            String bookDate = "2021-10-10";
            int bookStock = 10;
            String pubNo = "1";

            // sql문 작성
            String sql = "insert into book values(?,?,?,?,?,?,?)";

            // sql문 values 들어갈 (?) 데이터 설정
            // 쿼리문 전송을 위한 PreparedStatement 객체 생성
            // Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,bookNo);
            pstmt.setString(2,bookName);
            pstmt.setString(3,bookAuthor);
            pstmt.setInt(4,bookPrice);
            pstmt.setString(5,bookDate);
            pstmt.setInt(6,bookStock);
            pstmt.setString(7,pubNo);
            
            // 쿼리문 실행 : 영향을 받은 행의 수 반환
            // select : executeQuery() - 결과 행 ResultSet반환
            // insert / update / delete : executeUadate() - 영향을 받은 행의 수 반환
            int result = pstmt.executeUpdate();

            // Connection 객체가 생성되면 DB 연결 성공
            if(result > 0) {
                System.out.println("데이터 입력 성공!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
