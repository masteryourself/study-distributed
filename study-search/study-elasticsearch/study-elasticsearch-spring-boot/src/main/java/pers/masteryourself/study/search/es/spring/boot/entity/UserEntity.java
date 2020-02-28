package pers.masteryourself.study.search.es.spring.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author : masteryourself
 * @version : 1.0.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : pers.masteryourself.study.search.es.spring.boot.entity.UserEntity
 * @date : 2020/2/29 1:53
 */
@Document(indexName = "masteryourself", type = "user")
@Data
public class UserEntity {

    @Id
    private String id;

    private String name;

    private int sex;

    private int age;

}
