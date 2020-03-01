package pers.masteryourself.study.serializable.xml;

import org.junit.Test;

/**
 * <p>description : XmlSerializerTest
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 13:54
 */
public class XmlSerializerTest {

    @Test
    public void testXmlSerializer() throws Exception {
        XmlSerializer serializer = new XmlSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        user.setAge(18);
        byte[] data = serializer.serialize(user);
        user.num = 10;
        // <pers.masteryourself.study.distributed.serializable.xml.User>
        // <id>998</id>
        // <name>masteryourself</name>
        // </pers.masteryourself.study.distributed.serializable.xml.User>
        System.out.println(new String(data));
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself, age=0)
        System.out.println(deserializeUer);
        // 10
        System.out.println(deserializeUer.num);
    }

}