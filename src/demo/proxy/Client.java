package demo.proxy;

import java.lang.reflect.Proxy;

public class Client
{
    public static void main(String[] args)
    {
        RealSubject realSubject = new RealSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);
        Subject subject = (Subject)Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),dynamicProxy);
        System.out.println(subject.getClass().getName());
        subject.rent();
        //subject.hello("world");
    }
}
