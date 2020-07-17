package sun.servlet;

import sun.dao.BorrowRecordDAO;
import sun.exception.BusinessException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrowRecord/delete")
public class BorrowRecordDeleteServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids=req.getParameterValues("ids");
        int num= BorrowRecordDAO.delete(ids);
        if(num!=1){
            throw new BusinessException("00008","删除图书借阅信息数量异常");
        }
        return null;
    }
}
