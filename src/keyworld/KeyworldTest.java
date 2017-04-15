package keyworld;

/**
 * Created by chenwenping on 17/4/14.
 */
public class KeyworldTest {

    private static Object lockObject = new Object();

    public static void main(String[] args) {

        System.out.print("主线程运行\n");

        //创建子线程
        Thread thread = new WaitThread();
        thread.start();

        long start = System.currentTimeMillis();
        synchronized (lockObject) {
            try {
                System.out.print("主线程等待\n");
                lockObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("主线程继续 --》等待的时间：" + (System.currentTimeMillis() - start) + "\n");
        }

    }

    static class WaitThread extends Thread {
        @Override
        public void run() {
            synchronized (lockObject) {
                //子线程等待了2秒钟后，唤醒lockObject锁
                try {
                    Thread.sleep(2000);
                    lockObject.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
