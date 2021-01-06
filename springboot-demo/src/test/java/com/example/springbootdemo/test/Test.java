package com.example.springbootdemo.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/12/31
 */
public class Test {

    private static int countBoy = 0;
    private static int countGirl = 0;

    @org.junit.jupiter.api.Test
    public void test() {

        int de0 = 0;
        int de1 = 0;
        for (int m = 0; m < 100; m++) {
            for (int i = 0; i < 10000000; i++) {
                Family family = new Family();
                while (!family.hasBoy() || family.getChildren().size() <= 1) {
                    family.makeChild();
                }
            }
//            System.out.println(countBoy);
//            System.out.println(countGirl);
//            System.out.println(countGirl - countBoy);
            if (countGirl - countBoy > 0) {
                de0++;
            } else if (countGirl - countBoy < 0) {
                de1++;
            }
            countGirl = 0;
            countBoy = 0;
        }
        System.out.println(de0);
        System.out.println(de1);

    }


    class Family {

        private HashSet<Child> children = new HashSet<>();

        public HashSet<Child> getChildren() {
            return children;
        }

        public void setChildren(HashSet<Child> children) {
            this.children = children;
        }

        public void makeChild() {
            if (children == null) {
                children = new HashSet<>();
            }
            Random random = new Random();
            int i = random.nextInt(2);
            Child child = new Child();
            if (i == 0) {
                countGirl++;
                child.setBoy(false);
            } else if (i == 1) {
                countBoy++;
                child.setBoy(true);
            }
            children.add(child);
        }

        public boolean hasBoy() {
            Iterator<Child> iterator = children.iterator();
            while (iterator.hasNext()) {
                Child next = iterator.next();
                if (next.isBoy) {
                    return true;
                }
            }
            return false;
        }
    }


    class Child {

        //false女 true 男
        private boolean isBoy;

        public boolean isBoy() {
            return isBoy;
        }

        public void setBoy(boolean boy) {
            this.isBoy = boy;
        }
    }
}
