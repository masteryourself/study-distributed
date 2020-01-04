package pers.masteryourself.study.distributed.rmi.server;

import pers.masteryourself.study.distributed.rmi.api.OrderFacade;

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
        OrderFacade orderFacade = new OrderFacadeImpl();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/order", orderFacade);
        System.out.println("rmi-server 启动");
    }

}
