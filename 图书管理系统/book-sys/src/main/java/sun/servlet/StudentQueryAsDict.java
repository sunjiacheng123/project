package sun.servlet;

import sun.dao.StudentDAO;
import sun.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/student/queryAsDict")
public class StudentQueryAsDict extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id=Integer.parseInt(req.getParameter("dictionaryKey"));
        List<Student> student= StudentDAO.queryAsDict(id);
        return student;
    }
}
