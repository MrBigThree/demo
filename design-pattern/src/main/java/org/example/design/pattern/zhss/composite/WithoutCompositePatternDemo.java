package org.example.design.pattern.zhss.composite;

import com.sun.org.apache.xpath.internal.axes.ChildTestIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class WithoutCompositePatternDemo {

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

        for (Department subDept : parentDept.getChildren()) {
            if (subDept.getChildren().size() > 0) {
                for (Department leafDept : subDept.getChildren()) {
                    leafDept.remove();
                }
            }
            subDept.remove();
        }
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
            System.out.println("删除部门" + this.name);
        }
    }
}
