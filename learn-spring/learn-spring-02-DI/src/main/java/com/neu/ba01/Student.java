package com.neu.ba01;

public class Student {
    private String name;
    private int age;
    private String id;

    private School school;


    public void setSchool(School school) {
        this.school = school;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", school=" + school +
                '}';
    }
}
