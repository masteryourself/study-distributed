package pers.masteryourself.study.serializable.protobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 14:43
 */
public class ProtobufSerializer {

    public <T> byte[] serialize(T obj) throws Exception {
        Codec codec = ProtobufProxy.create(obj.getClass(), false);
        return codec.encode(obj);
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        Codec codec = ProtobufProxy.create(clazz, false);
        return (T) codec.decode(data);
    }
}
