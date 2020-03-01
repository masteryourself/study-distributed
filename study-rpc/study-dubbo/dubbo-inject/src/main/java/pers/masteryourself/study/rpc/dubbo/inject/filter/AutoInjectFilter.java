package pers.masteryourself.study.rpc.dubbo.inject.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import pers.masteryourself.study.rpc.dubbo.inject.dubbo.Subject;
import pers.masteryourself.study.rpc.dubbo.inject.spring.SpringBean;

/**
 * <p>description : AutoInjectFilter
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/1 11:09
 */
@Activate(group = CommonConstants.PROVIDER_SIDE)
public class AutoInjectFilter implements Filter {

    private SpringBean springBean;

    private Subject subject;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("spring bean 执行：" + this.springBean.doSomeThing());
        System.out.println("dubbo bean 执行：" + this.subject.getSubjectInfo(invoker.getUrl()));
        return invoker.invoke(invocation);
    }

    /**
     * 以 setXxx 开头的方法会自动注入，这里是注入 spring 中的 bean（SpringBean）
     *
     * @param springBean
     */
    public void setSpringBean(SpringBean springBean) {
        this.springBean = springBean;
    }

    /**
     * 以 setXxx 开头的方法会自动注入，这里是注入 dubbo 中的 bean（Subject$Adaptive）
     *
     * @param subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
