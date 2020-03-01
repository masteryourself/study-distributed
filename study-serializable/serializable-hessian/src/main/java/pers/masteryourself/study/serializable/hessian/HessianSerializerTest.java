package pers.masteryourself.study.serializable.hessian;

import org.junit.Test;

/**
 * <p>description : HessianSerializerTest
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 15:07
 */
public class HessianSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        HessianSerializer serializer = new HessianSerializer();
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