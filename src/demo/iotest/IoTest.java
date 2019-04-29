package demo.iotest;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class IoTest
{
    {
        try
        {
            FileOutputStream fos  = new FileOutputStream("F://test.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.append("中文写入");
            osw.append("/r/n");
            osw.append("English");
            osw.flush();
            osw.close();
            fos.close();
            FileInputStream fis = new FileInputStream("F://test.txt");
            InputStreamReader isr = new InputStreamReader(fis,StandardCharsets.UTF_8);
            StringBuffer buffer = new StringBuffer();
            char[] ch= new char[1024];
            while (isr.ready()) {
                buffer.append(isr.read());
            }

            fis.close();
            isr.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void FileWriter ()
    {

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("F://test.txt");
            fw = new FileWriter("E://test.txt");
            char[] ch = new char[1024];
            int i = 0;
            while ((i=fr.read(ch)) != -1)
            {
                fw.write(ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void reflectConstructor () throws Exception
    {
        Class<?> cla = Class.forName("demo.iotest.Student");
        Class[] o = new Class[1];
        o[0] = String.class;
        Constructor<?> constructor = cla.getConstructor(o);
        Object[] parameters={"haha"};
        Student student = (Student) constructor.newInstance(parameters);
        System.out.println(student);
    }

    public static void assignment() throws Exception
    {
        Class<?> cla = Class.forName("demo.iotest.Student");
        Field setName = cla.getDeclaredField("name");
        setName.setAccessible(true);
        Student student = (Student)cla.newInstance();
        setName.set(student,"就是这个");
        System.out.println(student);
    }

    public static void getOrSet() throws Exception
    {
        Class<?> cla = Class.forName("demo.iotest.Student");
        Method setName = cla.getMethod("setName", String.class);
        Student student = (Student)cla.newInstance();
        setName.invoke(student,"fdafdsaf");
        System.out.println(student);
    }


    public static void  streamSaveFile(Object obj) throws Exception
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("F://test.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
            objectOutputStream.close();
        }


    }


    public static Object actionSequence() throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("F://test.txt");
            in = new ObjectInputStream(fin);
            Object object = in.readObject();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
            fin.close();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        /*Student student = new Student("哈哈就是这个");
        IoTest.streamSaveFile(student);

       Student stud = (Student) IoTest.actionSequence();
        System.out.println(stud);*/


        Student student = new Student("哈哈就是这个");



    }
}
