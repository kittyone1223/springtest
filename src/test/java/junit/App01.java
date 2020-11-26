package junit;

import com.offcn.controller.UserController;
import com.offcn.service.UserService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App01 {

    @Test
    public void test() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        // 创建对象
        UserService userService = new UserService();

        System.out.println(userService);

        // 获取所有的属性值
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);

        //  只有通过方法才能够设置的属性值
        String name = serviceField.getName();
        System.out.println(name);
        // 拼接方法的名称
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());


        String setMethodName = "set"+name;

        // 通过方法注入属性的对象
        Method method = clazz.getMethod(setMethodName, UserService.class);

        //  反射
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }
}
