package sun.util;

import org.junit.Assert;
import org.junit.Test;

public class DBUtilTest {
//测试数据库链接是否正常
    @Test
    public void test(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
