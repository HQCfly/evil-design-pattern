package com.twiss.designpattern.iterator;

/**
 * @Author: Twiss
 * @Date: 2021/3/9 11:26 下午
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        Student student1 = new Student("小明");
        Student student2 = new Student("小王");
        ClassRoom classRoom = new ClassRoom(2);
        classRoom.addStudent(student1);
        classRoom.addStudent(student2);
        Iterator iterator = classRoom.iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student);
        }
    }

    /**
     * 定义一个我们自己的迭代器接口
     */
    public interface Iterator{
        public abstract boolean hasNext();
        public abstract Object next();
    }

    public interface Aggregate{
        public abstract Iterator iterator();
    }

    public static class Student{
        private String name;

        public Student(String name){
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 教室迭代器
     */

    public static class ClassRoom implements Aggregate{
        private Student[] students;
        private int last = 0;

        public ClassRoom(int size) {
            this.students = new Student[size];
        }

        public void addStudent(Student student) {
            this.students[last] = student;
            last++;
        }

        public Student getStudents(int index) {
            return students[index];
        }
        public int getLength() {
            return last;
        }
        public Iterator iterator() {
            return new ClassRoomIterator(this);
        }
    }

    public static class ClassRoomIterator implements Iterator {

        private ClassRoom classRoom;
        private int index;
        public ClassRoomIterator(ClassRoom classRoom){
            this.classRoom = classRoom;
            this.index = 0;
        }

        public boolean hasNext() {
            return index < classRoom.getLength();
        }

        public Object next() {
            Student student = classRoom.getStudents(index);
            index++;
            return student;
        }
    }
}
