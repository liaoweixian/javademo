package demo.designmode;

import demo.designmode.model.Student;
import javafx.scene.input.DataFormat;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo {

    public static void main(String[] args) {
        //Demo.demoArrayList();
        //Demo.demoLinkedList();
        //Demo.demoHashSet();
        //Demo.demoHashMap();
        /*DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);

        Date date = new Date();
        System.out.println(dateInstance.format(date.getYear()));*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH + 1));
        System.out.println(instance.get(Calendar.SECOND));
        System.out.println(simpleDateFormat.format(instance.getTime()));

        String str = "2019-05-06 00:00:00";
        Date parse = null;
        try {
             parse = simpleDateFormat.parse(str);
            System.out.println(simpleDateFormat.format(parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Timestamp timestamp = new Timestamp();
        Timestamp timestamp = Timestamp.valueOf("2019-05-06 00:00:00");
        System.out.println(timestamp);
        System.out.println(timestamp.compareTo(parse));

        Calendar instance1 = Calendar.getInstance();

        System.out.println(instance1.getWeekYear());
        System.out.println(instance1.getWeeksInWeekYear());

        System.out.println(instance1.getActualMaximum(Calendar.DATE));
        System.out.println(instance1.getActualMinimum(Calendar.DATE));

        instance1.add(Calendar.MONTH,-1);
        System.out.println(instance1.getActualMaximum(Calendar.DATE));

        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        TimeZone.setDefault(timeZone);

    }

    public static void demoArrayList()
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("q");
        arrayList.add("w");
        arrayList.add("e");
        arrayList.add("r");
        arrayList.add("q");
        arrayList.add("a");
        arrayList.add(2,"t");

        Set<String> hashSet = new HashSet<String>();
        hashSet.add("a");
        hashSet.add("s");
        hashSet.add("d");
        hashSet.add("f");

        arrayList.addAll(hashSet);
        arrayList.addAll(0,hashSet);

        System.out.println("contains:"+arrayList.contains("q"));

        System.out.println("containsAll:"+arrayList.containsAll(hashSet));

        System.out.println("get:"+arrayList.get(0));

        System.out.println("hashCode:"+arrayList.hashCode());

        System.out.println("indexOf:"+arrayList.indexOf("q"));

        System.out.println("isEmpty:"+arrayList.isEmpty());

        System.out.println("打印：");

        System.out.println(arrayList);

        for (String str : arrayList) {
            System.out.println(str);
        }

        System.out.println("lastIndexOf:"+arrayList.lastIndexOf("f"));

        System.out.println("listIterator:------------");
        ListIterator<String> stringListIterator = arrayList.listIterator();
        while (stringListIterator.hasNext())
        {
            System.out.println(stringListIterator.next());
        }
        System.out.println("stringListIterator--pre------");

        while (stringListIterator.hasPrevious())
        {
            System.out.println(stringListIterator.previous());
        }

        if (arrayList.removeAll(hashSet))
        {
            System.out.println(arrayList);
        }
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add("q");
        if (arrayList.retainAll(arrayList1))
        {
            System.out.println("retainAll:");
            System.out.println(arrayList);
        }
        arrayList = new ArrayList<String>();
        arrayList.add("q");
        arrayList.add("q");
        arrayList.add("q");
        arrayList.add("w");
        arrayList.add("e");
        arrayList.add("r");
        arrayList.add("q");
        arrayList.add("a");
        arrayList.add(2,"t");
        Object[] objects = arrayList.toArray();
        System.out.println(Arrays.toString(objects));
        String[] str = {"q","w"};
        String[] strings = arrayList.toArray(str);
        System.out.println(Arrays.toString(strings));
    }

    public static void demoLinkedList()
    {
        LinkedList<Student> students = new LinkedList<Student>();
        students.add(new Student(1,"哈哈"));
        students.add(new Student(1,"哈哈"));
        students.add(new Student(2,"哈哈2"));
        students.add(1,new Student(3,"哈哈3"));
        students.addFirst(new Student(0,""));
        students.addLast(new Student(999,"last"));
        LinkedList<Student> linked = (LinkedList<Student>)students.clone();
        System.out.println("clone:");
        System.out.println(linked);
        if (students.contains(new Student(1,"哈哈")))
        {
            System.out.println("contains:true");
        }

        Iterator<Student> studentIterator = students.descendingIterator();
        while (studentIterator.hasNext())
        {
            System.out.println(studentIterator.next());
        }

        System.out.println(students);
        System.out.println("element:"+students.element());
        System.out.println("get:"+students.get(0));
        System.out.println("getFrist:"+students.getFirst());
        System.out.println("getLast:"+students.getLast());
        System.out.println("indexOf:"+students.indexOf(new Student(1,"哈哈")));
        System.out.println("lastIndexOf:"+students.lastIndexOf(new Student(1,"哈哈")));

        students.offer(new Student(77,"6666"));
        System.out.println("peek:");
        System.out.println(students.peek());
        System.out.println(students.poll());
        System.out.println(students);
        students.push(new Student(88,"666"));
        System.out.println(students);
        students.poll();
    }

    public static void demoHashSet()
    {
        HashSet<Student> students = new HashSet<Student>();
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(new Student(1,"哈哈"));
        students1.add(new Student(1,"哈哈"));
        students1.add(new Student(1,"哈哈"));
        students1.add(new Student(1,"999"));
        students1.add(new Student(1,"888"));
        students.addAll(students1);
        System.out.println(students);
        students.add(new Student(1,"哈哈"));
        if (students.contains(new Student(1,"哈哈")))
        {
            System.out.println("存在的");
        }
        students.add(null);
        students.add(null);
        System.out.println(students);
    }

    public static void demoHashMap()
    {
        HashMap<String, Student> hashMap = new HashMap<String,Student>();
        hashMap.put("1",new Student(1,"哈哈"));
        hashMap.put("1",new Student(1,"666"));
        hashMap.clear();
        hashMap.put("1",new Student(1,"666"));
        hashMap.put("21",new Student(1,"21"));
        hashMap.put("22",new Student(1,"22"));
        hashMap.put("3",new Student(1,"33"));
        System.out.println("containsKey:"+hashMap.containsKey("1"));
        System.out.println("containsValue:"+hashMap.containsValue(new Student(1,"666")));
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,Student> entry = iterator.next();
            System.out.println("key："+entry.getKey()+" value:"+entry.getValue());
        }
        Set<String> strings = hashMap.keySet();

        System.out.println("keys");
        System.out.println(strings);
        Collection<Student> values = hashMap.values();
        System.out.println("value:");
        System.out.println(values);

        System.out.println("sort:");
        ArrayList<?> strings1 = new ArrayList<>(strings);
        System.out.println(Arrays.toString(strings1.toArray()));
        Object[] objects = strings1.toArray();
        Arrays.sort(objects);
        List<?> list =  Arrays.asList(objects);
        System.out.println(list);
        System.out.println(strings1);
        System.out.println(hashMap);

    }
}
