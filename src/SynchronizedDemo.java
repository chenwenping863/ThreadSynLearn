/**
 * Created by chenwenping on 17/4/14.
 */
public class SynchronizedDemo {

    /*
    * 1、不同对象实例的对象锁是互不干扰的，但是每个类只有一个类锁。2、而且类锁和对象锁互相不干扰。
    * */
    private int ticket = 10;

    //同步方法，对象锁
    public synchronized void syncMethod() {
        for (int i = 0; i < 1000; i ++) {
            ticket --;
            System.out.print(Thread.currentThread().getName() + "-剩余的票数:" + ticket + "\n");
        }
    }

    //同步块，对象锁
    public void syncThis() {
        synchronized (this) {
            for (int i = 0; i < 1000; i ++) {
                ticket --;
                System.out.print(Thread.currentThread().getName() + "-剩余的票数:" + ticket+ "\n");
            }
        }
    }

    //同步class对象、类锁
    public void syncClassMethod() {
        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i < 1000; i ++) {
                ticket --;
                System.out.print(Thread.currentThread().getName() + "-剩余的票数:" + ticket+ "\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(Thread.currentThread().getName() + "\n");

        /*SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        new Thread() {
            @Override
            public void run() {
                synchronizedDemo.syncMethod();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronizedDemo.syncThis();
            }
        }.start();*/
        //由于使用的是同一个对象的对象锁，所以执行出来的结果是同步的（

        /*SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
        SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();

        new Thread() {
            @Override
            public void run() {
                synchronizedDemo1.syncMethod();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronizedDemo2.syncMethod();
            }
        }.start();*/
        //由于是不同对象，所以执行的对象锁都不是不同的，其结果是两个线程互相抢占资源的运行，即ticket偶尔会无序的减少


        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        new Thread() {
            @Override
            public void run() {
                synchronizedDemo.syncMethod();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronizedDemo.syncClassMethod();
            }
        }.start();

        //由于对象锁和类锁互不干扰，所以也是线程不安全的
    }

}
