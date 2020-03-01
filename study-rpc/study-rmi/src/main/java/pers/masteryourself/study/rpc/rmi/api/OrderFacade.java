package pers.masteryourself.study.rpc.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>description : OrderFacade
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 16:11
 */
public interface OrderFacade extends Remote {

    String doOrder(String name) throws RemoteException;

}
