package pers.masteryourself.study.distributed.serializable.json;

import lombok.Data;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 12:04
 */
@Data
public class User {

    private Long id;

    private String name;

    public static int num = 100;

    private transient int age;

}
