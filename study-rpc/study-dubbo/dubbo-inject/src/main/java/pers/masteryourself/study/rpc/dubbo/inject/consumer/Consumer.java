package pers.masteryourself.study.rpc.dubbo.inject.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.masteryourself.study.rpc.dubbo.inject.api.DemoService;

import java.util.concurrent.TimeUnit;

/**
 * <p>description : Consumer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/1 11:09
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
                e.printStackTrace();
                System.out.println("报错了：" + e.getMessage());
            }
            TimeUnit.SECONDS.sleep(2);
        }
        // cluster 策略演示
        //System.out.println(demoService.sayHello("dubbo"));
    }

}
