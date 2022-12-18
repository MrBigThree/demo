package org.example.jdk.demo.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/12/21
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        // 0 111 1111 1111 1111 1111 1111 1111 1111
        // 1
        map.put("str", "strValue");

    }
}
