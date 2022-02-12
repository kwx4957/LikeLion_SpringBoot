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


        printCollections(hashSet);

    hashSet.add("zz");
    hashSet.add("zz2");
    hashSet.add("zz3");
    hashSet.add("zz4");

        printCollections(number_list);
        printCollections(number_list2);
        printCollections(number_list3);
        printCollections(hashSet);

    }

    public static void printCollections(Collection collection){

        if (collection.isEmpty()){
            System.out.println("No Elements");
            return;
        }

        System.out.println("idx\titem");
        int i = 0;

        for (Object s : collection) {
            System.out.println(i +"\t"+s.toString());
            i+=1;
        }
    }
}
