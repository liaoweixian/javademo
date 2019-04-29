package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test
{
    public static void main(String[] args)
    {

    }


    public static void demo1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends Student> aClass = Student.class;
        Constructor<? extends Student> constructor = aClass.getConstructor(new Class[]{int.class, String.class});
        System.out.println(constructor.getName());
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes.length > 0)
        {
            for (int i = 0; i < parameterTypes.length; i++)
            {
                System.out.println(parameterTypes[i]);
            }
        }
        Student student = constructor.newInstance(new Object[]{1, "name"});
        System.out.println(student);
    }

    public static void fieldDemo()
    {
        try {
            Class<?> aClass = Class.forName("demo.reflect.Student");
            Student stu = (Student)aClass.newInstance();
            Field name = aClass.getDeclaredField("name");
            System.out.println(name);
            System.out.println(name.getName());
            name.setAccessible(true);
            name.set(stu,"就是这个");
            Object o = name.get(stu);
            System.out.println(o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void  fieldDemo2()
    {
        Class<Student> clas = Student.class;
        Field[] declaredFields = clas.getDeclaredFields();
        for( Field field : declaredFields)
        {
            System.out.println(field.toString());
        }

        try
        {
            Constructor<Student> constructor = clas.getConstructor(new Class[]{int.class, String.class});
            Student student = constructor.newInstance(new Object[]{1, "哈哈"});
            System.out.println(student);
            for( Field field : declaredFields)
            {
                field.setAccessible(true);
                if (field.getType() == String.class)
                {
                    field.set(student,"就是这个");
                }
                else
                {
                    field.set(student,2);
                }
                System.out.println(student);
            }
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
