package com.xiaoqu;


import com.xiaoqu.aop.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class TestService {

    @Autowired
    private UserService userService;

    @Autowired
    private Book book;

    @Test
    public void testService(){
        userService.add();
    }

    @Test
    public void testPointCut(){
        book.add();

    }
}
