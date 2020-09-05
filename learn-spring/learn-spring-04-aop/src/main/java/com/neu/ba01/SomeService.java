package com.neu.ba01;

public interface SomeService {
    void doSomeBefore(String name, Integer age);
    String doSomeAfterReturning(String name, Integer age);
    String doSomeAround(String name, Integer age);
}
