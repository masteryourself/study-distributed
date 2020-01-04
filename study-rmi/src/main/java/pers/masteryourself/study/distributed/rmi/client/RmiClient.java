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
        OrderFacade orderFacade = (OrderFacade) Naming.lookup("rmi://localhost:8888/order");
        System.out.println(orderFacade.doOrder("masteryourself"));
    }

}
