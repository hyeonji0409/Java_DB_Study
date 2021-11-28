package db5;

import db3.StudentDAO;

public class StudentSelect {
    public void studentSelect(){
        StudentDAO stdDAO = new StudentDAO();

        stdDAO.selectStudent();
    }
}
