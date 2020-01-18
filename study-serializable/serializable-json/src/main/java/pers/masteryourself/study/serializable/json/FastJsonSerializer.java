package pers.masteryourself.study.serializable.json;

import com.alibaba.fastjson.JSON;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 14:08
 */
public class FastJsonSerializer {

    public <T> byte[] serialize(T obj) throws Exception {
        return JSON.toJSONBytes(obj);
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return JSON.parseObject(data, clazz);
    }
}
