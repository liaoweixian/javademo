package demo.designmode;

/**
 * 原型模式
 */
public class Prototype implements Cloneable
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Prototype{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    public static void main(String[] args) {
        Prototype value = new Prototype();
        value.setName("就是这个");
        Prototype clonePrototype = (Prototype)value.clone();
        value.setName("就是那个");
        System.out.println("prototype:");
        System.out.println(value);
        System.out.println("clone");
        System.out.println(clonePrototype);
    }
}
