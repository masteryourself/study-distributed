package pers.masteryourself.study.rpc.dubbo.aop.protocol;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.rpc.Exporter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Protocol;
import org.apache.dubbo.rpc.RpcException;

/**
 * <p>description : RegistryProtocolWrapper
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/12/8 1:36
 */
public class RegistryProtocolWrapper implements Protocol {

    private Protocol protocol;

    /**
     * 必须要有，这是判断是否是 wrapper 类的标识
     *
     * @param protocol
     */
    public RegistryProtocolWrapper(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public int getDefaultPort() {
        return this.protocol.getDefaultPort();
    }

    @Override
    public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
        Exporter<T> export = null;
        if (CommonConstants.DUBBO.equals(invoker.getUrl().getProtocol())) {
            System.out.println("注册 dubbo 服务之前，do something...");
            export = this.protocol.export(invoker);
            System.out.println("注册 dubbo 服务之后，do something...");
        }
        return export != null ? export : this.protocol.export(invoker);
    }

    @Override
    public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
        return this.protocol.refer(type, url);
    }

    @Override
    public void destroy() {
        this.protocol.destroy();
    }
}
