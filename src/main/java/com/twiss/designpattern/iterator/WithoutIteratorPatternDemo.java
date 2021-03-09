package com.twiss.designpattern.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/3/8 12:09 上午
 * 以下代码可扩展性，可维护性很差
 */
public class WithoutIteratorPatternDemo {

    public static void main(String[] args) {
        Student student1 = new Student("小明");
        Student student2 = new Student("小王");
        Map<String,Student> studentMap = new HashMap<String, Student>();
        studentMap.put(student1.getName(),student1);
        studentMap.put(student2.getName(),student2);
        ClassRoom classRoom = new ClassRoom();
        classRoom.setStudents(studentMap);
        Map<String,Student> resultStudent = classRoom.getStudents();
        for (Student student: resultStudent.values()){
            System.out.println(student.toString());
        }
//        修改前输出结构
//        Student[] students = new Student[2];
//        students[0] = student1;
//        students[1] = student2;
//
//        ClassRoom classRoom = new ClassRoom();
//        classRoom.setStudents(students);
//
//        Student[] resultStudents = classRoom.getStudents();
//        for (Student student : resultStudents){
//            System.out.println(student.toString());
//        }
    }

    private static class Student {
        private String name;

        public Student(String name){
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString(){
            return "Student [name="+name+"]";
        }
    }

    private static class ClassRoom {
        private Map<String,Student> students;

        public void setStudents(Map<String, Student> students) {
            this.students = students;
        }

        public Map<String, Student> getStudents() {
            return students;
        }

        //        修改前结构
//        private Student[] students;
//
//        public Student[] getStudents() {
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }
    }

}

