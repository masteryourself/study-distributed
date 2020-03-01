package pers.masteryourself.study.search.es.spring.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * <p>description : UserEntity
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/29 2:04
 */
@Document(indexName = "masteryourself", type = "user")
@Data
public class UserEntity {

    @Id
    private Long id;

    private String name;

    private int sex;

    private int age;

}
