package pers.masteryourself.study.serializable.protobuf;

import org.junit.Test;

/**
 * <p>description : ProtoBufSerializerTest
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 14:08
 */
public class ProtoBufSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        ProtoBufSerializer serializer = new ProtoBufSerializer();
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