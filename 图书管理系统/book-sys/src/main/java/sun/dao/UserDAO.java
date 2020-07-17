package sun.dao;

import sun.exception.SystemException;
import sun.model.User;
import sun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public static User query(User user) {
        User queryuser=null;
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c= DBUtil.getConnection();
            String sql="select id, username, password, nickname from user where username=? and password=?";
            ps=c.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            while (rs.next()){
                queryuser=user;
                queryuser.setId(rs.getInt("id"));
                queryuser.setNickname(rs.getString("nickname"));
            }
        }catch (Exception e){
            throw new SystemException("00007","用户登录校验数据库查询信息出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }

        return queryuser;
    }
}
