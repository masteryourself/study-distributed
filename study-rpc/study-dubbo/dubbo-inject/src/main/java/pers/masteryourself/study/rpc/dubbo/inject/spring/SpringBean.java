package pers.masteryourself.study.rpc.dubbo.inject.spring;

import org.springframework.stereotype.Service;

/**
 * <p>description : SpringBean
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/1 11:09
 */
@Service
public class SpringBean {

    public String doSomeThing() {
        return "吃饭睡觉打豆豆";
    }

}
