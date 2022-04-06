import com.xiaoqu.Book;
import com.xiaoqu.Course;
import com.xiaoqu.User;
import com.xiaoqu.UserService;
import com.xiaoqu.entity.Order;
import com.xiaoqu.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestUser {

    @Test
    public void testUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextApplication.xml");
        User user = context.getBean("user", User.class);
        user.add();

        Course course = context.getBean("course", Course.class);
        System.out.println(course.toString());

        Book book = context.getBean("book", Book.class);
        System.out.println(book.getName()+" "+book.getAuthor());
        book.add();
        System.out.println(book.getCourses());
        System.out.println(book.getList());
        System.out.println(book.getMaps());
        System.out.println(book.getSets());
    }

    @Test
    public void testUserAdd(){

        ApplicationContext context = new ClassPathXmlApplicationContext("contextApplication.xml");
        User user = context.getBean("user", User.class);
        UserService userService = context.getBean("userService", UserService.class);

        user.setUserName("lili");
        user.setUsePwd("123");
        user.setUserRealname("lililili");
        user.setUserImg("li.img");
        userService.add(user);

        User user1 = new User();
        user1.setUserName("lili");
        user1.setUserRealname("geggg");
        userService.updateUser(user);
        System.out.println("修改用户成功");


        User user2 = new User();
        user2.setUserName("xiaoming");
        userService.deleteUser(user2);
        System.out.println("删除成功");

        User user3 = new User();
        user3.setUserName("lll");
        int count = userService.countUser(user3);
        System.out.println("数量："+count);

        User user4 = new User();
        user4.setUserName("lili");
        List<User> userList = userService.getUserList(user4);
        System.out.println(userList.toString());

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1= {"胡巴","123","小胡","huba.jpg"};
        Object[] o2= {"龙珠","123","孙悟空","kong.jpg"};
        Object[] o3= {"茶杯","123","茶壶","cha.jpg"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        userService.batchAddUser(batchArgs);
        System.out.println("批量添加完毕");
    }

    @Test
    public void testOrder(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextApplication.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        Order order = new Order();
        order.setProductId("1");
        order.setCount(30);
        order.setMoney(new BigDecimal(600));
        order.setUserId("1");
        order.setStatus(0);
        orderService.createOrder(order);

    }



}
