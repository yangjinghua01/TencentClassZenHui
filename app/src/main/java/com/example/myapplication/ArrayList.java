package com.example.myapplication;

import java.util.Objects;

public class ArrayList<T> {
private Object[] items = new Objects[10];
public void add(T t){
    items[0] = t;
}
}
