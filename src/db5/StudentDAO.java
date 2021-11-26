package db3;

//(1) 생성자에서 DB 연결
//(2) selectStudent() 메서드 : 데이터베이스의 student 테이블에서 select 한 결과 출력
//(3) insertStudent(StudentDTO dto) 메서드
//		- main()에서 입력한 student 데이터를 전달 받아서
//   - student 테이블에 insert 작업 수행

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class StudentDAO {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 생성자 : 데이터베이스 연결
    public StudentDAO() {
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

    //(2) selectStudent() 메서드
    public void selectStudent() {

        try {
            // sql 직성
            String sql = "select * from student order by stdNo";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);

            while(rs.next()) {
                String stdNo = rs.getString(1);
                String stdName = rs.getString(2);
                int stdYear = rs.getInt(3);
                String stdAddress = rs.getString(4);
                Date stdBirthday = rs.getDate(5);
                String dptNo = rs.getString(6);

                System.out.format("%-10s\t %-10s\t %-4d %-20s %13s %5s\n",
                        stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
            }

        } catch (Exception e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }
    }

    //(3) insertStudent(StudentDTO dto)
    public void insertStudent(StudentDTO dto) {
        try {
            // sql문 작성
            String sql = "insert into student values(?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dto.getStdNo());
            pstmt.setString(2,dto.getStdName());
            pstmt.setInt(3,dto.getStdYear());
            pstmt.setString(4,dto.getStdAddress());
            pstmt.setString(5,dto.getStdBirthday());
            pstmt.setString(6,dto.getDptNo());
            
            int result = pstmt.executeUpdate();
            
            if(result > 0) System.out.println("데이터 입력 성공");
            
        } catch (Exception e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }
    }
    public void updateStudent(StudentDTO dto){
        try {
            // sql문 작성
            String sql = "update student set stdName=?, stdYear=?, stdAddress=?, stdBirthday=?, dptNo=? where stdNo=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dto.getStdName());
            pstmt.setInt(2,dto.getStdYear());
            pstmt.setString(3,dto.getStdAddress());
            pstmt.setString(4,dto.getStdBirthday());
            pstmt.setString(5,dto.getDptNo());
            pstmt.setString(6,dto.getStdNo());

            int result = pstmt.executeUpdate();

            if(result > 0) System.out.println("데이터 수정 성공");

        } catch (Exception e) {
            System.out.println("오류 발생");
            e.printStackTrace();
        }
    }

    public void deleteStudent(StudentDTO dto){
        try {
            // SQL 작성
            String sql = "delete from student where stdNo=?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dto.getStdNo());

            int result = pstmt.executeUpdate();

            if(result > 0) System.out.println("데이터 삭제 성공");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
