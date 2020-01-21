package pers.masteryourself.study.rpc.dubbo.spi.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 统计 dubbo 调用耗时的 filter，在 provider 端才会生效
 * @date : 2020/1/1 10:07
 */
// 在 provider 端激活
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
