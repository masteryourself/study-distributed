package pers.masteryourself.study.serializable.json;

import lombok.Data;

/**
 * <p>description : User
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 14:08
 */
@Data
public class User {

    private Long id;

    private String name;

    public static int num = 100;

    private transient int age;

}
