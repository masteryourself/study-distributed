package pers.masteryourself.study.serializable.protobuf;

import org.junit.Test;


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
        ProtobufSerializer serializer = new ProtobufSerializer();
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