package pers.masteryourself.study.rpc.dubbo.inject.dubbo;

import org.apache.dubbo.common.URL;

/**
 * <p>description : EnglishSubject
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/1 11:09
 */
public class EnglishSubject implements Subject {

    @Override
    public String getSubjectInfo(URL url) {
        return "上英语课";
    }

}
