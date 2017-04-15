package keyworld;

/**
 * Created by chenwenping on 17/4/15.
 */
public class YieldTest {

    /*
    * yield()会礼让给相同优先级的或者是优先级更高的线程执行，
    * 不过yield()这个方法只是把线程的执行状态打回准备就绪状态，
    * 所以执行了该方法后，有可能马上又开始运行，有可能等待很长时间
    * */


    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("thread-1");
        MyThread myThread2 = new MyThread("thread-2");

        myThread1.start();
        myThread2.start();

    }

    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 100; i ++) {
                System.out.print(getName() + "在运行，i的值为：" + i + " 优先级为：" + getPriority() + "\n");
                if (i == 2) {
                    System.out.print(getName() + "礼让\n");
                    Thread.yield();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
