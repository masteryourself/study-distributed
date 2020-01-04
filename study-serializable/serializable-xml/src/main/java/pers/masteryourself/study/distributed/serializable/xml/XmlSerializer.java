package pers.masteryourself.study.distributed.serializable.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import pers.masteryourself.study.distributed.serializable.jdk.Serializer;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2020/1/4 13:54
 */
public class XmlSerializer implements Serializer {

    private XStream xStream = new XStream(new DomDriver());

    @Override
    public <T> byte[] serialize(T obj) throws Exception {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return (T) xStream.fromXML(new String(data));
    }

}
