package db4;

public class ProductDTO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdMaker;
    private String prdColor;
    private int ctgNo;


    public ProductDTO(String prdNo, String prdName, int prdPrice, String prdMaker, String prdColor, int ctgNo) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdMaker = prdMaker;
        this.prdColor = prdColor;
        this.ctgNo = ctgNo;
    }

    public String getPrdNo() {
        return prdNo;
    }

    public void setPrdNo(String prdNo) {
        this.prdNo = prdNo;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public int getPrdPrice() {
        return prdPrice;
    }

    public void setPrdPrice(int prdPrice) {
        this.prdPrice = prdPrice;
    }

    public String getPrdMaker() {
        return prdMaker;
    }

    public void setPrdMaker(String prdMaker) {
        this.prdMaker = prdMaker;
    }

    public String getPrdColor() {
        return prdColor;
    }

    public void setPrdColor(String prdColor) {
        this.prdColor = prdColor;
    }

    public int getCtgNo() {
        return ctgNo;
    }

    public void setCtgNo(int ctgNo) {
        this.ctgNo = ctgNo;
    }
}
