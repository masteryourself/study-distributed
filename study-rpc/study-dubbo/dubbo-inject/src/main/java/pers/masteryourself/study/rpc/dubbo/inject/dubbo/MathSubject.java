package pers.masteryourself.study.rpc.dubbo.inject.dubbo;

import org.apache.dubbo.common.URL;

/**
 * <p>description : MathSubject
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/1 11:09
 */
public class MathSubject implements Subject {

    @Override
    public String getSubjectInfo(URL url) {
        return "上数学课";
    }

}