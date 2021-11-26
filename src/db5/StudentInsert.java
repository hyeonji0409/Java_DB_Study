package db5;

import java.util.Scanner;

public class StudentInsert {
    public void studentInsert(){
        Scanner scan = new Scanner(System.in);
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

        StudentDTO stdDTO = new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
        stdDAO.insertStudent(stdDTO);
    }
}
