package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 콘솔에서 데이터 입력 받아서 도서테이블에 저장
public class BookInsertInputEx {
    public static void main(String[] args) {
        // 입력
        Scanner scan = new Scanner(System.in);

        // 데이터 입력
        System.out.println("도서 정보 등록");
        System.out.println("-------------------------\n");

        System.out.print("도서번호 입력: ");
        String bookNo = scan.nextLine();

        System.out.print("도서명 입력: ");
        String bookName = scan.nextLine();

        System.out.print("저자 입력: ");
        String bookAuthor = scan.nextLine();

        System.out.print("가격 입력: ");
        int bookPrice = scan.nextInt();

        // 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어들임
        scan.nextLine();

        System.out.print("발행일 입력: ");
        String bookDate = scan.nextLine();

        System.out.print("재고 입력: ");
        int bookStock = scan.nextInt();

        // 앞의 엔터 값이 다음 변수에 들어가지 않도록 읽어들임
        scan.nextLine();

        System.out.print("출판사 번호 입력: ");
        String pubNo = scan.nextLine();;

        // DB 연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/sqldb3?serverTimezone=UTC";
            String user = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url, user, pwd);

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
            scan.close();

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }

        // DB에 저장

    }
}
