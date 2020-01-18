package pers.masteryourself.study.serializable.jdk;

import org.junit.Test;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 12:39
 */
public class JavaSerializerTest {

    @Test
    public void testJavaSerializer() throws Exception {
        JavaSerializer serializer = new JavaSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        byte[] data = serializer.serialize(user);
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself)
        System.out.println(deserializeUer);
    }

    @Test
    public void testStaticSerializer() throws Exception {
        JavaSerializer serializer = new JavaSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        byte[] data = serializer.serialize(user);
        user.num = 10;
        user.setId(997L);
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself)
        System.out.println(deserializeUer);
        // 10
        System.out.println(deserializeUer.num);
    }

    @Test
    public void testParentSerializer() throws Exception {
        JavaSerializer serializer = new JavaSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        user.setSex("man");
        byte[] data = serializer.serialize(user);
        User deserializeUer = serializer.deserialize(data, User.class);
        // null
        System.out.println(deserializeUer.getSex());
    }

    @Test
    public void testTransientSerializer() throws Exception {
        JavaSerializer serializer = new JavaSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        user.setSex("man");
        user.setAge(18);
        byte[] data = serializer.serialize(user);
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself, age=0)
        System.out.println(deserializeUer);
    }

    @Test
    public void testAvoidTransientSerializer() throws Exception {
        JavaSerializer serializer = new JavaSerializer();
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        user.setSex("man");
        user.setAge(18);
        byte[] data = serializer.serialize(user);
        User deserializeUer = serializer.deserialize(data, User.class);
        // User(id=998, name=masteryourself, age=18)
        System.out.println(deserializeUer);
    }

    @Test
    public void testDeepCloneSerializer() throws Exception {
        User user = new User();
        user.setId(998L);
        user.setName("masteryourself");
        Car car = new Car();
        car.setColour("red");
        car.setUser(user);
        // Car car2 = car.clone();
        Car car2 = car.deepClone();
        car2.getUser().setName("张三");
        // car：Car(colour=red, user=User(id=998, name=masteryourself, age=0))
        System.out.println("car：" + car);
        // car2：Car(colour=red, user=User(id=998, name=张三, age=0))
        System.out.println("car2：" + car2);
    }

}