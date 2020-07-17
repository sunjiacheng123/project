package sun.servlet;

import sun.dao.DictionaryRagDAO;
import sun.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/dict/tag/query")
public class DictionaryTagQuery extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key=req.getParameter("dictionaryKey");
        List<DictionaryTag> tags= DictionaryRagDAO.query(key);
        return tags;
    }
}
