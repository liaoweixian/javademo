package demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {

    public static void main(String[] args)
    {

    }


    public static void callAbleDemo()
    {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> callableDemoFutureTask = new FutureTask<Integer>(callableDemo);
        Thread thread = new Thread(callableDemoFutureTask);
        thread.start();
        try {
            System.out.println(callableDemoFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void runableDemo()
    {
        RunableDemo runableDemo = new RunableDemo();
        Thread thread = new Thread(runableDemo);
        thread.start();
    }

    public static void threadDemo()
    {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        try {
            threadDemo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.activeCount());
    }
}
