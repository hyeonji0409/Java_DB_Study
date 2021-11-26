package db3;

public class StudentDTO {
    private String stdNo;
    private String stdName;
    private int stdYear;
    private String stdAddress;
    private String stdBirthday;
    private String dptNo;

    // 매개변수가 있는 생성자
    // 생성자는 StudentDTO 클래스 객체가 생성될 때 자동으로 호출되면서
    // 생성자의 매개변수 값을 받음
    public StudentDTO(String stdNo, String stdName, int stdYear, String stdAddress, String stdBirthday, String dptNo){
        this.stdNo = stdNo;
        this.stdName = stdName;
        this.stdYear = stdYear;
        this.stdAddress = stdAddress;
        this.stdBirthday = stdBirthday;
        this.dptNo = dptNo;
    }

    // getter/setter 생성
    // get: 멤버변수의 값을 반환해줄 때 사용
    // set: 멤버변수에 값을 저장할 때 사용
    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdYear() {
        return stdYear;
    }

    public void setStdYear(int stdYear) {
        this.stdYear = stdYear;
    }

    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    public String getStdBirthday() {
        return stdBirthday;
    }

    public void setStdBirthday(String stdBirthday) {
        this.stdBirthday = stdBirthday;
    }

    public String getDptNo() {
        return dptNo;
    }

    public void setDptNo(String dptNo) {
        this.dptNo = dptNo;
    }


}
