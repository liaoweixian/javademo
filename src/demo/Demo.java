package demo;

import demo.iotest.Student;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Demo
{
    public static void main(String[] args) throws UnsupportedEncodingException {
        HashMap<String, Student> keyOrStudent = new HashMap<>();
        keyOrStudent.put(null,null);
        keyOrStudent.put("0",null);
        keyOrStudent.put("1",null);
        keyOrStudent.put("2",null);
        System.out.println(keyOrStudent);

        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put(null,"qwe");
        System.out.println(stringStringHashtable);
    }
}
