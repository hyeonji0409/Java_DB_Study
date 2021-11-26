package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductSelect {
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

            String sql = "select * from product order by prdNo";

            // 쿼리문 전송을 위한 PreparedStatement 객체 생성
            // Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);

            // 쿼리문 실행시키고 결과 받아옴
            // select 구문이므로 excuteQuery() 메소드 사용
            // 반환되는 결과는 ResultSet 객체가 받음
            ResultSet rs = pstmt.executeQuery(sql);

            // 제목 출력
            System.out.println("\n상품 정보 조회");
            System.out.println("상품 번호 \t 상품명 \t\t\t\t\t\t\t 상품 가격 \t\t\t브랜드 \t\t color \t\t 카테고리 번호");

            // executeQuery() 실행 결과 받아온 ResultSet에서 데이터 추출
            // ResultSet의 next() 메서드를 이용해서 논맂거 커서를 이동해 각 열의 데이터 바인딩해옴
            // next(): 커서를 이동하면 다ㅡㅇㅁ 행 지정
            // 다음 행이 있으면 true, 없으면 false 반환
            while(rs.next()) {
                // (1) 한 행씩 next 하면서 데이터를 가져와 변수에 저장
                String prdNo = rs.getString(1);
                String prdName = rs.getString(2);
                int prdPrice = rs.getInt(3);
                String prdMaker = rs.getString(4);
                String prdColor = rs.getString(5);
                int ctgNo = rs.getInt(6);

                // (2) 한 행씩 변수 출력
                System.out.format("%-10s\t %-25s\t %-15d %-15s %-13s \t%3d \n",
                        prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            }

            // 모든 객체 close
            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }

    }
}
