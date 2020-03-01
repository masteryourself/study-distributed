package pers.masteryourself.study.serializable.protobuf;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
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

    @Protobuf(fieldType = FieldType.INT64)
    private Long id;

    @Protobuf(fieldType = FieldType.STRING)
    private String name;

}
