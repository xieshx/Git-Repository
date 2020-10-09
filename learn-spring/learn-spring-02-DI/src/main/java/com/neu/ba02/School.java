package com.neu.ba02;

public class School {

    private String schoolName;

    private String address;

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
