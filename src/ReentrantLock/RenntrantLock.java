package ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenwenping on 17/4/14.
 */
public class RenntrantLock {

    /**
     * 使用ReentrantLock的一般组合是lock与unlock成对出现的，
     * 需要注意的是，千万不要忘记调用unlock来释放锁，否则可能会引发死锁等问题。
     * 如果忘记了在finally块中释放锁，可能会在程序中留下一个定时炸弹，随时都会炸了，
     * 而是用synchronized，JVM将确保锁会获得自动释放，
     * 这也是为什么Lock没有完全替代掉synchronized的原因
     * */
    private Lock lock = new ReentrantLock();


    private void doSth() {
        lock.lock();
        try {
            //执行线程同步的操作
        } finally {
            lock.unlock();
        }
    }
}
