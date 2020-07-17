package sun.util;

public class CountHolder {
    private static final ThreadLocal <Integer> COUNT=new ThreadLocal<>();
    //1.可以之间返回threadlocal
    //2.简易提供get，set，remove
    public static void set(Integer count){
        COUNT.set(count);
    }
    public static Integer get(){
        return COUNT.get();
    }

    public static void remove(){
        COUNT.remove();
    }

}
