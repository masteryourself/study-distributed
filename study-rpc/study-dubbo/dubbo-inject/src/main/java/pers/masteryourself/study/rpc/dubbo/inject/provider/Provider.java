package pers.masteryourself.study.rpc.dubbo.inject.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>description : Provider
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/1 11:09
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:provider.xml");
        context.start();
        System.in.read();
    }

}
