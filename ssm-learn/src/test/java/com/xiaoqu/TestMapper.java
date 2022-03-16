package com.xiaoqu;


import com.xiaoqu.dao.DepartmentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 测试dao
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 */


public class TestMapper {

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD(){
       //1.创建SpringIOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        2.从容器中获取mapper
        DepartmentMapper departmentMapper = applicationContext.getBean(DepartmentMapper.class);


    }


}
