package org.example.design.pattern.zhss.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: //
 * 1。将树形结构的数据，用一个类或者少数一两个类拼装
 * 2。直接对父级的操作，会直接递归下层所有的操作
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class CompositePatternDemo {

    public static void main(String[] args) {
        Department leafDept1 = new Department("叶子部门1");
        Department leafDept2 = new Department("叶子部门2");
        Department leafDept3 = new Department("叶子部门3");

        Department subDept1 = new Department("子部门1");
        subDept1.getChildren().add(leafDept1);
        subDept1.getChildren().add(leafDept2);

        Department subDept2 = new Department("子部门2");
        subDept2.getChildren().add(leafDept3);

        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);


        parentDept.remove();
    }

    public static class Department {
        private String name;

        private List<Department> children = new ArrayList<>();


        public Department(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public void remove() {
            if (children.size() > 0) {
                for (Department child : children) {
                    child.remove();
                }
            }
            System.out.println("清除" + name);
        }
    }
}
