package pers.masteryourself.study.distributed.serializable.json;

import org.junit.Test;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 14:11
 */
public class JsonSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        Serializer serializer = new JsonSerializer();
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