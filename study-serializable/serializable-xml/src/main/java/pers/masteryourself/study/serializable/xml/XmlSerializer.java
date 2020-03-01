package pers.masteryourself.study.serializable.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * <p>description : XmlSerializer
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/1/4 13:54
 */
public class XmlSerializer {

    private XStream xStream = new XStream(new DomDriver());

    public <T> byte[] serialize(T obj) throws Exception {
        return xStream.toXML(obj).getBytes();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) throws Exception {
        return (T) xStream.fromXML(new String(data));
    }

}
