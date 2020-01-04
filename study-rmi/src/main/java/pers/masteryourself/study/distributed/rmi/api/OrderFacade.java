package pers.masteryourself.study.distributed.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 16:11
 */
public interface OrderFacade extends Remote {

    String doOrder(String name) throws RemoteException;

}
