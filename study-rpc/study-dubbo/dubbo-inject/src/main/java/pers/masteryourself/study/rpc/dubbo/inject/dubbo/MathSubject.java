package pers.masteryourself.study.rpc.dubbo.inject.dubbo;

import org.apache.dubbo.common.URL;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/1 11:35
 */
public class MathSubject implements Subject {

    @Override
    public String getSubjectInfo(URL url) {
        return "上数学课";
    }

}