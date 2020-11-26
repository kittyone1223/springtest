package junit;

import com.offcn.AutoWired;
import com.offcn.controller.UserController;
import com.offcn.service.UserService;
import org.junit.Test;

import java.util.stream.Stream;


public class App02 {

    @Test
    public void test(){
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        UserService userService = new UserService();
        System.out.println(userService);

        // 获取的所有的属性值

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            AutoWired annotation = field.getAnnotation(AutoWired.class);
            if (annotation!=null){
                field.setAccessible(true);

                // 获取属性的类型
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        });
        System.out.println(userController.getUserService());
    }
}
