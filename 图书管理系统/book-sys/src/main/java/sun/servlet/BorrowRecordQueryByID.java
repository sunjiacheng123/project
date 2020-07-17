package sun.servlet;

import sun.dao.BorrowRecordDAO;
import sun.model.BorrowRecord;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrowRecord/queryById")
public class BorrowRecordQueryByID extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取图书借阅记录的id
        int id=Integer.parseInt(req.getParameter("id"));
        BorrowRecord record= BorrowRecordDAO.queryById(id);
        return record;
    }
}
