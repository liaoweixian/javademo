package demo.designmode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DemoReentrantLock {


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        reentrantLock.lock();
        System.out.println("--------------");
        try {
            condition.await(10, TimeUnit.SECONDS);
            System.out.println("1111111111111111111111111");
            reentrantLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void t1(ReentrantLock lock)
    {
        System.out.println();
    }
}
