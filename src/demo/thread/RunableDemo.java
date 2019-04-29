package demo.thread;

public class RunableDemo implements Runnable
{
    private static Integer index = 0;

    @Override
    public void run()
    {
        try {
            Thread.sleep(1000);
            index++;
            System.out.println(index);
            Thread thread = new Thread(this);
            if (index != 5)
            {
                thread.start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
