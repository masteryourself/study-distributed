package pers.masteryourself.study.serializable.hessian;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>description : User
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 15:07
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

}
