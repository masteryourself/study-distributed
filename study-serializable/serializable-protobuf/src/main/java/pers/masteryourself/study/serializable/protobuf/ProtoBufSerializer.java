package pers.masteryourself.study.serializable.protobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

/**
 * <p>description : ProtoBufSerializer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 14:08
 */
public class ProtoBufSerializer {

    public <T> byte[] serialize(T obj) throws Exception {
        Codec codec = ProtobufProxy.create(obj.getClass(), false);
        return codec.encode(obj);
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        Codec codec = ProtobufProxy.create(clazz, false);
        return (T) codec.decode(data);
    }
}
