package pers.masteryourself.study.distributed.serializable.hessian;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 12:04
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

}
