package demo.designmode;

/**
 * 抽象工厂
 */
interface AbstractFood
{

}

class AbstractA implements AbstractFood
{

}

class AbstractB implements AbstractFood
{

}

class AbstractC implements AbstractFood
{

}

interface Produce
{
    AbstractFood get();
}

class FactoryForA implements Produce
{
    @Override
    public AbstractFood get() {
        return new AbstractA();
    }
}

class FactoryForB implements Produce
{
    @Override
    public AbstractFood get()
    {
        return new AbstractB();
    }
}

class FactoryForC implements Produce
{
    @Override
    public AbstractFood get()
    {
        return new AbstractC();
    }
}



public class AbStractFactory
{
    public static void main(String[] args)
    {
        Produce produce = new FactoryForA();
        AbstractFood food = produce.get();
        System.out.println(food.getClass().getName());
    }
}
