package demo.designmode;

/**
 * 适配器模式
 */
interface BigProt
{
    void userBigProt();
}

interface SmallProt
{
    void userSmallProt();
}

class SmallToBig implements BigProt
{
    private SmallProt smallProt ;

    public SmallToBig(SmallProt smallProt)
    {
        this.smallProt = smallProt;
    }

    @Override
    public void userBigProt() {
        this.smallProt.userSmallProt();
    }
}

public class Adapter
{
    public static void main(String[] args)
    {
        SmallProt smallProt  =  ()->{
            System.out.println("使用的是电脑小口");
        };
        BigProt bigProt  = new SmallToBig(smallProt);
        bigProt.userBigProt();
    }
}
