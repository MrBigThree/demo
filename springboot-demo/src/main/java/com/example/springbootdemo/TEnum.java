package com.example.springbootdemo;

public enum TEnum {

    A(""),
    B();
    private String name;


    TEnum(String name) {
        this.name = name;
    }

    TEnum() {

    }

}
