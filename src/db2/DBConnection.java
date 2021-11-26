package db2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args) {
        try {
            //JDBC Driver 클래스의 객체 생성 런타임시 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 주소, 사용자 계정, 패스워드 문자열 설정
            String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
            String user = "root";
            String pwd = "1234";

            // DB 연결하기 위한 객체 생성
            // DriverManager를 통해 Connection 객체 생성
            // MySQL 서버 연결 : 주소, 사용자 계정, 패스워드 전송
            Connection con = DriverManager.getConnection(url, user, pwd);

            // Connection 객체가 생성되면 DB 연결 성공
            if(con != null) {
                System.out.println("DB 연결 성공!");
            }

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
