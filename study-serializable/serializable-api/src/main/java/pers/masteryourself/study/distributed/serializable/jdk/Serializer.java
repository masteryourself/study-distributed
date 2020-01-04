package pers.masteryourself.study.distributed.serializable.jdk;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 12:07
 */
public interface Serializer {

    /**
     * serialize
     *
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> byte[] serialize(T obj) throws Exception;

    /**
     * deserialize
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> T deserialize(byte[] data, Class<T> clazz) throws Exception;

}
