package sun.servlet;

import sun.dao.ClassesDAO;
import sun.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/classes/queryAsDict")
public class ClassesQueryAsict extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Classes> classesList= ClassesDAO.queryAsDict();
        return classesList;
    }
}
