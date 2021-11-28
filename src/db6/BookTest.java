import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();

        System.out.println("책 정보 등록");
        System.out.println("-------------------------\n");

        System.out.print("책번호 입력: ");
        String bookNo = scan.nextLine();

        System.out.print("책 제목 입력: ");
        String bookTitle = scan.nextLine();

        System.out.print("저자 입력: ");
        String bookAuthor = scan.nextLine();

        System.out.print("발행년도 입력: ");
        int bookYear = scan.nextInt();

        scan.nextLine();

        System.out.print("가격 입력: ");
        int bookPrice = scan.nextInt();

        scan.nextLine();

        System.out.print("출판사명 입력: ");
        String bookPublisher = scan.nextLine();

        BookDTO bookDTO = new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
        bookDAO.insertBook(bookDTO);
        bookDAO.selectBook();
    }
}
