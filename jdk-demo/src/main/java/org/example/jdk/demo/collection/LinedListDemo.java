package org.example.jdk.demo.collection;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/4/8
 */
public class LinedListDemo {

    public static void main(String[] args) {
        //transient 不序列化
        LinkedList<String> linkedList = new LinkedList<>();

        //Node 双向链表 pre next
        linkedList.add("string");
        linkedList.add("string2");
        linkedList.addFirst("");
        linkedList.add(2,"");
        linkedList.getFirst();
        linkedList.peek();

        linkedList.addFirst("");


    }
}
