package pers.masteryourself.study.distributed.serializable.hessian;

import org.junit.Test;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 15:09
 */
public class HessianSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        Serializer serializer = new HessianSerializer();
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