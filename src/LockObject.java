/**
 * Created by chenwenping on 17/4/14.
 */
public class LockObject {
    //同步方法，对象锁
    public synchronized void syncMethod() {

    }
    //同步块、对象锁
    public void synThis() {
        synchronized (this) {

        }
    }


}
