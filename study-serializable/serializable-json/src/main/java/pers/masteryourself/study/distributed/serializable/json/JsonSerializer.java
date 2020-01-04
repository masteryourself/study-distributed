package pers.masteryourself.study.distributed.serializable.json;

import com.alibaba.fastjson.JSON;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 14:08
 */
public class JsonSerializer implements Serializer {

    @Override
    public <T> byte[] serialize(T obj) throws Exception {
        return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return JSON.parseObject(data, clazz);
    }
}
