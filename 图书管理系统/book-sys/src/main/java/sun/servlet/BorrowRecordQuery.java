package sun.servlet;

import sun.dao.BorrowRecordDAO;
import sun.model.BorrowRecord;
import sun.model.Page;
import sun.util.Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/borrowRecord/query")
public class BorrowRecordQuery extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //url中的请求数据，通过getparameter获取
        Page p= Util.parse(req);
        List<BorrowRecord> records=BorrowRecordDAO.query(p);
        return records;
    }
}
