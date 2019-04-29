package demo.designmode;

/**
 * 工厂模式
 */
interface Food{}

class A implements Food
{

}

class B implements Food
{

}

class C implements Food
{

}

class  StaticFactory
{
    private StaticFactory(){}

    public static Food getA()
    {
        return new A();
    }

    public static Food getB()
    {
        return new B();
    }

    public static Food getC()
    {
        return new C();
    }

}

class Client
{
    public void get(String name)
    {
        name = name.toUpperCase();
        Food food = null;
        switch (name)
        {
            case "A": food = StaticFactory.getA();  break;
            case "B": food = StaticFactory.getB();  break;
            case "C": food = StaticFactory.getC(); break;
        }
        System.out.println(food.getClass().getName());
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        Client client = new Client();
        client.get("a");
    }
}

