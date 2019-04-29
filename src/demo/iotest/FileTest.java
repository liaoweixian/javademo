package demo.iotest;

import java.io.File;
import java.io.IOException;

public class FileTest
{

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\test.txt");
        System.out.println("canExecute:"+file.canExecute());
        System.out.println("canRead:"+file.canRead());
        System.out.println("canWrite:"+file.canWrite());
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.equals(new File("F:\\test.txt")));
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getName());
        File[] arrayFile = File.listRoots();
        for (File f : arrayFile)
        {
            System.out.println(f.getPath());
        }
       /* File file2 = new File("F:\\test1.txt");
        System.out.println(file2.createNewFile());*/
    }
}
