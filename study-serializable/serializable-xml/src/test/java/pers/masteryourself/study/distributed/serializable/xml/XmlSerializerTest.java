package pers.masteryourself.study.distributed.serializable.xml;

import org.junit.Test;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

import static org.junit.Assert.*;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 13:58
 */
public class XmlSerializerTest {

    @Test
    public void testJavaSerializer() throws Exception {
        Serializer serializer = new XmlSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        user.setAge(18);
        byte[] data = serializer.serialize(user);
        System.out.println(new String(data));
        User deserializeUer = serializer.deserialize(data, User.class);
        System.out.println(deserializeUer);
    }

}