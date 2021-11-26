package db4;

import db3.StudentDTO;

import java.sql.*;
import java.util.Date;

public class ProductDAO {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ProductDAO(){
        try {
            //JDBC Driver 클래스의 객체 생성 런타임시 로드
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 주소, 사용자 계정, 패스워드 문자열 설정
            String url = "jdbc:mysql://localhost:3306/sqldb2?serverTimezone=UTC";
            String user = "root";
            String pwd = "1234";

            // DB 연결하기 위한 객체 생성
            // DriverManager를 통해 Connection 객체 생성
            // MySQL 서버 연결 : 주소, 사용자 계정, 패스워드 전송
            con = DriverManager.getConnection(url, user, pwd);

            // Connection 객체가 생성되면 DB 연결 성공
            if(con != null) {
                System.out.println("DB 연결 성공!");
            }

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }

    public void selectProduct() {
        try {
            String sql = "select * from product order by prdNo";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);

            while(rs.next()) {
                String prdNo = rs.getString(1);
                String prdName = rs.getString(2);
                int prdPrice = rs.getInt(3);
                String prdMaker = rs.getString(4);
                String prdColor = rs.getString(5);
                int ctgNo = rs.getInt(6);

                System.out.format("%-10s\t %-10s\t %-4d %-20s %13s %5d\n",
                        prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(ProductDTO dto) {
        try {
            // sql문 작성
            String sql = "insert into product values(?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dto.getPrdNo());
            pstmt.setString(2,dto.getPrdName());
            pstmt.setInt(3,dto.getPrdPrice());
            pstmt.setString(4,dto.getPrdMaker());
            pstmt.setString(5,dto.getPrdColor());
            pstmt.setInt(6,dto.getCtgNo());

            int result = pstmt.executeUpdate();

            if(result > 0) System.out.println("데이터 입력 성공");

        } catch (Exception e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }
    }
}
