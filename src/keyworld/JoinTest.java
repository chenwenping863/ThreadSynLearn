package keyworld;

/**
 * Created by chenwenping on 17/4/15.
 */
public class JoinTest {

    /*
    * join()作用是让指定的线程先执行完再执行其他线程，而且会阻塞主线程，
    * */

    public static void main(String[] args) {

    //线程1

        long startTime = System.currentTimeMillis();

        MyThread myThread1 = new MyThread("thread-1");
        myThread1.start();
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("主线程需要等待\n");



        MyThread myThread2 = new MyThread("thread-2");
        myThread2.start();
        try {
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(System.currentTimeMillis() - startTime);
        System.out.print("主线程继续执行\n");


    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.print(getName() + "正在运行\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
