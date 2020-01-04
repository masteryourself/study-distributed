package pers.masteryourself.study.distributed.serializable.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 15:07
 */
public class HessianSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
        hessianOutput.writeObject(obj);
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        HessianInput hessianInput = new HessianInput(new ByteArrayInputStream(data));
        return (T) hessianInput.readObject(clazz);
    }
}
