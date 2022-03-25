package com.xiaoqu;

import com.xiaoqu.annotation.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

public class TestAnnotation {


    @Test
    public void testAnnotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService);
        bookService.add();

    }
}
