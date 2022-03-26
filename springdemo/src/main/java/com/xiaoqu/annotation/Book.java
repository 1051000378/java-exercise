package com.xiaoqu.annotation;

import org.springframework.beans.factory.annotation.Value;

public class Book {

    @Value(value = "abc")
    private String name;
}
