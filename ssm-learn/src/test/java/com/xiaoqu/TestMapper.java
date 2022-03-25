package com.xiaoqu;


import com.xiaoqu.dao.DepartmentMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

/**
 * 测试dao
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMapper {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD(){
//       //1.创建SpringIOC容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
////        2.从容器中获取mapper
//        DepartmentMapper departmentMapper = applicationContext.getBean(DepartmentMapper.class);

        System.out.println(departmentMapper);


    }


}
