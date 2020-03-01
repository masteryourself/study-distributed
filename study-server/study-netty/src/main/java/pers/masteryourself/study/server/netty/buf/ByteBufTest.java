package pers.masteryourself.study.server.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.Test;

/**
 * <p>description : ByteBufTest， ByteBuf 使用
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/18 15:32
 */
public class ByteBufTest {

    /**
     * 与 ByteBuffer 区别：
     * 不需要用 flip() 方法翻转，底层维护了 readerIndex 和 writerIndex
     * 0-readerIndex：已经读取的区域
     * readerIndex-writerIndex：可读的区域
     * writerIndex-capacity：可写的区域
     */
    @Test
    public void testByteBufBasic() {
        ByteBuf buf = Unpooled.buffer(10);
        // 创建时候：readerIndex is 0, writerIndex is 0, capacity is 10
        System.out.printf("创建时候：readerIndex is %d, writerIndex is %s, capacity is %d\n", buf.readerIndex(), buf.writerIndex(), buf.capacity());
        buf.writeByte(1);
        buf.writeByte(2);
        buf.writeByte(3);
        buf.writeByte(4);
        // 添加 4 个数据后：readerIndex is 0, writerIndex is 4, capacity is 10
        System.out.printf("添加 4 个数据后：readerIndex is %d, writerIndex is %s, capacity is %d\n", buf.readerIndex(), buf.writerIndex(), buf.capacity());
        System.out.println(buf.readByte());
        System.out.println(buf.readByte());
        // 读取完 2 个数据后：readerIndex is 2, writerIndex is 4, capacity is 10
        System.out.printf("读取完 2 个数据后：readerIndex is %d, writerIndex is %s, capacity is %d\n", buf.readerIndex(), buf.writerIndex(), buf.capacity());
    }

    @Test
    public void testByteBufApi() {
        ByteBuf buf = Unpooled.copiedBuffer("hello,netty", CharsetUtil.UTF_8);
        byte[] content = buf.array();
        // hello,netty
        System.out.println(new String(content, CharsetUtil.UTF_8));
        // 0
        System.out.println(buf.arrayOffset());
        // 33
        System.out.println(buf.capacity());
        // buf 可读的字节数 11
        System.out.println("buf 可读的字节数 " + buf.readableBytes());
        // buf 读取第一个字节：h
        System.out.println("buf 读取第一个字节：" + (char) buf.readByte());
        // buf 可读的字节数 10
        System.out.println("buf 可读的字节数 " + buf.readableBytes());
        // buf 读取下标为 5 的值：,
        System.out.println("buf 读取下标为 5 的值：" + (char) buf.getByte(5));
        // buf 从下标为 6 的位置，读取 5 个字节：netty
        System.out.println("buf 从下标为 6 的位置，读取 5 个字节：" + buf.getCharSequence(6, 5, CharsetUtil.UTF_8));
    }

    @Test
    public void testBufRead() {
        ByteBuf buf = Unpooled.buffer(10);
        buf.writeByte(0);
        buf.writeByte(0);
        buf.writeByte(0);
        buf.writeByte('A');
        // int 是4个字节，readInt 即一次性全部读完
        System.out.println(buf.readInt());
    }

}
