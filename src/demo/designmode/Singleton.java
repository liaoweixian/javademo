package demo.designmode;

/**
 * 单例模式
 */
public class Singleton {
    private Singleton(){}

    private static class  SingletomBuild
    {
        private static Singleton value = new Singleton();
    }

    public static Singleton getInstance()
    {
        return SingletomBuild.value;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().getClass().getName());
    }

}
