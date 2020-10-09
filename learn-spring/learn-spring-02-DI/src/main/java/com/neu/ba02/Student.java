package com.neu.ba02;

public class Student {

    private String name;

    private int age;

    private String id;

    private School school;

    public Student(String name, int age, String id, School school) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.school = school;
    }

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
