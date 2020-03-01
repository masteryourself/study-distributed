package pers.masteryourself.study.rpc.dubbo.v265.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>description : Provider
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/12/8 1:36
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:provider.xml");
        context.start();
        System.in.read();
    }

}
