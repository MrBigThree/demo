package org.example.jdk.demo.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/4/12
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(64);
        for (int i = 0; i < 100; i++) {
            hashMap.put(64 * i, "12");
        }

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("", "");
        linkedHashMap.get("");
        linkedHashMap.remove("");


        TreeMap<String, String> treeMap = new TreeMap<>();

    }
}
