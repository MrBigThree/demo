package org.example.design.pattern.zhss.iterator;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class IteratorDesignPatternDemo {

    public static void main(String[] args) {
        Classroom classroom = new Classroom(10);

        Student student1 = new Student("张三");
        Student student2 = new Student("李四");

        classroom.addStudent(student1);
        classroom.addStudent(student2);

        Iterator iterator = classroom.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}


/**
 * 定义迭代器接口
 */
interface Iterator {

    boolean hasNext();

    Object next();
}

/**
 * 迭代器能力接口，实现这个接口表示这个类的实例对象可以进行迭代
 */
interface Iterable {

    Iterator iterator();
}


class Student {


    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * 实现Iterable接口，可以获取Iterator对象
 */
class Classroom implements Iterable {

    private Student[] students;
    private int last = 0;

    public Classroom(int size) {
        this.students = new Student[size];
    }

    public Student getStudent(int index) {
        return students[index];
    }

    public void addStudent(Student student) {
        this.students[last] = student;
        this.last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new ClassroomIterator(this);
    }

}

/**
 * 实现迭代器接口
 */
class ClassroomIterator implements Iterator {

    private Classroom classroom;

    private int index;

    public ClassroomIterator(Classroom classroom) {
        this.classroom = classroom;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < classroom.getLength()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public Object next() {
        Student student = this.classroom.getStudent(index);
        index++;
        return student;
    }
}


