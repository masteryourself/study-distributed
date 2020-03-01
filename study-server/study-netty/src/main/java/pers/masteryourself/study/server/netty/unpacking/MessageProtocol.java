package pers.masteryourself.study.server.netty.unpacking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>description : MessageProtocol
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/18 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageProtocol {

    private int length;

    private byte[] content;

}
