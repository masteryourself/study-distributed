package pers.masteryourself.study.serializable.json;

import org.junit.Test;

/**
 * <p>description : FastJsonSerializerTest
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 14:08
 */
public class FastJsonSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        FastJsonSerializer serializer = new FastJsonSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        user.setAge(18);
        byte[] data = serializer.serialize(user);
        user.num = 10;
        // {"id":998,"name":"masteryourself"}
        System.out.println(new String(data));
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself, age=0)
        System.out.println(deserializeUer);
        // 10
        System.out.println(deserializeUer.num);
    }

}