###http://blog.csdn.net/qq_30379689/article/details/53863082#a
    
    
    synchronized关键字可以理解为一个锁，
    而锁就需要被锁的东西，
    所以synchronized又分为类锁和对象锁，
    即可以锁类又可以锁对象，
    它们共同的作用就是保证线程的同步
    
###对象锁和类锁
    
    对象锁是用于对象实例方法，
    或者一个对象实例上的，
    类锁是用于类的静态方法或者一个类的class对象上的。
    
    类的对象实例可以有很多个，
    但是每个类只有一个class对象，
    所以，结论是：
    1、不同对象实例的对象锁是互不干扰的，但是每个类只有一个类锁。
    2、而且类锁和对象锁互相不干扰。
    
###1、不同对象实例的对象锁是互不干扰的，但是每个类只有一个类锁。
###2、而且类锁和对象锁互相不干扰。




