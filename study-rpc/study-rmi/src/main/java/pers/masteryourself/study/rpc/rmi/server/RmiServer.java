package pers.masteryourself.study.rpc.rmi.server;

import pers.masteryourself.study.rpc.rmi.api.OrderFacade;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 16:14
 */
public class RmiServer {

    public static void main(String[] args) throws Exception {
        // 发布远程服务
        OrderFacade orderFacade = new OrderFacadeImpl();
        // 服务端启动 Registry 服务
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/order", orderFacade);
        System.out.println("rmi-server 启动");
    }

}
