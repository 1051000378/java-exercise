package com.xiaoqu.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;


    public void add(){
        System.out.println("service add......");
        bookDao.addDao();
    }

}
