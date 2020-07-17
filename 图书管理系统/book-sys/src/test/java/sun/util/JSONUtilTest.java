package sun.util;

import org.junit.Assert;
import org.junit.Test;
import sun.model.ResponsResult;

import java.io.InputStream;

public class JSONUtilTest {
    @Test
    public void testRead(){
        InputStream is=getClass().getClassLoader().getResourceAsStream("response.json");
        ResponsResult r=JSONUtil.read(is,ResponsResult.class);
        System.out.println(r);
        Assert.assertNotNull(r);
    }


    @Test
    public void testWrite(){
        ResponsResult r=new ResponsResult();
        r.setCode("K3000");
        r.setSuccess(true);
        r.setTotal(9);
        String s=JSONUtil.write(r);
        System.out.println(s);
        Assert.assertNotNull(s);
        //trim():去除前后空格
        Assert.assertTrue(s.trim().length()>0);
    }
}
