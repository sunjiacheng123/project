package sun.servlet;

import sun.dao.BorrowRecordDAO;
import sun.exception.BusinessException;
import sun.model.BorrowRecord;
import sun.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrowRecord/update")
public class BorrowRecordUpdateServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        BorrowRecord record= JSONUtil.read(req.getInputStream(),BorrowRecord.class);
        int num= BorrowRecordDAO.update(record);
        if(num!=1){
            throw new BusinessException("00008","更新图书借阅信息数量异常");
        }
        return null;
    }
}
