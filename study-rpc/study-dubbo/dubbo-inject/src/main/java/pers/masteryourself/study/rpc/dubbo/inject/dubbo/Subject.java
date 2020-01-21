package pers.masteryourself.study.rpc.dubbo.inject.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/1 11:09
 */
// 默认使用 math
@SPI("math")
public interface Subject {

    /**
     * 会自动生成  Subject$Adaptive
     * 先调用      String value = url.getParameter("subject") 方法找出对应的值
     * 再调用      Subject subject = (Subject)ExtensionLoader.getExtensionLoader(Subject.class).getExtension(value);
     * 最后调用    subject.getSubjectInfo(url) 方法返回
     *
     * @param url
     * @return
     */
    @Adaptive("subject")
    String getSubjectInfo(URL url);

}
