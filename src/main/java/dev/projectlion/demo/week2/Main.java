package dev.projectlion.demo.week2;

import dev.projectlion.demo.week2.basic.Lecturer;

import java.io.*;

// serializable를 사용하는 이유
public class Main {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("./text.txt");
            oos = new ObjectOutputStream(fos);
            Lecturer bv = new Lecturer("나다");

            oos.writeObject(bv); // string이 serializable을 구현했기때문에 사용가능
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
        }


        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("./text.txt");
            ois = new ObjectInputStream(fis);

            Lecturer i = (Lecturer) ois.readObject();
            System.out.printf("읽은 데이터 : %s\n", i.getName());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
