package sun.dao;

import sun.exception.SystemException;
import sun.model.Classes;
import sun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassesDAO {
    public static List<Classes> queryAsDict() {
        List<Classes> classesList=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DBUtil.getConnection();
            String sql="select id, classes_name, classes_graduate_year, classes_major from classes";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Classes classes=new Classes();
                classes.setDictionaryTagKey(rs.getString("id"));
                classes.setDictionaryTagValue(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classesList.add(classes);
            }
        }catch (Exception e){
            throw new SystemException("00003","查询班级数据字典信息出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }

        return classesList;
    }
}
