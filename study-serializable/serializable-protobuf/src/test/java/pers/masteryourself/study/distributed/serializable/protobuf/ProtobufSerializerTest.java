package pers.masteryourself.study.distributed.serializable.protobuf;

import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import org.junit.Test;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

import java.util.Arrays;


/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 14:46
 */
public class ProtobufSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        Serializer serializer = new ProtobufSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        byte[] data = serializer.serialize(user);
        // 19
        System.out.println(data.length);
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself)
        System.out.println(deserializeUer);
    }

}