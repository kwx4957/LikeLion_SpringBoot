package dev.projectlion.demo.week2.answer.advanced;

import java.util.*;

public class AdvancedMissionMain {
    public static void main(String[] args) {
        List<String> number_list = new ArrayList<>();
        List<String> number_list2 = new LinkedList<>();
        List<String> number_list3 = new Vector<>();

        HashSet<String> hashSet = new HashSet<>();

        number_list.add("zz");
        number_list.add("zz2");
        number_list.add("zz3");
        number_list.add("zz4");


        number_list2.add("zz");
        number_list2.add("zz2");
        number_list2.add("zz3");
        number_list2.add("zz4");

        number_list3.add("zz");
        number_list3.add("zz2");
        number_list3.add("zz3");
        number_list3.add("zz4");


        printItems(hashSet);

        hashSet.add("zz");
        hashSet.add("zz2");
        hashSet.add("zz3");
        hashSet.add("zz4");

        printItems(number_list);
        printItems(number_list2);
        printItems(number_list3);
        printItems(hashSet);

    }

    public static <T> void printItems(Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();

        if(!iterator.hasNext()){
            System.out.println("No Elements");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titme\n");

        for (int i = 0; iterator.hasNext(); i++) {
            T item = iterator.next();
            stringBuilder.append(
                    String.format("%d\t\t%s\n", i, item));
        }

        System.out.println(stringBuilder);
    }
}
