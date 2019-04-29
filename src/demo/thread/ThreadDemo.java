package demo.thread;

public class ThreadDemo extends Thread {

    private static final Integer i = 1;

    private static Integer index =0;

    @Override
    public void run()
    {
        /*synchronized (i)
        {
            System.out.println(Thread.currentThread().getName()+"进来了");
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        try {
            Thread.sleep(1000);
            index++;
            System.out.println(index);
            Thread thread = new Thread(this);
            if (index != 5)
            {
                //Thread.currentThread().interrupt();
                thread.start();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
