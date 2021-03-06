package pers.masteryourself.study.rpc.dubbo.spi.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.masteryourself.study.rpc.dubbo.spi.api.DemoService;

import java.util.concurrent.TimeUnit;

/**
 * <p>description : Consumer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/12/8 1:54
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        DemoService demoService = context.getBean("demoService", DemoService.class);
        while (true) {
            try {
                System.out.println(demoService.sayHello("dubbo"));
            } catch (Exception e) {
                System.out.println("报错了：" + e.getMessage());
            }
            TimeUnit.SECONDS.sleep(2);
        }
        // cluster 策略演示
        //System.out.println(demoService.sayHello("dubbo"));
    }

}
