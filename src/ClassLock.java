/**
 * Created by chenwenping on 17/4/14.
 */
public class ClassLock {

    //同步class对象，类锁
    public void syncClassMethod() {
        synchronized (ClassLock.class) {

        }
    }
    //同步静态方法、类锁
    public static synchronized void synStaticMethod() {

    }
}
