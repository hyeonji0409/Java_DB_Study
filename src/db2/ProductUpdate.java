package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("데이터 수정");
        System.out.println("--------------------");

        System.out.print("수정할 상품 번호: ");
        String prdNo = scan.nextLine();

        System.out.print("상품명: ");
        String prdName = scan.nextLine();

        System.out.print("상품 가격: ");
        int prdPrice = scan.nextInt();

        // 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어들임
        scan.nextLine();

        System.out.print("상품 브랜드: ");
        String prdMaker = scan.nextLine();

        System.out.print("상품 색깔: ");
        String prdColor = scan.nextLine();

        System.out.print("카테고리 번호: ");
        int ctgNo = scan.nextInt();

        try {
            //JDBC Driver 클래스의 객체 생성 런타임시 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 주소, 사용자 계정, 패스워드 문자열 설정
            String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
            String user = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url, user, pwd);


            if(con != null) {
                System.out.println("DB 연결 성공!");
            }

            // sql문 작성
            String sql = "update product set prdName=?, prdPrice=?, prdMaker=?, " +
                    "prdColor=?, ctgNo=? where prdNo=?";

            // sql문 values 들어갈 (?) 데이터 설정
            // 쿼리문 전송을 위한 PreparedStatement 객체 생성
            // Connection 인터페이스의 prepareStatement() 메소드를 사용하여 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,prdName);
            pstmt.setInt(2,prdPrice);
            pstmt.setString(3,prdMaker);
            pstmt.setString(4,prdColor);
            pstmt.setInt(5,ctgNo);
            pstmt.setString(6,prdNo);

            // 쿼리문 실행 : 영향을 받은 행의 수 반환
            // select : executeQuery() - 결과 행 ResultSet반환
            // insert / update / delete : executeUadate() - 영향을 받은 행의 수 반환
            int result = pstmt.executeUpdate();

            // Connection 객체가 생성되면 DB 연결 성공
            if(result > 0) {
                System.out.println("데이터 수정 성공!");
            }

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
