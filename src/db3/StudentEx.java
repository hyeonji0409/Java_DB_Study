package db3;

import java.util.Scanner;

public class StudentEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // DAO 객체 생성하면서 DB 연결
        // 객체 생성될 때 생성자 호출되면서 DB 연결
        StudentDAO stdDAO = new StudentDAO();

        // 학생 데이터 입력: stdentDAO 클래스의 insertStudetn() 메서드 호출
        System.out.println("학생 정보 등록");
        System.out.println("-------------------------\n");

        System.out.print("학번 입력: ");
        String stdNo = scan.nextLine();

        System.out.print("이름 입력: ");
        String stdName = scan.nextLine();

        System.out.print("학년 입력: ");
        int stdYear = scan.nextInt();

        scan.nextLine();

        System.out.print("주소 입력: ");
        String stdAddress = scan.nextLine();

        System.out.print("생일 입력: ");
        String stdBirthday = scan.nextLine();

        System.out.print("학과번호 입력: ");
        String dptNo = scan.nextLine();

        // StudentDTO 객체 생성
        // 생성과 동시에 갑 저장: 생성자 호출하면서 값 전달
        StudentDTO stdDTO = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);

        stdDAO.insertStudent(stdDTO);

        // 학생 정보 조회 : StudentDAO 클래스의 selectStudent() 메서드 호출하면서 stdDTO 전달


        //객체.메서드
        stdDAO.selectStudent();
    }
}
