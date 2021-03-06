package pers.masteryourself.study.rpc.rmi.server;

import pers.masteryourself.study.rpc.rmi.api.OrderFacade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>description : OrderFacadeImpl
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 16:11
 */
public class OrderFacadeImpl extends UnicastRemoteObject implements OrderFacade {

    protected OrderFacadeImpl() throws RemoteException {
    }

    @Override
    public String doOrder(String name) throws RemoteException {
        return String.format("%s 下单成功, 订单号是 %s", name, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
    }

}
