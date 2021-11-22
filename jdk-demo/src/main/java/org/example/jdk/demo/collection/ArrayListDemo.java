package org.example.jdk.demo.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/5
 */
public class ArrayListDemo {

    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

        list.add("");
        list.add("");


        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }
    }
}
