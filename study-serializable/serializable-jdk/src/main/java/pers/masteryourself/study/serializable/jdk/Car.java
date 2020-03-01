package pers.masteryourself.study.serializable.jdk;

import lombok.Data;

import java.io.*;

/**
 * <p>description : Car
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 15:07
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
