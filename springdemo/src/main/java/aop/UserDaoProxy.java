package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;


//创建代理对象代码
public class UserDaoProxy implements InvocationHandler {
//    把创建的是谁的代理对象，把谁传递过来
//    有参数构造传递
    private Object obj;

    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

//    增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        方法之前的操作
        System.out.println("方法执行前..."+method.getName()+":传递的参数..."+ Arrays.toString(args));
//        被增强的方法执行
        Object invoke = method.invoke(obj, args);
//        方法之后的操作
        System.out.println("方法之后执行..."+obj);

        return invoke;
    }
}
