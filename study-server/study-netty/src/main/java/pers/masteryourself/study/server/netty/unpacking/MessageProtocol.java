package pers.masteryourself.study.server.netty.unpacking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : MessageProtocol
 * @date : 2020/2/18 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageProtocol {

    private int length;

    private byte[] content;

}
