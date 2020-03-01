package pers.masteryourself.study.rpc.dubbo.spi.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * <p>description : TimeSpendProviderFilter，
 * {@link Activate} group = CommonConstants.PROVIDER_SIDE 表示在 provider 端激活
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/12/8 1:54
 */
@Activate(group = CommonConstants.PROVIDER_SIDE)
public class TimeSpendProviderFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        long start = System.currentTimeMillis();
        Result result = invoker.invoke(invocation);
        long end = System.currentTimeMillis();
        System.out.println(invoker.getInterface() + " 接口耗时：" + (end - start) + "ms");
        return result;
    }

}
