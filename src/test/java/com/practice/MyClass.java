package com.practice;

public class MyClass {
    static int staticVariable;
    int instanceVariable;

    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        // Set staticVariable to 1
        MyClass.staticVariable = 1;

        // Set instanceVariable to 2 for obj1
        obj1.instanceVariable = 2;

        // Set instanceVariable to 3 for obj2
        obj2.instanceVariable = 3;

        System.out.println("Static variable value: " + MyClass.staticVariable);
        System.out.println("Instance variable value for obj1: " + obj1.instanceVariable);
        System.out.println("Instance variable value for obj2: " + obj2.instanceVariable);
    }
}
