package db5;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("\t 학생 관리 프로그램\t");
        System.out.println("------------------------------");
        System.out.println("\t 다음 메뉴에서 선택\t");
        System.out.println("------------------------------");
        System.out.println("1. 학생 등록");
        System.out.println("2. 학생 정보 조회");
        System.out.println("3. 학생 정보 수정");
        System.out.println("4. 학생 정보 삭제");
        System.out.println("5. 종료");
        System.out.println("------------------------------");

        System.out.print("메뉴 번호 입력: ");
        int num = scan.nextInt();
        scan.nextLine();
        switch (num){
            case 1:
                StudentInsert stdInsert = new StudentInsert();
                stdInsert.studentInsert();
                break;
            case 2:
                StudentSelect stdSelect = new StudentSelect();
                stdSelect.studentSelect();
                break;
            case 3:
                StudentUpdate stdUpdate = new StudentUpdate();
                stdUpdate.studentUpdate();
                break;
            case 4:
                StudentDelete stdDelete = new StudentDelete();
                stdDelete.studentDelete();
            default:
                System.out.println("입력값 오류");
        }

    }
}
