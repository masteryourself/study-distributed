package pers.masteryourself.study.rpc.dubbo.v265.provider;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.RpcContext;
import pers.masteryourself.study.rpc.dubbo.v265.api.DemoService;

import java.util.concurrent.TimeUnit;

/**
 * <p>description : DemoServiceImpl
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/12/8 1:36
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        URL url = RpcContext.getContext().getUrl();
        String message = String.format(" protocol is %s, address is %s", url.getProtocol(), url.getAddress());
        // cluster 策略演示
        try {
            System.out.println("调用此方法了。。。" + message);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "你好：" + name + message;
    }

}
