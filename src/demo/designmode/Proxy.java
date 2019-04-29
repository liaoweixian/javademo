package demo.designmode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * spring 动态代理是使用cglib的jar进行代理的 现在这个代理只有实现了最小一个接口才能使用
 */

interface IUserDao
{
    void save();
}

class UserDao implements IUserDao
{
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}

class ProxyFactory
{
    private Object target;

    public ProxyFactory(Object target)
    {
        this.target = target;
    }
    public Object  getProxyInstance()
    {
        Class cla = target.getClass();
        return java.lang.reflect.Proxy.newProxyInstance(cla.getClassLoader(), cla.getInterfaces(), new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("这是开始");
                Object obj = method.invoke(target,args);
                System.out.println("这是结束");
                return obj;

            }
        });
    }
}

public class Proxy
{

    public static void main(String[] args)
    {
        IUserDao iUserDao = new UserDao();
        System.out.println(iUserDao.getClass());
        ProxyFactory proxyFactory  = new ProxyFactory(iUserDao);
        IUserDao proxy =  (IUserDao) proxyFactory.getProxyInstance();
        proxy.save();
    }
}
