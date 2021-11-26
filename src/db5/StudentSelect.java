package db5;

public class StudentSelect {
    public void studentSelect(){
        StudentDAO stdDAO = new StudentDAO();

        stdDAO.selectStudent();
    }
}
