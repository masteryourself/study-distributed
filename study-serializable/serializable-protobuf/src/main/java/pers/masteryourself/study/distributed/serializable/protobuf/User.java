package pers.masteryourself.study.distributed.serializable.protobuf;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
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

    @Protobuf(fieldType = FieldType.INT64)
    private Long id;

    @Protobuf(fieldType = FieldType.STRING)
    private String name;

}
