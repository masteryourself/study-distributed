package pers.masteryourself.study.distributed.serializable.jdk;

import lombok.Data;

import java.io.*;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 13:17
 */
@Data
public class Car implements Cloneable, Serializable {

    private String colour;

    private User user;

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    public Car deepClone() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Car) objectInputStream.readObject();
    }
}
