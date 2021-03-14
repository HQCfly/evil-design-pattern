package com.twiss.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 11:58 下午
 * 场景：
 * （1）父部门->子部门->子部门
 * （2）我们要对部门树，删除一个父部门以及其下所有的子部门
 * 第一要义：将树形结构的数据，用一个类或者少数一两个类，就可以拼装成一颗树的形状
 * 第二要义：直接对第一个父级数据执行某个操作，这个操作会直接递归调用者所有下层的子数据相关操作
 */
public class CompositePatternDemo {

    public static void main(String[] args) {
        Department leafDepartment1 = new Department("叶子部门1");
        Department leafDepartment2 = new Department("叶子部门2");
        Department leafDepartment3 = new Department("叶子部门3");
        
        Department subDept1 = new Department("子部门1");
        subDept1.getChildren().add(leafDepartment1);
        subDept1.getChildren().add(leafDepartment2);

        Department subDept2 = new Department("子部门2");
        subDept2.getChildren().add(leafDepartment3);

        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);

        parentDept.remove();
    }

    public static class Department{
        private String name;

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

        private List<Department> children = new ArrayList<Department>();

        public Department(String name){
            super();
            this.name = name;
        }

        public void remove(){
            if (children.size()>0){
                for (Department child:children){
                    child.remove();
                }
            }
            System.out.println("删除成功【"+name+"】");
        }
    }
}
