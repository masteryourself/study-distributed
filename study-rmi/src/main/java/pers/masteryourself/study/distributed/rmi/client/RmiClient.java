package pers.masteryourself.study.distributed.rmi.client;

import pers.masteryourself.study.distributed.rmi.api.OrderFacade;

import java.rmi.Naming;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 16:15
 */
public class RmiClient {

    public static void main(String[] args) throws Exception {
        // 客户端获取服务端 Registry 代理
        OrderFacade orderFacade = (OrderFacade) Naming.lookup("rmi://localhost:8888/order");
        // orderFacade 实际上代理类，被 java.rmi.server.RemoteObjectInvocationHandler.invoke 拦截
        System.out.println(orderFacade.doOrder("masteryourself"));
    }

}
