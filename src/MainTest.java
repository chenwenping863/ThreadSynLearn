import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chenwenping on 17/4/15.
 */
public class MainTest {
    public static void main(String[] args) {
        //子线程

        Lock lock = new ReentrantLock();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i ++) {
                    synchronized (lock) {
                        for (int j = 0; j < 10; i ++) {
                            System.out.print("子线程循环第" + (j + 1) + "次\n");
                        }
                        //唤醒
                        lock.notify();
                        //等待
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("子线程循环第" + (i + 1) + "次\n");
                }
            }
        }.start();

        //主线程

        for (int i = 0; i < 50; i ++) {
            synchronized (lock) {
                //等待
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 15; j ++) {
                    System.out.print("主线程循环第" + (j + 1) + "次\n");
                }

                //唤醒
                lock.notify();


            }

            System.out.print("主线程循环第" + (i + 1) + "次\n");
        }


    }
}
