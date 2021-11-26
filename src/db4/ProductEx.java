package db4;

import java.util.Scanner;

public class ProductEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductDAO prdDAO = new ProductDAO();

        // 학생 데이터 입력: stdentDAO 클래스의 insertStudetn() 메서드 호출
        System.out.println("상품 정보 등록");
        System.out.println("-------------------------\n");

        System.out.print("상품 번호 입력: ");
        String prdNo = scan.nextLine();

        System.out.print("상품명 입력: ");
        String prdName = scan.nextLine();

        System.out.print("상품 가격 입력: ");
        int prdPrice = scan.nextInt();

        scan.nextLine();

        System.out.print("상품 브랜드 입력: ");
        String prdMaker = scan.nextLine();

        System.out.print("상품 색깔 입력: ");
        String prdColor = scan.nextLine();

        System.out.print("카테고리 번호 입력: ");
        int ctgNo = scan.nextInt();

        ProductDTO prdDTO = new ProductDTO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
        prdDAO.insertProduct(prdDTO);
        prdDAO.selectProduct();
    }
}
