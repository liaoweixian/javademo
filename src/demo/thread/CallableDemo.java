package demo.thread;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println("进来了");
        return 1;
    }
}
